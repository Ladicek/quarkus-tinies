package cz.ladicek.quarkus.tiny.kafka;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;

@ApplicationScoped
public class Producer {
    @Outgoing("ticks-producer")
    public Multi<Message<String>> produce() {
        return Multi.createFrom()
                .ticks().every(Duration.ofMillis(500))
                .map(it -> KafkaRecord.of("" + it, "" + it));
    }
}
