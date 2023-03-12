package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Product;
import ru.netology.product.Book;
import ru.netology.product.Smartphone;
import ru.netology.notfoundexception.NotFoundException;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1, 900, "author1", "name1");
    Book book2 = new Book(2, 700, "author2", "name2");
    Book book3 = new Book(3, 600, "author3", "name3");
    Smartphone smartphone1 = new Smartphone(4, 10000, "name4", "maker1");
    Smartphone smartphone2 = new Smartphone(5, 20000, "name5", "maker2");
    Smartphone smartphone3 = new Smartphone(6, 30000, "name6", "maker3");
    Book book4 = new Book(4, 800, "author3", "name7");


    // Тест генерации NotFoundException при попытке удаления несуществующего элемента
    @Test
    public void shouldNotRemoveByIdBecauseNoElement() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(7);
        });
    }

    //    Тест удаления существующего элемента
    @Test
    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(book2);

        repo.removeById(1);

        Product[] expected = new Product[]{book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSaveAndFindAll() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Assertions.assertEquals(repo.findAll().length, 6);
    }

    @Test
    public void shouldSaveNewProduct() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(book4);

        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}