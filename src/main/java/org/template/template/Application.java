package org.template.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {

    public static void main(String[] args) {
        try {
            System.setProperty("hostname", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            log.error("!!! Fails to get hostname: {}", e.getCause());
            System.setProperty("hostname", "local");
        }

        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        checkProperties(applicationContext.getEnvironment());
    }

    private static void checkProperties(Environment env){
        log.info("hostname: {}", env.getProperty("hostname"));
    }

}
