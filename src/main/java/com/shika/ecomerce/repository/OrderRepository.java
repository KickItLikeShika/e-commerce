package com.shika.ecomerce.repository;

import com.shika.ecomerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById(long id);
    List<Order> findOrderByFullname(String fullname);
    List<Order> findOrderByUsername(String username);
    List<Order> findOrderByProductId(long productId);
}
