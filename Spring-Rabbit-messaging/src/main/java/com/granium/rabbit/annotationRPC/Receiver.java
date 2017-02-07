package com.granium.rabbit.annotationRPC;

import com.granium.rabbit.annotationRPC.message.MessagePacket;
import com.granium.rabbit.annotationRPC.message.PacketResponse;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@Component
@EnableRabbit
public class Receiver {

    @RabbitListener(queues = "rpc-queue")
    public PacketResponse receiveMessage(MessagePacket msg){
        System.out.println("Message Received : " + msg.getContent() + ". Code: " + msg.getCode());
        PacketResponse response = new PacketResponse();
        response.setCode(200);
        response.setResponse("Processed message: " + msg.getContent());
        return response;
    }


}
