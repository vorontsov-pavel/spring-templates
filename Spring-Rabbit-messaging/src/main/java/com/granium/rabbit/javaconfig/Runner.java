package com.granium.rabbit.javaconfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        System.out.println("Java config...");

        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend("test", "Hello from RabbitMQ!");
        Thread.sleep(5000);
        context.close();
    }

}