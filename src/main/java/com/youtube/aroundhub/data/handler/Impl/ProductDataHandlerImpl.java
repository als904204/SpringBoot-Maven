package com.youtube.aroundhub.data.handler.Impl;

import com.youtube.aroundhub.data.dao.ProductDAO;
import com.youtube.aroundhub.data.entity.Product;
import com.youtube.aroundhub.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Table 과 1:1 매핑되어있는 클래스
@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

     ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProduct(String productId, String productName, int productPrice, int productStock) {
        Product product = new Product(productId, productName, productPrice, productStock);
        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }
}
