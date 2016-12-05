package com.graniumhub;

import com.graniumhub.entity.*;
import com.graniumhub.repo.*;
import com.graniumhub.service.TestService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Set;

import static org.springframework.transaction.TransactionDefinition.PROPAGATION_NOT_SUPPORTED;

/**
 * Created by Sasha.Chepurnoi on 29.11.16.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@WebAppConfiguration
@Transactional
public class ComplexEntityTest {

    @Autowired
    private TestService testService;

    @Autowired
    private DogRepo dogRepo;


    @Autowired
    private HumanRepo humanRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private AnimalRepo animalRepo;
    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        System.out.println("\n\n");
    }


    @After
    public void tearDown() throws Exception {
        try {
            em.flush();
        }catch (Exception e){
            System.out.println("Cant flush, exception: " + e.getMessage());
        }
        System.out.println("\n\n");

    }

    @Test
    @Ignore
    public void changeAttachedEntity() throws Exception {
        testService.loadHumanWithChangesToAttachedEntity("lol");
    }

    @Test
    @Ignore
    public void collectionsUpdate() throws Exception {
        Iterable<Human> humans = testService.loadHumanWithCollectionIter();
        humans.forEach(obj -> obj.getAnimal().size());
        System.out.println("end");
    }

    @Test
    @Ignore
    public void addAnimal() throws Exception {
        testService.addAnimal();
        System.out.println("end");
    }


    @Test
//    @Ignore
    public void getAllEager() throws Exception {
        Set<Human> humans = testService.loadAllHumansWithEverythingEager();
        System.out.println("Total count of humans: " + humans.size());
    }

    @Test
    @Ignore
    public void addHumanFromAnimalPersistAnimal() throws Exception {
        testService.addHumanFromAnimal();
        System.out.println("end");
    }


    @Test
    @Ignore
    public void deleteOrphanHouse() throws Exception {
        testService.deleteOrphanHouse();
        System.out.println("end");

    }

    @Test
    @Ignore
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void UnmanagedEntityObject() throws Exception {
        Dog dog = testService.findDog();
        testService.renameDog(dog);
        System.out.println("end");

    }

    @Test
    @Ignore
    @Rollback(value = false)
    public void populateDB() throws Exception {

        for (int i = 0; i < 10000; i++) {
            Human human = new Human();
            human.setName("Human " + i);
            Car car = new Car();
            car.setBrand("Car " + i);

            House house = new House();
            house.setQuater("House " + i);

            human.setCar(car);
            human.setHouse(house);

            human = humanRepo.save(human);
            for (int j = 0; j < 100; j++) {
                Animal animal = new Dog();
                animal.setName("Dog " + j + "of Human " + i);
                animal.setHuman(human);
                animalRepo.save(animal);
            }

        }

    }
}
