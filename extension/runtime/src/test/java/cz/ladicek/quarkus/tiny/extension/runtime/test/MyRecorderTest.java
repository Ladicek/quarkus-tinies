package cz.ladicek.quarkus.tiny.extension.runtime.test;

import cz.ladicek.quarkus.tiny.extension.runtime.MyRecorder;
import org.junit.jupiter.api.Test;

public class MyRecorderTest {
    @Test
    public void test() {
        new MyRecorder().doSomething();
    }
}
