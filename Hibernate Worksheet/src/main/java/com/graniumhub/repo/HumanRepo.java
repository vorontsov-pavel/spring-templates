package com.graniumhub.repo;

import com.graniumhub.entity.Human;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;


/**
 * Created by Sasha.Chepurnoi on 29.11.16.
 */
public interface HumanRepo extends Repository<Human,Integer> {

    @EntityGraph(attributePaths = {"car", "house", "animal"})
//    @EntityGraph(value = "noCollection")
    Set<Human> findAll();

    Human save(Human human);
}
