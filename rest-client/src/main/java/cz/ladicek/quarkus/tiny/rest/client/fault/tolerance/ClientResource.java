package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/ft-client")
public class ClientResource {
    @Inject
    @RestClient
    HelloClient client;

    @GET
    public String get() {
        return client.hello().await().indefinitely();
    }
}
