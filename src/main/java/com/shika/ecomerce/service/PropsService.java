package com.shika.ecomerce.service;

import com.shika.ecomerce.dto.ProductDto;
import com.shika.ecomerce.dto.RegisterRequest;
import com.shika.ecomerce.model.Order;
import com.shika.ecomerce.model.Product;
import com.shika.ecomerce.model.User;
import com.shika.ecomerce.repository.OrderRepository;
import com.shika.ecomerce.repository.ProductRepository;
import com.shika.ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropsService {

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private AuthService authService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public PropsService(UserRepository userRepository,
                        ProductRepository productRepository,
                        OrderRepository orderRepository,
                        AuthService authService,
                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
    }

    public String editUser(RegisterRequest registerRequest) {
        User user = mapEditingUser(registerRequest);
        userRepository.save(user);
        return "User has been updated!";
    }

    private User mapEditingUser(RegisterRequest registerRequest) {
        org.springframework.security.core.userdetails.User currUser = authService.getCurrUser();
        String currUsername = currUser.getUsername();
        User user = userRepository.findUserByUsername(currUsername);
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEnabled(true);
        return user;
    }

    public String editProduct(ProductDto productDto, long id) {
        Product product = mapEditingProduct(productDto, id);
        productRepository.save(product);
        return "Product has been updated!";
    }

    private Product mapEditingProduct(ProductDto productDto, long id) {
        Product product = productRepository.findProductById(id);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        editOrdersRelatedToProduct(product);
        return product;
    }

    private void editOrdersRelatedToProduct(Product product) {
        long id = product.getId();
        List<Order> orders = orderRepository.findOrderByProductId(id);
        for(int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            order.setTotalPrice(product.getPrice());
        }
    }

    public String cancelOrder(long id) {
        Order order = orderRepository.findOrderById(id);
        orderRepository.delete(order);
        return "Order has been canceled!";
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
