
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.Manager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);

    Product product1 = new Book(1, "Толстый и тонкий", 200, "А.Чехов");
    Product product2 = new Smartphone(2, "G8S ThinQ", 37000, "LG");
    Product product3 = new Book(3, "Анна Каренина", 150, "Л.Толстой");
    Product product4 = new Smartphone(4, "iPhone", 40000, "Apple");
    Product product5 = new Product(5, "Pineapple", 50);

    @Test
    public void shouldSearchByNameBook() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        String search = "анна каренина";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBookIfNotExist() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        String search = "преступление и наказание";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmart() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        String search = "iphone";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmart() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        String search = "lg";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorBook() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        String search = "а.чехов";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByItem() {

        repository.save(product1);
        repository.save(product2);
        repository.save(product4);
        repository.save(product5);
        repository.save(product3);

        String search = "pineapple";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{product5};
        assertArrayEquals(expected, actual);
    }

}