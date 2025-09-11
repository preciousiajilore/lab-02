package com.example.listycisty_preciousajilore;

import java.util.Objects;
public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return name.isEmpty();
    }

    @Override
    public String toString() {
        return name;
    }
}
