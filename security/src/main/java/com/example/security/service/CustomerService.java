package com.example.security.service;

import com.example.security.dto.customer.CreateCustomerRequest;
import com.example.security.dto.customer.UpdateCustomerRequest;
import com.example.security.entity.Customer;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CustomerService {
    List<Customer> getList(int isDelete);//role sale person
    Customer getById(String customerId);// customer infor
    String create(CreateCustomerRequest request) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ChangeSetPersister.NotFoundException;
    String edit(UpdateCustomerRequest request) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ChangeSetPersister.NotFoundException;
    String delete(List<String> Ids);//role sale person
}
