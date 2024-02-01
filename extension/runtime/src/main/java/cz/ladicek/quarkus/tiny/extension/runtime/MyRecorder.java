package cz.ladicek.quarkus.tiny.extension.runtime;

import io.quarkus.logging.Log;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class MyRecorder {
    public void doSomething() {
        Log.info("I'm here!");
    }
}
