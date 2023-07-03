package com.progremmerbeginner.spring.config.springbootMessagesSource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessagesSourceTest.TestApplication.class)
public class SpringBootMessagesSourceTest {

    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHelloWanda() {
        Assertions.assertEquals("Hello Wanda",sampleSource.helloWanda(Locale.ENGLISH));
        Assertions.assertEquals("Hello Wanda",sampleSource.helloWanda(new Locale("in","ID")));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleSource implements MessageSourceAware{
            @Setter
            private MessageSource messageSource;

            private String helloWanda(Locale locale){
                return messageSource.getMessage("hello",new Object[]{"Wanda"},locale);
            }
        }

    }

}
