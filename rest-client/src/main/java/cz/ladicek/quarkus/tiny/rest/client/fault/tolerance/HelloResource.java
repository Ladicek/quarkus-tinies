package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ft-hello")
public class HelloResource {
    @GET
    public Response get() {
        return Response.status(Response.Status.BAD_REQUEST).entity("FOOBAR").build();
    }
}
