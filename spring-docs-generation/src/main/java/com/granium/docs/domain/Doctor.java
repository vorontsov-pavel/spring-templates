package com.granium.docs.domain;

/**
 * Created by Sasha.Chepurnoi on 08.02.17.
 */
public class Doctor extends Human {
    private String hospital;

    public Doctor() {
    }

    public Doctor(String name, String lastname, String hospital) {
        super(name, lastname);
        this.hospital = hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

}
