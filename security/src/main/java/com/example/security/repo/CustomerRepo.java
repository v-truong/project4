package com.example.security.repo;

import com.example.security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    List<Customer> findAllByIsDelete(int isDelete);
}
