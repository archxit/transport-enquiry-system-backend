package com.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.transport")
@ComponentScan(basePackages = "com.transport")
@EnableTransactionManagement
public class VoiceTransportSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(VoiceTransportSystemApplication.class, args);
    }
}
