package com.progremmerbeginner.spring.config.applicationProperties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
@Slf4j
@SpringBootTest(classes = TestApplicationProperties.ApplicationProperties.class)
public class TestApplicationProperties {
    @Autowired
    private Environment  environment;

    @Test
    void testApplicationProperties() {

        String property = environment.getProperty("application.name");
        Assertions.assertEquals("belajar config properties",property);
        log.info("succsess");

    }

    @SpringBootApplication
    public static class ApplicationProperties{

    }
}
