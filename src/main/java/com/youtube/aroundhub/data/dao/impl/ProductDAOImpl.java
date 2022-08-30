package com.youtube.aroundhub.data.dao.impl;

import com.youtube.aroundhub.data.dao.ProductDAO;
import com.youtube.aroundhub.data.entity.Product;
import com.youtube.aroundhub.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = productRepository.getById(productId);
        return product;
    }
}
