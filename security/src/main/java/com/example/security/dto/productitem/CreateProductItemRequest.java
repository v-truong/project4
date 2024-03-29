package com.example.security.dto.productitem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductItemRequest {
    private String Name;
    private String price;
    private String productId;
    private String technicalId;
    private String quantity;
    private String storeId;
}
