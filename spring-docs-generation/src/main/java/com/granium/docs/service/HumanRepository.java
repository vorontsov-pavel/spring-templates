package com.granium.docs.service;

import com.granium.docs.domain.Doctor;
import com.granium.docs.domain.Driver;
import com.granium.docs.domain.Human;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sasha.Chepurnoi on 08.02.17.
 */
public interface HumanRepository {

    List<Human> getAllHumans();
    Human getHumanById(int id);
    Doctor getDoctorById(int id);
    Driver getDriverById(int id);

}
