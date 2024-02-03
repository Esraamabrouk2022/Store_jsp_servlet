package com.example.demo3.repo;

import com.example.demo3.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private int sequence = 1;
     List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        // Initialize sample data
        products.add(new Product(sequence++, "Product A", 100));
        products.add(new Product(sequence++, "Product B", 150));
        products.add(new Product(sequence++, "Product C", 170));
        products.add(new Product(sequence++, "Product D", 80));
        products.add(new Product(sequence++, "Product E", 120));
        products.add(new Product(sequence++, "Product F", 50));
        products.add(new Product(sequence++, "Product G", 150));
    }
    public Product findProduct(int id){
        return products.stream().filter(p->p.getId()==id).findFirst().orElse(null);
    }

    public List<Product> findProducts() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
    }
    public void updateProduct(int id,Product product){

           for (Product p : products) {
                if (p.getId() == id) {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    break;
                }
            }
      // return products.stream().filter(p->p.getId()==id).re

        }



    public boolean deleteProduct(int id) {
     /*   for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;*/
        return products.removeIf(p -> p.getId() == id);
    }
}