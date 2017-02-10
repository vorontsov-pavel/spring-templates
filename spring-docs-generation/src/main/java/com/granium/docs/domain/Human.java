package com.granium.docs.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by Sasha.Chepurnoi on 08.02.17.
 */
public class Human {
    @NotNull
    private String name;

    @NotNull
    private String lastname;


    public Human(){

    }
    public Human(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
