package com.springboot.credit.credit.dto;

public class CreditDto {
    private Integer id;
    private String creditName;

    public String getCreditName() {
        return this.creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
