package com.granium.rabbit.javaconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Queue queue(){
        return new Queue("test",false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("test-topic");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("test");

    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory factory, MessageListenerAdapter listenerAdapter){
        System.out.println("Java config...");
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.setQueueNames("test");
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }



}
