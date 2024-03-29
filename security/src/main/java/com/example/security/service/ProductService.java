package com.example.security.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.example.security.dto.product.CreateProductRequest;
import com.example.security.dto.product.UpdateProductRequest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;

import com.example.security.dto.product.SearchProductRequest;
import com.example.security.entity.Product;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    List<Product> getallProduct();
    Product getById(String id) throws NotFoundException;
    Product createProduct(CreateProductRequest request) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
    String deleteByIdProduct(List<String> ids) throws NotFoundException;
    Page<Product> advanceSearch(String filter, SearchProductRequest searchProductRequest, Pageable pageable);
    Product update(String id,UpdateProductRequest request) throws NotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException;
}
