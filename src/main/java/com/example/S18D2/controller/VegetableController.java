package com.example.S18D2.controller;

import com.example.S18D2.dto.VegetableResponse;
import com.example.S18D2.entity.Vegetable;
import com.example.S18D2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }
    @GetMapping
    public List<Vegetable> get(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc(){
        return  vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public VegetableResponse getById(@Positive @PathVariable Long id){
        return new VegetableResponse("succeed", vegetableService.getById(id));
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@Size(min = 2,max = 45) @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id){
        return vegetableService.delete(id);
    }
}


