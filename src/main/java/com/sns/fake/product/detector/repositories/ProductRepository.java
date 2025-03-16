package com.sns.fake.product.detector.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.sns.fake.product.detector.entities.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public class ProductRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public ProductInfo findItemById(String tokenCode) {
        return mapper.load(ProductInfo.class, tokenCode);
    }

    public String updateProductInfo(String tokenCode, ProductInfo productInfo) {
        mapper.save(productInfo,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("ID",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(tokenCode)
                                )));
        return tokenCode;
    }

}
