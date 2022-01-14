package com.springboot.product.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Column(name = "product_name", columnDefinition = "TEXT", nullable = false)
    private String productName;

    @Column(name = "product_value", columnDefinition = "integer", nullable = false)
    private Integer productValue;

    @Id
    @Column(name = "credit_id", columnDefinition = "integer", nullable = false)
    private Integer creditId;

    public Product() {
    }

    public Product(String productName, Integer productValue, Integer creditId) {
        this.productName = productName;
        this.productValue = productValue;
        this.creditId = creditId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductValue() {
        return this.productValue;
    }

    public void setProductValue(Integer productValue) {
        this.productValue = productValue;
    }

    public Integer getCreditId() {
        return this.creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public Product productName(String productName) {
        setProductName(productName);
        return this;
    }

    public Product productValue(Integer productValue) {
        setProductValue(productValue);
        return this;
    }

    public Product creditId(Integer creditId) {
        setCreditId(creditId);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " productName='" + getProductName() + "'" +
                ", productValue='" + getProductValue() + "'" +
                ", creditId='" + getCreditId() + "'" +
                "}";
    }

}
