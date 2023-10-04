package cz.ladicek.quarkus.tiny.rest.client.errors;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URI;

@Path("/hello-client-programmatic")
public class ProgrammaticClientResource {
    @GET
    public String get() {
        HelloClient client = RestClientBuilder.newBuilder()
                .baseUri(URI.create("http://localhost:8080"))
                .build(HelloClient.class);

        try {
            return client.hello();
        } catch (WebApplicationException e) {
            Log.error("Hello service failed: " + e.getResponse().readEntity(String.class));
            return "FAILED";
        }
    }
}
