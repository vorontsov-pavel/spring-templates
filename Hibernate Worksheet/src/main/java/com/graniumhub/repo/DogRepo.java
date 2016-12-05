package com.graniumhub.repo;

import com.graniumhub.entity.Dog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sasha.Chepurnoi on 30.11.16.
 */
public interface DogRepo extends CrudRepository<Dog,Integer> {
}
