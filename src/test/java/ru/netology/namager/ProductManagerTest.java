package ru.netology.namager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Book book1 = new Book(1, "book1", 100, "author1");
    private Book book2 = new Book(2, "book2", 100, "author1");
    private Book book3 = new Book(3, "book3", 100, "author2");
    private Book book4 = new Book(4, "Nokia", 100, "author2");
    private SmartPhone phone1 = new SmartPhone(5, "phone1", 100, "author1");
    private SmartPhone phone2 = new SmartPhone(6, "phone1", 100, "author2");
    private SmartPhone phone3 = new SmartPhone(7, "Nokia", 100, "Nokia");


    @Test
    public void shouldSearchBy() {
        Product [] returned = new Product[] {book1, book2, book3};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[] {book1, book2};
        Product[] actual = manager.searchBy("author1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWithPhone() {
        Product [] returned = new Product[] {book1, book2, book3, phone1, phone2};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[] {book1, book2, phone1};
        Product[] actual = manager.searchBy("author1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFindNone() {
        Product [] returned = new Product[] {book1, book2, book3, phone1, phone2};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("author5");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFindName() {
        Product [] returned = new Product[] {book1, book2, book3, book4, phone1, phone2, phone3};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[] {book4, phone3};
        Product[] actual = manager.searchBy("Nokia");

        assertArrayEquals(expected, actual);
    }





}