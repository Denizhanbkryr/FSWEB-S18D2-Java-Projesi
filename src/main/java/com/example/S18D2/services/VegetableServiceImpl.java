package com.example.S18D2.services;

import com.example.S18D2.dao.VegetableRepository;
import com.example.S18D2.entity.Vegetable;
import com.example.S18D2.exceptions.PlantException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    private final VegetableRepository vegetableRepository;


    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }
    @Override
    public Vegetable getById(long id) {
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);

        if(optionalVegetable.isPresent()){
            return optionalVegetable.get();
        }
        throw new PlantException("plant with given id is not exist: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable foundFruit = getById(id);
        vegetableRepository.delete(foundFruit);
        return foundFruit;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
