package com.youtube.aroundhub.data.dao;

import com.youtube.aroundhub.data.entity.Product;

public interface ProductDAO {
    Product saveProduct(Product product);

    Product getProduct(String productId);
}
