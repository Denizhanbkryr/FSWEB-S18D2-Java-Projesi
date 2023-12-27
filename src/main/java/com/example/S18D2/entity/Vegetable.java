package com.example.S18D2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vegetable",schema = "fsweb")
public class Vegetable extends Plant {

    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}