package com.example.S18D2.dto;

import com.example.S18D2.entity.Fruit;
import com.example.S18D2.entity.Vegetable;

public record VegetableResponse(String message, Vegetable vegetable) {
}
