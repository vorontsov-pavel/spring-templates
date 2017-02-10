package com.granium.docs.service;

import com.granium.docs.domain.Doctor;
import com.granium.docs.domain.Driver;
import com.granium.docs.domain.Human;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.*;

/**
 * Created by Sasha.Chepurnoi on 08.02.17.
 */
@Service
public class HumanRepositoryMock implements HumanRepository {

    @Override
    public List<Human> getAllHumans() {
        return asList(
                new Doctor("doctor", "stepan", "Hospital 1"),
                new Driver("driver", "kek", "lada"),
                new Human("Sasha", "Chepurnoi"));
    }

    @Override
    public Human getHumanById(int id) {
        return new Human("Sasha " + id, "Chepurnoi");
    }

    @Override
    public Doctor getDoctorById(int id) {
        return new Doctor("doctor " + id, "stepan", "Hospital 1");
    }

    @Override
    public Driver getDriverById(int id) {
        return new Driver("driver " + id, "kek", "lada");
    }

}
