package ru.netology.namager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;


public class ProductManager {

    private ProductRepository repository = new ProductRepository();

    public Product[] getAll() {
        Product[] items = repository.findAll();
        return items;
    }

    public Product[] searchBy (String text) {
        Product [] products = getAll();
        Product[] tmp;
        Product[] result = new Product[0];
        int index = 1;

        for (Product product : products) {
            boolean ifMatch = matches(product, text);
            if (ifMatch) {
                tmp = new Product[index];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;
                result = tmp;
                index++;
            }

        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        else if (product instanceof SmartPhone) {
            SmartPhone smartPhone = (SmartPhone) product;
            if (smartPhone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartPhone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        else {
            return false;
        }
    }


}
