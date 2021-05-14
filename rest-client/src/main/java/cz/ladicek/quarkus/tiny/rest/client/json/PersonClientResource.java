package cz.ladicek.quarkus.tiny.rest.client.json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
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
