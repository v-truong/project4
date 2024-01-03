package com.example.security.repo;

import com.example.security.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface CategoryRepo extends JpaRepository<Category,String> {
    List<Category> findAllByIsDelete(int isDelete);

}