package com.example.S18D2.services;

import com.example.S18D2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getByPriceAsc();

    Vegetable getById(long id);

    List<Vegetable> getByPriceDesc();
    Vegetable save(Vegetable vegetable);

    Vegetable delete(long id);

    List<Vegetable> searchByName(String name);
}