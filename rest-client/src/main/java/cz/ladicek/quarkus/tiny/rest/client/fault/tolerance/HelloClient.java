package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
