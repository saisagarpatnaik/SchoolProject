package com.schoolapplication.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication {

    private static final Logger log = LoggerFactory.getLogger(SchoolApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
        log.info("The Project is running successfully");
        try{
            log.info("The Project is running successfully");
        }

        catch (Exception e){
            log.info("The Project is running successfully");
        }

        finally {
            log.info("The Project is running successfully");
        }

        //System.out.println("The Project is running successfully");
    }

}
