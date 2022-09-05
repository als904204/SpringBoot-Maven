package com.youtube.aroundhub.data.Service.Impl;

import com.youtube.aroundhub.data.dto.ProductDto;
import com.youtube.aroundhub.data.entity.Product;
import com.youtube.aroundhub.data.handler.Impl.ProductDataHandlerImpl;
import com.youtube.aroundhub.data.handler.ProductDataHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

// 둘중하나 사용 @SpringBootTest 안에 @ExtendWith, @Import 포함되어잇음
// @SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class)
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
class ProductServiceImplTest {


    // ProductServiceImpl 클래스가 ProductDataHandlerImpl 를 주입받고있기 때문에
    // @MockBean 으로 임의객체 생성
    @MockBean
    ProductDataHandlerImpl productDataHandler;

    // Controller 테스트가 아니므로 Autowired 사용
    @Autowired
    ProductServiceImpl productService;

    @DisplayName("상품 get 서비스 테스트")
    @Test
    public void getProductTest() {
        Mockito.when(productDataHandler.getProduct("123"))
                .thenReturn(new Product("123", "pen", 2000, 3000));

        ProductDto productDto = productService.getProduct("123");

        Assertions.assertEquals(productDto.getProductId(), "123");
        Assertions.assertEquals(productDto.getProductName(), "pen");

        verify(productDataHandler).getProduct("123");

    }

    @DisplayName("상품 save 서비스 테스트")
    @Test
    public void saveProductTest() {
        Mockito.when(productDataHandler.saveProduct("123","pen",2000,3000))
                .thenReturn(new Product("123", "pen", 2000, 3000));

        ProductDto productDto = productService.saveProduct("123","pen", 2000, 3000);

        Assertions.assertEquals(productDto.getProductId(), "123");
        Assertions.assertEquals(productDto.getProductName(), "pen");

        verify(productDataHandler).saveProduct("123","pen",2000,3000);

    }

}