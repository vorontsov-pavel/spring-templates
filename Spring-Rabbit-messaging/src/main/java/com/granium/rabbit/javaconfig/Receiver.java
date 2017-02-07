package com.granium.rabbit.javaconfig;

import org.springframework.stereotype.Component;

/**
 * Created by Sasha.Chepurnoi on 02.02.17.
 */
@Component
public class Receiver {

    public void receiveMessage(String msg){
        System.out.println(msg);
    }

}
