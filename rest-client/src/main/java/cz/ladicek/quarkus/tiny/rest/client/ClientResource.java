package cz.ladicek.quarkus.tiny.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.client.exception.WebApplicationExceptionWrapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

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
            log.error("Hello service failed: "+ WebApplicationExceptionWrapper.unwrap(e).getResponse().readEntity(String.class));
            return "FAILED";
        }
    }
}
