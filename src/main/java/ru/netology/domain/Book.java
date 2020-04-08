package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public boolean matchesAuthor(String search){
        if (getAuthor().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return super.matches(search) || matchesAuthor(search);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}