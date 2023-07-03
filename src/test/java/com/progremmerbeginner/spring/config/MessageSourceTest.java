package com.progremmerbeginner.spring.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

    private ApplicationContext applicationContext;

    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    @Test
    void testDefaultLocal() {
        String hello = messageSource.getMessage("hello", new Object[]{"wanda"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello wanda",hello);
    }
    @Test
    void testIndonesiaLocal() {
        String hello = messageSource.getMessage("hello", new Object[]{"wanda"}, new Locale("in_ID"));
        Assertions.assertEquals("Halo wanda",hello);
    }

    @SpringBootApplication
    public static class TestApplication {

        @Bean
        public MessageSource messageResource(){

            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames("my");
            return messageSource;
        }
    }

}
