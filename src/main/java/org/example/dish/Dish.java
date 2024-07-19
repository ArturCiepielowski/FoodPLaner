package org.example.dish;

import jakarta.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dish_id;
    private String name;
    private String description;

    public Long getId() {
        return dish_id;
    }

    public void setId(Long dish_id) {
        this.dish_id = dish_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dish_id=" + dish_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Dish() {
    }

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
