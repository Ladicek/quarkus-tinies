package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface HelloClient {
    @GET
    @Path("/ft-hello")
    @NonBlocking
    @Fallback(HelloFallback.class)
    //@Fallback(fallbackMethod = "fallback")
    Uni<String> hello();

    default Uni<String> fallback() {
        return Uni.createFrom().item("Hello fallback!");
    }

    class HelloFallback implements FallbackHandler<Uni<String>> {
        @Override
        public Uni<String> handle(ExecutionContext context) {
            return Uni.createFrom().item("Hello fallback!");
        }
    }
}
