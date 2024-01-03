package com.example.security.service.Implement;

import com.example.common.config.Constants;
import com.example.security.dto.category.CreateCategoryRequest;
import com.example.security.entity.Category;
import com.example.security.repo.CategoryRepo;
import com.example.security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryImpl implements CategoryService {
    @Autowired private CategoryRepo categoryRepo;
    @Override
    public List<Category> getall() {
        return categoryRepo.findAllByIsDelete(Constants.ISDELETE_TRUE);
    }

    @Override
    public String create(CreateCategoryRequest request) {
        return null;
    }
}
