package cz.ladicek.quarkus.tiny.kafka;

import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class Consumer {
    @Incoming("ticks-consumer")
    public CompletionStage<Void> consume(KafkaRecord<String, String> message) {
        System.out.println("got " + message.getKey());
        return message.ack();
    }
}
