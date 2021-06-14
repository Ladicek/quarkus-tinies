package cz.ladicek.quarkus.tiny.rest.client.fault.tolerance;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
