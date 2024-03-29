package com.example.security.ctrl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.example.common.config.enums.SortOrderEnum;
import com.example.common.response.PageResponse;
import com.example.common.util.SearchUtil;
import com.example.security.dto.product.CreateProductRequest;
import com.example.security.dto.product.SearchProductRequest;
import com.example.security.dto.product.UpdateProductRequest;
import com.example.security.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.security.entity.Product;
import com.example.security.repo.ProductRepo;


@RestController
@RequestMapping("/api/v1/product")
public class ProductCtrl {
    @Autowired private ProductRepo productRepo;
    @Autowired private ProductService productService;
    @GetMapping("/{id}")
    public List<Product> getMethodName(@PathVariable("id") String param) {
        return productRepo.findAllByName(param);
    }
    @PostMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<Product> advanceSearch(@RequestParam(required = false) String filter, @Valid @RequestBody SearchProductRequest searchRequest,
                                                  @PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
                                                  @Positive @RequestParam(required = false) Integer size, @RequestParam(required = false) String sort,
                                                  @RequestParam(required = false) SortOrderEnum order){
        Pageable pageable = SearchUtil.getPageableFromParam(page, size, sort, order);
        Page<Product> pageData = productService.advanceSearch(filter, searchRequest, pageable);
//        pageData.getContent().get(1).setName("trughsrkjgkjfdghng");
        System.out.println(pageData.getContent().get(1));
        return new PageResponse<>(pageData);
    }
    @PostMapping(value = "/create")
    public Product create(@RequestBody CreateProductRequest request) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return productService.createProduct(request);

    }
    @PostMapping(value = "/update")
    public Product update(@PathVariable String id, @RequestBody UpdateProductRequest request) throws ChangeSetPersister.NotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return productService.update(id,request);
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestBody List<String> ids) throws ChangeSetPersister.NotFoundException {
        return productService.deleteByIdProduct(ids);
    }
    @PostMapping("/getById")
    public Product getById(@RequestBody String id) throws ChangeSetPersister.NotFoundException {
        return productService.getById(id);
    }
}
