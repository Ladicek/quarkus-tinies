package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/ft-client")
public class ClientResource {
    private static final Logger log = Logger.getLogger(ClientResource.class);

    @Inject
    @RestClient
    HelloClient client;

    @GET
    public String get() {
        return client.hello().await().indefinitely();
    }
}
