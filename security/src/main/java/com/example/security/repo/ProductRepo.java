package com.example.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.security.entity.Product;

public interface ProductRepo extends  JpaRepository<Product,String>{

   List<Product> findAllByName(String name);
   // @Query("from product e where e.isdelete in ?1")
   // List<Product> findAllbyIsDelete(Boolean isDelete);
}
