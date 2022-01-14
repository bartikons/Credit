package com.springboot.product.product.controler;

import com.springboot.product.product.dto.ProductDto;
import com.springboot.product.product.model.Product;
import com.springboot.product.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ProductControler {

    ProductService productService;

    @Autowired
    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("Product")
    public ResponseEntity<ProductDto> getProduct(@RequestParam Integer creditId) {

        return productService.getProduct(creditId);
    }

    @PostMapping("Product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {

        return productService.createProduct(productDto);
    }
}
