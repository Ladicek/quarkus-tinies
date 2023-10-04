package cz.ladicek.quarkus.tiny.rest.client.errors;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.client.exception.WebApplicationExceptionWrapper;

@Path("/client")
public class ClientResource {
    private static final Logger log = Logger.getLogger(ClientResource.class);

    @Inject
    @RestClient
    HelloClient client;

    @GET
    public String get() {
        try {
            return client.hello();
        } catch (WebApplicationException e) {
            log.error("Hello service failed: " + WebApplicationExceptionWrapper.unwrap(e).getResponse().readEntity(String.class));
            return "FAILED";
        }
    }
}
