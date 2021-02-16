package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "book1", 100, "author1");
    private Book book2 = new Book(2, "book2", 100, "author1");
    private Book book3 = new Book(3, "book3", 100, "author2");
    private SmartPhone phone1 = new SmartPhone(4, "phone1", 100, "author1");
    private SmartPhone phone2 = new SmartPhone(5, "phone1", 100, "author2");

    @Test
    public void shouldSaveItem() {

        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);

        Product[] expected = new Product[] {book1, book2, phone1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

}