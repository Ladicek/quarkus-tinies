package cz.ladicek.quarkus.tiny.rest.client.errors;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "http://localhost:8080")
@Path("/hello")
public interface HelloClient {
    @GET
    String hello();
}
