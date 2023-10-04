package cz.ladicek.quarkus.tiny.rest.client.json;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Arrays;
import java.util.List;

@Path("/person")
public class PersonResource {
    @GET
    public List<Person> get() {
        return Arrays.asList(
                new Person("John Doe", 42),
                new Person("Jane Doe", 24)
        );
    }
}
