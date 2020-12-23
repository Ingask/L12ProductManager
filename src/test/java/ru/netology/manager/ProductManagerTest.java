package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1896,"English", 1985, "Author1");
    Product book2 = new Book(45698,"Spanish", 123456,"Author1");
    Product book3 = new Book(748596,"Russian", 3256, "Author3");

    Product smartphone1 = new Smartphone(63,"SM1",123456,"M1");
    Product smartphone2 = new Smartphone(14, "S2", 210100,"Samsung");

    @BeforeEach
    void setUp(){
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }
    @Test
    void shouldSearchByBookNameTest(){
        Product[] actual = manager.searchBy("Russian");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchBySmartphoneNameTest() {
        Product[] actual = manager.searchBy("S2");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchByNotFoundWordTest(){
        Product[] actual = manager.searchBy("French");
        Product[] expected = new Product[0];
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldSearchByBookAuthorTest(){
        Product[] actual = manager.searchBy("Author1");
        Product[] expected = new Product[]{book1,book2};
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchByManufacturerTest(){
        Product[] actual = manager.searchBy("m1");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected,actual);
    }


}
