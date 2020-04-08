package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public boolean matchesManufacturer(String search){
        if (getManufacturer().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return super.matches(search) || matchesManufacturer(search);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}