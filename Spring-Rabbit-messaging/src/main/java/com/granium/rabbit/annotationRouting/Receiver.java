package com.granium.rabbit.annotationRouting;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@Component
@EnableRabbit
public class Receiver {

    @RabbitListener(queues = "messageQueue")
    public void receiveMessage(String msg){
        System.out.println("Message Receiver : " + msg);

    }


    @RabbitListener(queues = "errorQueue")
    public void receiveMessageToo(String msg){
        System.out.println("Error Receiver: " + msg);
    }

}
