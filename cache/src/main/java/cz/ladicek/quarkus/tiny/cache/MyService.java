package cz.ladicek.quarkus.tiny.cache;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {
    @CacheResult(cacheName = "my-cache")
    public String hello() {
        return "Hello, world!";
    }
}
