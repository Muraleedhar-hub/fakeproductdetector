package com.sns.fake.product.detector.service;

import com.sns.fake.product.detector.entities.ProductInfo;
import com.sns.fake.product.detector.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public ProductInfo getProductInfo(String code){
        return productRepository.findItemById(code);
    }

    public String updateProductInfo(String code, ProductInfo productInfo){
        return productRepository.updateProductInfo(code, productInfo);
    }
}
