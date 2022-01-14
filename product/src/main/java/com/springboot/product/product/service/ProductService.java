package com.springboot.product.product.service;

import java.util.Optional;

import com.springboot.product.product.dto.ProductDto;
import com.springboot.product.product.model.Product;
import com.springboot.product.product.repository.ProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<ProductDto> getProduct(Integer creditId) {

        Optional<Product> optionalProduct = productRepository.findById(creditId);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDto productDto = modelMapper.map(optionalProduct.get(), ProductDto.class);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    public ResponseEntity<Product> createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product = productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
