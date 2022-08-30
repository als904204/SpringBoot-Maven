package com.youtube.aroundhub.data.Service.Impl;

import com.youtube.aroundhub.data.Service.ProductService;
import com.youtube.aroundhub.data.dto.ProductDto;
import com.youtube.aroundhub.data.entity.Product;
import com.youtube.aroundhub.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    // 옵션사항
    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }


    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {

        Product productEntity = productDataHandler.saveProduct(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto (
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock()
        );

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        Product productEntity = productDataHandler.getProduct(productId);

        ProductDto productDto = new ProductDto (
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock()
        );
        return productDto;
    }
}
