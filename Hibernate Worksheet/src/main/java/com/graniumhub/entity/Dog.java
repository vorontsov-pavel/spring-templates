package com.graniumhub.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Sasha.Chepurnoi on 29.11.16.
 */

@Entity
@Table(name = "dog")
@PrimaryKeyJoinColumn(name = "animal_id", referencedColumnName = "id")
public class Dog extends Animal {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
