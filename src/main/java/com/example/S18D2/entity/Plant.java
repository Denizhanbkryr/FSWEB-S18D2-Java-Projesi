package com.example.S18D2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotNull
    @Size(min=2,max = 45,message = "Name size must be between 2 to 45")
    private String name;

    @Column(name = "price")
    @DecimalMin("10")
    private Double price;
}
