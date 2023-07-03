package com.progremmerbeginner.spring.config.Environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {
    @Autowired
    private Environment environment;

    @Test
    void testJavaHome() {

        String java_home = environment.getProperty("JAVA_HOME");
        Assertions.assertEquals("C:\\Java\\javafx-sdk-18.0.2",java_home);
    }

    @SpringBootApplication
    public static class TestApplication{

    }
}
