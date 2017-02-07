package com.granium.rabbit.annotationRPC.message;

import java.io.Serializable;

/**
 * Created by Sasha.Chepurnoi on 07.02.17.
 */
public class MessagePacket implements Serializable{
    public static final long serialVersionUID = 1000L;


    private String content;
    private int code;

    public MessagePacket(String content, int code) {
        this.content = content;
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
