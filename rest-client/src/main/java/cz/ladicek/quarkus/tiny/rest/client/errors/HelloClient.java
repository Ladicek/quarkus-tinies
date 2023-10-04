package cz.ladicek.quarkus.tiny.rest.client.errors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080")
@Path("/hello")
public interface HelloClient {
    @GET
    String hello();
}
