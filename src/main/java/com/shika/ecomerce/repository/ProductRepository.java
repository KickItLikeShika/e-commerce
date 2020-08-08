package com.shika.ecomerce.repository;

import com.shika.ecomerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(long id);
    List<Product> findProductByNameLike(String name);
}
