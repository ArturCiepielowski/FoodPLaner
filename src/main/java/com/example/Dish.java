package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "dish2") //todo Remeber to change back to dish
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dish_id;
    private String description;
    private String name;

    public Dish() {
    }

    public Dish(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Long getDish_id() {
        return dish_id;
    }

    public void setDish_id(Long dish_id) {
        this.dish_id = dish_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
