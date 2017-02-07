package com.granium.rabbit.annotation;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@Component
@EnableRabbit
public class Receiver {

    @RabbitListener(queues = "test")
    public void receiveMessage(String msg){
        System.out.println("Receiver 1: " + msg);

    }


    @RabbitListener(queues = "test")
    public void receiveMessageToo(String msg){
        System.out.println("Receiver 2: " + msg);
    }

}
