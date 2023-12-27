package com.example.S18D2.dao;

import com.example.S18D2.entity.Fruit;
import com.example.S18D2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
    @Query(value = "SELECT v.id,v.name,v.price,v.vegetable_type FROM fsweb.vegetable as v " +
            "ORDER BY v.price DESC",
            nativeQuery = true)
    List<Vegetable> getByPriceDesc();
    @Query(value = "SELECT v.id,v.name,v.price,v.vegetable_type FROM fsweb.vegetable as v " +
            "ORDER BY v.price ASC",
            nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
