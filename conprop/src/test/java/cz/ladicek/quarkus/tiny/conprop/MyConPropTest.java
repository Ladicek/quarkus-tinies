package cz.ladicek.quarkus.tiny.conprop;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MyConPropTest {
    @Inject
    MyConPropUser user;

    @Test
    @ActivateRequestContext
    public void test1() {
        System.out.println("TEST 1");
        System.out.println("======");
        user.doSomething1().join();
    }

    @Test
    @ActivateRequestContext
    public void test2() {
        System.out.println("TEST 2");
        System.out.println("======");
        user.doSomething2().join();
    }
}
