package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}