package com.youtube.aroundhub.data.repository;

import com.youtube.aroundhub.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
