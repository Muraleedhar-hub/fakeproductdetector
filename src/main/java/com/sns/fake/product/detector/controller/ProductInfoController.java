package com.sns.fake.product.detector.controller;

import com.sns.fake.product.detector.entities.ProductInfo;
import com.sns.fake.product.detector.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductInfoController {

    @Autowired(required = true)
    public ProductService productService;

    @GetMapping(value = "/checkProduct/{code}", produces = "text/html")
    public String checkProduct(
            @PathVariable(value = "code") String code, Model model) {
        ProductInfo productInfo = productService.getProductInfo(code);
        if (productInfo != null) {
            if (productInfo.getAttempt() == 0) {
                convertData(code, model, productInfo, productService);
                return "product-info";
            } else {
                convertData(code, model, productInfo, productService);
                return "tested-product";
            }
        } else {
            return "fake-product";
        }
    }

    private static void convertData(String code, Model model, ProductInfo productInfo, ProductService productService) {
        productInfo.setAttempt(productInfo.getAttempt() + 1);
        code = productService.updateProductInfo(code, productInfo);
        model.addAttribute("name", productInfo.getName());
        model.addAttribute("price", productInfo.getPrice());
        model.addAttribute("description", productInfo.getDescription());
        model.addAttribute("factoryCode", productInfo.getFactoryCode());
        model.addAttribute("outLetCode", productInfo.getOutLetCode());
        model.addAttribute("productId", productInfo.getProductId());
        model.addAttribute("manufactureDate", productInfo.getManufactureDate());
        model.addAttribute("expireDate", productInfo.getExpireDate());
    }

}