package com.granium.rabbit.annotationRPC.message;

import java.io.Serializable;

/**
 * Created by Sasha.Chepurnoi on 07.02.17.
 */
public class PacketResponse implements Serializable {
    public static final long serialVersionUID = 1000L;

    private String response;
    private int code;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
