package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Product;
import ru.netology.product.Book;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(1, 900, "author1", "name1");
    Book book2 = new Book(2, 700, "author2", "name1");
    Book book3 = new Book(3, 600, "author3", "name3");
    Smartphone smartphone1 = new Smartphone(4, 10000, "name4", "maker1");
    Smartphone smartphone2 = new Smartphone(5, 20000, "name5", "maker2");
    Smartphone smartphone3 = new Smartphone(6, 30000, "name6", "maker3");
    Book book4 = new Book(4, 800, "author3", "name7");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldSaveNewProduct() {
        manager.add(book4);

        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {

        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByName() {

        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("name3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNameNotExistBook() {
        manager.add(book1);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("name8");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {

        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("name5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNameNotExistSmartphone() {
        manager.add(smartphone2);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("name9");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNotProduct() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("name10");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBooksByName() {

        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy("name1");

        Assertions.assertArrayEquals(expected, actual);
    }
}
