package com.granium.rabbit.annotationRouting;

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
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend("message", "Hello from Annotated RabbitMQ! " + i);
            rabbitTemplate.convertAndSend("error","Error happened");
            Thread.sleep(2000);
        }
        context.close();
    }

}