package cz.ladicek.quarkus.tiny.conprop;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;

import java.util.HashSet;
import java.util.Set;

@RequestScoped
public class MyReqData {
    private final Set<String> data = new HashSet<>();

    public void add(String item) {
        data.add(item);
        System.out.println("[" + Thread.currentThread().getName() + "] " + item + ": " + data);
    }

    public String toString() {
        return data.toString();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[" + Thread.currentThread().getName() + "] destroying: " + data);
    }
}
