package com.springboot.credit.credit.dto;

public class CustomerDto {
    Integer creditId;
    String firstName;
    String surname;
    String pesel;

    public Integer getCreditId() {
        return this.creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return this.pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "{" +
                " creditId='" + getCreditId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", Surname='" + getSurname() + "'" +
                ", pesel='" + getPesel() + "'" +
                "}";
    }

}
