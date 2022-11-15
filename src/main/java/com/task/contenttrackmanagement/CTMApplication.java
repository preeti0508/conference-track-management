package com.task.contenttrackmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Conference Management System</h1>
 * This is the main class it accepts the request and
 * send it to the Conference Track controller
 *
 * @author Preeti Verma
 */
@SpringBootApplication
public class CTMApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("CTMApplication");

        logger.info("Application started...");
        SpringApplication.run(CTMApplication.class, args);
    }
}
