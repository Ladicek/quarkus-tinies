package cz.ladicek.quarkus.tiny.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {
    @GET
    public Response get() {
        return Response.status(Response.Status.BAD_REQUEST).entity("FOOBAR").build();
    }
}
