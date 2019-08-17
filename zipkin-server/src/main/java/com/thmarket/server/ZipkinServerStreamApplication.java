package com.thmarket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerStreamApplication {
    private static Logger log = LoggerFactory.getLogger(ZipkinServerStreamApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerStreamApplication.class, args);
        log.info("zipkin server starting!");
    }
}
