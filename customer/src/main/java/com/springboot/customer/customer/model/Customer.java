package com.springboot.customer.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreditDB")
public class Customer {
    @Id
    @Column(name = "credit_id", columnDefinition = "integer", nullable = false)
    Integer creditId;
    @Column(name = "firstName", columnDefinition = "TEXT")
    String firstName;
    @Column(name = "surname", columnDefinition = "TEXT")
    String surname;
    @Column(name = "pesel", columnDefinition = "TEXT")
    String pesel;

    public Customer() {
    }

    public Customer(Integer creditId, String firstName, String surname, String pesel) {
        this.creditId = creditId;
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
    }

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

    public Customer creditId(Integer creditId) {
        setCreditId(creditId);
        return this;
    }

    public Customer firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Customer surname(String surname) {
        setSurname(surname);
        return this;
    }

    public Customer pesel(String pesel) {
        setPesel(pesel);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " creditId='" + getCreditId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", surname='" + getSurname() + "'" +
                ", pesel='" + getPesel() + "'" +
                "}";
    }

}
