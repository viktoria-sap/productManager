package ru.netology.domain;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private String search;

    public Product(int id, String name, int price, String search) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.search = search;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                name.equals(product.name) &&
                search.equals(product.search);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, search);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", search='" + search + '\'' +
                '}';
    }
}
