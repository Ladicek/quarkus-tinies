package cz.ladicek.quarkus.tiny.amqp;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;

@ApplicationScoped
public class Producer {
    @Outgoing("ticks-producer")
    public Multi<Message<String>> produce() {
        return Multi.createFrom()
                .ticks().startingAfter(Duration.ofMillis(2000)).every(Duration.ofMillis(1000))
                .map(it -> Message.of("" + it));
    }
}
