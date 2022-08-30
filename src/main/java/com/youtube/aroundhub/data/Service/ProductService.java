package com.youtube.aroundhub.data.Service;

import com.youtube.aroundhub.data.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);
}
