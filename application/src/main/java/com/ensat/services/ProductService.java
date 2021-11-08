package com.ensat.services;

import com.ensat.entities.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Optional<Product> getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
