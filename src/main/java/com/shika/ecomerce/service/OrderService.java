package com.shika.ecomerce.service;

import com.shika.ecomerce.dto.OrderDto;
import com.shika.ecomerce.model.Order;
import com.shika.ecomerce.model.Product;
import com.shika.ecomerce.repository.OrderRepository;
import com.shika.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private AuthService authService;
    private ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        AuthService authService,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.authService = authService;
        this.productRepository = productRepository;
    }

    public List<Order> getAllOrders() {
        User user = authService.getCurrUser();
        String username = user.getUsername();
        List<Order> orders = orderRepository.findOrderByUsername(username);
        return orders;
    }

    public String addToCart(OrderDto orderDto) {
        Order order = mapOrder(orderDto);
        orderRepository.save(order);
        return "ADDED TO CART!";
    }

    private Order mapOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setProductId(orderDto.getProductId());
        order.setUsername(authService.getCurrUser().getUsername());
        order.setFullname(orderDto.getFullname());
        order.setAddress(orderDto.getAddress());
        order.setCity(orderDto.getCity());
        order.setZip(orderDto.getZip());
        order.setPhone(orderDto.getPhone());
        Product product = productRepository.findProductById(orderDto.getProductId());
        String price = product.getPrice();
        String totalPrice = checkTotalPrice(price);
        order.setTotalPrice(totalPrice);
        return order;
    }

    private String checkTotalPrice(String price) {
        if(price.endsWith("$")) {
            return price;
        } else {
            return price + "$";
        }
    }
}
