package cz.ladicek.quarkus.tiny.logging;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import jakarta.inject.Singleton;

@Singleton
public class MyService {
    @Startup
    void init() {
        Log.info("I'm here!");
        Log.info("IGNORE: This will not show");
    }
}
