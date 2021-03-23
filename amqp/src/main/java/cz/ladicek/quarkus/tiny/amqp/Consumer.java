package cz.ladicek.quarkus.tiny.amqp;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class Consumer {
    @Incoming("ticks-consumer")
    public CompletionStage<Void> consume(Message<String> message) {
        System.out.println("got " + message.getPayload());
        return message.ack();
    }
}
