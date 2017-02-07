package com.granium.rabbit.annotationRouting;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public Queue messageQueue(){
        return new Queue("messageQueue",false);
    }


    @Bean
    public Queue errorQueue(){
        return new Queue("errorQueue",false);
    }


    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct-exchanger");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange("direct-exchanger");
        return template;
    }



    @Bean
    public Binding errorBinding(){
        return BindingBuilder.bind(errorQueue()).to(directExchange()).with("error");
    }

    @Bean
    public Binding messageBinding(){
        return BindingBuilder.bind(messageQueue()).to(directExchange()).with("message");
    }



}
