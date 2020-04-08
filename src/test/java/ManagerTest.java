
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.Manager;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager manager = new Manager();

    Product product1 = new Book(1, "Толстый и тонкий", 200, "А.Чехов");
    Product product2 = new Smartphone(2, "G8S ThinQ", 37000, "LG");
    Product product3 = new Book(3, "Анна Каренина", 150, "Л.Толстой");
    Product product4 = new Smartphone(4, "iPhone", 40000, "Apple");

    @Test
    public void shouldSearchByNameBook() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        String search = "анна каренина";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmart() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        String search = "iphone";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmart() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        String search = "lg";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorBook() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        String search = "а.чехов";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product1};
        assertArrayEquals(expected, actual);
    }

}