package cz.ladicek.quarkus.tiny.rest.client.json;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/person-client")
public class PersonClientResource {
    @GET
    public String get() {
        Client client = ClientBuilder.newClient();
        try {
            Response response = client.target("http://localhost:8080/person").request().get();
            List<Person> persons = response.readEntity(new GenericType<>() {});
            return persons.toString();
        } finally {
            client.close();
        }
    }
}
