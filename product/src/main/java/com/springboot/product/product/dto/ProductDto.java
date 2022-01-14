package com.springboot.product.product.dto;

public class ProductDto {
    String productName;
    String productValue;
    Integer creditId;

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductValue() {
        return this.productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    public Integer getCreditId() {
        return this.creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
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
