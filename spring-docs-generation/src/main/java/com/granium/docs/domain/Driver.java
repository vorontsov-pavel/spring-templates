package com.granium.docs.domain;

import javax.validation.constraints.Size;

/**
 * Created by Sasha.Chepurnoi on 08.02.17.
 */
public class Driver extends Human {
    @Size(max = 50)
    private String carMark;



    public Driver() {
    }

    public Driver(String name, String lastname, String carMark) {
        super(name, lastname);
        this.carMark = carMark;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }
}
