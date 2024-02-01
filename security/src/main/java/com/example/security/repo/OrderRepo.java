package com.example.security.repo;

import com.example.security.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,String> {
    List<Order> findAllByAccountId(String accountid);
    Optional<Order> findById(String id);
}
