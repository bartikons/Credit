package com.springboot.credit.credit.command;

import com.springboot.credit.credit.dto.CustomerDto;
import com.springboot.credit.credit.dto.ProductDto;

public class CreditCommand {

    private String creditName;
    private String creditClientFirstName;
    private String creditClientSurname;
    private String creditClientPesel;
    private String creditProductName;
    private Integer creditProductValue;

    public String getCreditName() {
        return this.creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getCreditClientFirstName() {
        return this.creditClientFirstName;
    }

    public void setCreditClientFirstName(String creditClientFirstName) {
        this.creditClientFirstName = creditClientFirstName;
    }

    public String getCreditClientSurname() {
        return this.creditClientSurname;
    }

    public void setCreditClientSurname(String creditClientSurname) {
        this.creditClientSurname = creditClientSurname;
    }

    public String getCreditClientPesel() {
        return this.creditClientPesel;
    }

    public void setCreditClientPesel(String creditClientPesel) {
        this.creditClientPesel = creditClientPesel;
    }

    public String getCreditProductName() {
        return this.creditProductName;
    }

    public void setCreditProductName(String creditProductName) {
        this.creditProductName = creditProductName;
    }

    public Integer getCreditProductValue() {
        return this.creditProductValue;
    }

    public void setCreditProductValue(Integer creditProductValue) {
        this.creditProductValue = creditProductValue;
    }

    public void setCreditProduct(ProductDto productDto) {
        this.creditProductValue = productDto.getProductValue();
        this.creditProductName = productDto.getProductName();
    }

    public void setCreditCustomer(CustomerDto customerDto) {
        this.creditClientFirstName = customerDto.getFirstName();
        this.creditClientSurname = customerDto.getSurname();
        this.creditClientPesel = customerDto.getPesel();

    }
}
