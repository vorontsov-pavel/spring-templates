package com.graniumhub.repo;

import com.graniumhub.entity.House;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sasha.Chepurnoi on 30.11.16.
 */
public interface HouseRepo extends CrudRepository<House,Integer>{
}
