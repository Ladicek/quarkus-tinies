package cz.ladicek.quarkus.tiny.cache;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class MyResource {
    @Inject
    MyService service;

    @GET
    public String hello() {
        return service.hello();
    }
}
