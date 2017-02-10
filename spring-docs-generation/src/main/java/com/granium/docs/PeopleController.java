package com.granium.docs;

import com.granium.docs.domain.Doctor;
import com.granium.docs.domain.Driver;
import com.granium.docs.domain.Human;
import com.granium.docs.service.HumanRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Sasha.Chepurnoi on 08.02.17.
 */
@RestController
@RequestMapping("/people")
public class PeopleController {


    @Autowired
    HumanRepository repo;

    @ApiOperation("Get list of all humans")
    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public List<? extends Human> getAllHumans(){
        return repo.getAllHumans();

    }

    @ApiOperation("Get human by ID")
    @RequestMapping(path = {"humans/{id}"}, method = RequestMethod.GET)
    public Human getHumanById(@PathVariable("id") int id){
        return repo.getHumanById(id);
    }


    @ApiOperation("Get doctor by ID")
    @RequestMapping(path = {"doctors/{id}"}, method = RequestMethod.GET)
    public Doctor getDoctorById(@PathVariable("id") int id){
        return repo.getDoctorById(id);

    }

    @ApiOperation("Get driver by ID")
    @RequestMapping(path = {"drivers/{id}"}, method = RequestMethod.GET)
    public Driver getDriverById(@PathVariable("id") int id){
        return repo.getDriverById(id);
    }



    @ApiOperation("Store list of drivers")
    @RequestMapping(path = {"drivers/list"},consumes = "application/json", method = RequestMethod.POST)
    public Driver testDriver(@RequestBody List<Driver> drivers){
        return repo.getDriverById(0);
    }


    @ApiOperation("Create new driver")
    @RequestMapping(path = {"drivers"},consumes = "application/json", method = RequestMethod.POST)
    public Driver createDriver(@Valid @RequestBody Driver drivers){
        return repo.getDriverById(0);
    }


}
