package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class Manager {

    private Product[] items = new Product[0];

    public Manager() {

    }

    public void add(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product: findAll()) {
            if (matchesBook(product, search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }

            if (matchesSmartphone(product, search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }

        }
        return result;
    }


    public boolean matchesBook(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
            return false;
    }

    public boolean matchesSmartphone(Product product, String search) {
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }

    public Product[] findAll() {
        return items;
    }

}