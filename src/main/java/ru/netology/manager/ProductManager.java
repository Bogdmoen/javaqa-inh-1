package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;


public class ProductManager {

    private ProductRepository repository = new ProductRepository();

    public Product[] getAll() {
        Product[] items = repository.findAll();
        return items;
    }

    public Product[] searchBy (String text) {
        Product[] tmp;
        Product[] result = new Product[0];
        int index = 1;

        for (Product product : getAll()) {
            if (product.matches(text)) {
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
}
