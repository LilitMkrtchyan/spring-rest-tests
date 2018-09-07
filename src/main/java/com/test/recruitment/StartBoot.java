package com.test.recruitment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application entry point
 *
 * @author A525125
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@Slf4j
public class StartBoot {

    public static void main(String[] args) {
        log.info("Start application ...");
        SpringApplication.run(StartBoot.class, args);
    }

}
