package cz.ladicek.quarkus.tiny.conprop;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.context.ThreadContext;

import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class MyConPropUser {
    private final ManagedExecutor clearingExecutor = ManagedExecutor.builder()
            .cleared(ThreadContext.CDI)
            .build();

    private final ManagedExecutor propagatingExecutor = ManagedExecutor.builder()
            .propagated(ThreadContext.CDI)
            .build();

    @Inject
    MyReqData reqData;

    public CompletableFuture<Void> doSomething1() {
        reqData.add("a");

        CompletableFuture<Void> result = clearingExecutor.runAsync(() -> {
            sleep();
            reqData.add("b");
        }).thenCompose(ignored -> clearingExecutor.runAsync(() -> {
            sleep();
            reqData.add("c");
        })).thenCompose(ignored -> clearingExecutor.runAsync(() -> {
            sleep();
            reqData.add("d");
        }));

        reqData.add("e");

        return result;
    }

    public CompletableFuture<Void> doSomething2() {
        reqData.add("a");

        CompletableFuture<Void> result = clearingExecutor.supplyAsync(() -> {
            sleep();
            reqData.add("b");
            return propagatingExecutor.runAsync(() -> {
                sleep();
                reqData.add("c");
            }).thenApplyAsync(ignored -> {
                sleep();
                reqData.add("d");
                return null;
            }).thenComposeAsync(ignored -> propagatingExecutor.runAsync(() -> {
                sleep();
                reqData.add("e");
            })).join();
        });

        reqData.add("f");

        return result;
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
