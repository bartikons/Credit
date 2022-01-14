package com.springboot.credit.credit.dto;

public class ProductDto {
    String productName;
    Integer productValue;
    Integer creditId;

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

    @Override
    public String toString() {
        return "{" +
                " productName='" + getProductName() + "'" +
                ", productValue='" + getProductValue() + "'" +
                ", creditId='" + getCreditId() + "'" +
                "}";
    }

    public String toJSON() {
        return "{" +
                " \"productName\":\"" + getProductName() + "\"," +
                " \"productValue\":\"" + getProductValue() + "\"," +
                " \"creditId\":\"" + getCreditId() + "\"" +
                "}";
    }

}
