package com.shika.ecomerce.service;

import com.shika.ecomerce.dto.ProductDto;
import com.shika.ecomerce.model.Product;
import com.shika.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private AuthService authService;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          AuthService authService) {
        this.productRepository = productRepository;
        this.authService = authService;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getProductById(long id) {
        Product product = productRepository.findProductById(id);
        return product;
    }

    public List<Product> getProductByName(String name) {
        List<Product> products = productRepository.findProductByNameLike(name);
        return products;
    }

    public String addProduct(ProductDto productDto) {
        Product product = mapProduct(productDto);
        productRepository.save(product);
        return "Product has been Added!";
    }

    private Product mapProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }
}
