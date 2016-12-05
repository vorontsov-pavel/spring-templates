package com.graniumhub.service;

import com.graniumhub.entity.Dog;
import com.graniumhub.entity.Human;

import java.util.Set;

/**
 * Created by Sasha.Chepurnoi on 30.11.16.
 */
public interface TestService {

    Iterable<Human> loadHumanWithChangesToAttachedEntity(String change);

    Set<Human> loadAllHumansWithEverythingEager();

    Iterable<Human> loadHumanWithCollectionIter();

    void addAnimal();

    void addHumanFromAnimal();

    void deleteOrphanHouse();

    Dog findDog();

    void renameDog(Dog dog);
}
