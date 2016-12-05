package com.graniumhub.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Sasha.Chepurnoi on 29.11.16.
 */
@Entity
@Table(name = "human")
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "noCollection",
        attributeNodes = {
                @NamedAttributeNode(value = "house",subgraph = "house"),
                @NamedAttributeNode(value = "car", subgraph = "car")
        })
})
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    private String name;
    private String lastname;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "human",fetch = FetchType.LAZY)
    private List<Animal> animal = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "house_id")
    private House house;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;



    public void addAnimal(Animal an){
        animal.add(an);
        an.setHuman(this);
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
