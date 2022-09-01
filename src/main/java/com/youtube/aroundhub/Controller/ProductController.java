package com.youtube.aroundhub.Controller;

import com.youtube.aroundhub.common.Constants;
import com.youtube.aroundhub.common.exception.AroundHubException;
import com.youtube.aroundhub.data.Service.Impl.ProductServiceImpl;
import com.youtube.aroundhub.data.Service.ProductService;
import com.youtube.aroundhub.data.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
    private ProductService productService;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Around Hub API.", "getProduct");
        ProductDto productDto = productService.getProduct(productId);


        LOGGER.info("[ProductController] Response :: productId={}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getProductPrice(),
                productDto.getProductStock(),
                (System.currentTimeMillis() - startTime));
        return productDto;
    }

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {

        // if you don't use valid OR you can't use Valid then you have to write this code
        /**
         if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) {
         LOGGER.error("productId is empty...!");
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
         }
         **/

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);
        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // http://localhost:8080/api/v1/product-api/product
    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws AroundHubException {
        throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다");
    }
}
