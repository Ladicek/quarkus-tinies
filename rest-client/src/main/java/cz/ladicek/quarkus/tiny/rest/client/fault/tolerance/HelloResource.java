package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/ft-hello")
public class HelloResource {
    @GET
    public Response get() {
        return Response.status(Response.Status.BAD_REQUEST).entity("FOOBAR").build();
    }
}
