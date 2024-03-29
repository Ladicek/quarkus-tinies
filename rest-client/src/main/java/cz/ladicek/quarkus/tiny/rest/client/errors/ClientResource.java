package cz.ladicek.quarkus.tiny.rest.client.errors;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello-client")
public class ClientResource {
    @Inject
    @RestClient
    HelloClient client;

    @GET
    public String get() {
        try {
            return client.hello();
        } catch (WebApplicationException e) {
            Log.error("Hello service failed: " + e.getResponse().readEntity(String.class));
            return "FAILED";
        }
    }
}
