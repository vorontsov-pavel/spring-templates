package com.graniumhub.repo;

import com.graniumhub.entity.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sasha.Chepurnoi on 30.11.16.
 */
public interface AnimalRepo extends CrudRepository<Animal,Integer> {
}
