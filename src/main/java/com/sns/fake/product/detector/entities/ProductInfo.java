package com.sns.fake.product.detector.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "PRODUCT_INFO")
public class ProductInfo implements Serializable {
    @DynamoDBHashKey(attributeName = "ID")
    private String tokenCode;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String productId;
    @DynamoDBAttribute
    private String category;
    @DynamoDBAttribute
    private String image;
    @DynamoDBAttribute
    private String description;
    @DynamoDBAttribute
    private double price;
    @DynamoDBAttribute
    private int quantity;
    @DynamoDBAttribute
    private double oldPrice;
    @DynamoDBAttribute
    private String discount;
    @DynamoDBAttribute
    private String rating;
    @DynamoDBAttribute
    private String sellerLabel;
    @DynamoDBAttribute
    private String factoryCode;
    @DynamoDBAttribute
    private String outLetCode;
    @DynamoDBAttribute
    private String manufactureDate;
    @DynamoDBAttribute
    private String expireDate;
    @DynamoDBAttribute
    private int attempt;

}
