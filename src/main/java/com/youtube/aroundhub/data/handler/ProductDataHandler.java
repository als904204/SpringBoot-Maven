package com.youtube.aroundhub.data.handler;

import com.youtube.aroundhub.data.entity.Product;

public interface ProductDataHandler {

    Product saveProduct(String productId, String productName, int productPrice, int productStock);

    Product getProduct(String productId);

}
