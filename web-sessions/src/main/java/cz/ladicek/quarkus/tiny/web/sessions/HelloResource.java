package cz.ladicek.quarkus.tiny.web.sessions;

import io.vertx.ext.web.Session;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Instant;

@Path("/")
public class HelloResource {
    // https://redis.io/docs/stack/get-started/install/docker/
    // docker run -it --rm --name redis -p 6379:6379 -p 8001:8001 redis/redis-stack:latest
    // open http://localhost:8001/

    // https://infinispan.org/get-started/
    // docker run -it --rm --name infinispan -p 11222:11222 -e USER=admin -e PASS=admin quay.io/infinispan/server:latest
    // open http://localhost:11222/

    private static final String TEMPLATE = ""
            + "Session [%s] created on %s%n"
            + "%n"
            + "Counter: %s%n"
            + "%n"
            + "Page generated on %s%n"
            ;

    @Inject
    Session session;

    @GET
    public String get() {
        session.computeIfAbsent("createdOn", s -> System.currentTimeMillis());

        Integer counter = session.get("counter");
        counter = counter == null ? 1 : counter + 1;
        session.put("counter", counter);

        String sessionId = session.id();
        Instant createdOn = Instant.ofEpochMilli(session.get("createdOn"));
        Instant now = Instant.now();

        return String.format(TEMPLATE, sessionId, createdOn, counter, now);
    }
}
