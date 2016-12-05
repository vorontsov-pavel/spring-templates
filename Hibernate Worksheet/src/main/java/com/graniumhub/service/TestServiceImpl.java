package com.graniumhub.service;

import com.graniumhub.entity.Animal;
import com.graniumhub.entity.Dog;
import com.graniumhub.entity.Human;
import com.graniumhub.repo.AnimalRepo;
import com.graniumhub.repo.DogRepo;
import com.graniumhub.repo.HumanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Sasha.Chepurnoi on 30.11.16.
 */

@Transactional
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private HumanRepo humanRepo;


    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    private DogRepo dogRepo;


    @Override
    public Iterable<Human> loadHumanWithChangesToAttachedEntity(String change) {
        Set<Human> all = humanRepo.findAll();
        all.forEach(obj -> obj.setLastname(change));
        return all;
    }

    @Override
    public Set<Human> loadAllHumansWithEverythingEager() {
        Set<Human> all = humanRepo.findAll();
        return all;
    }

    @Override
    public Iterable<Human> loadHumanWithCollectionIter() {
        List<Human> all = humanRepo.findAll().stream().collect(Collectors.toList());
        all.get(0).getAnimal().remove(0);
        return all;
    }


    @Override
    public void addAnimal() {
        Animal dog = new Dog();
        dog.setName("Ivan");
        List<Human> all = humanRepo.findAll().stream().collect(Collectors.toList());
        all.get(0).addAnimal(dog);

    }

    @Override
    public void addHumanFromAnimal() {
        Dog dog = dogRepo.findOne(300);
        Human human = new Human();
        human.addAnimal(dog);
        dogRepo.save(dog);
    }

    @Override
    public void deleteOrphanHouse() {
        List<Human> all = humanRepo.findAll().stream().collect(Collectors.toList());
        all.get(0).setHouse(null);
    }

    @Override
    public Dog findDog() {
        return dogRepo.findOne(300);
    }

    @Override
    public void renameDog(Dog dog) {
        dog.setName("Renamed dog");
        dogRepo.save(dog);
    }
}
