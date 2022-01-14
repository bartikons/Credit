package com.springboot.credit.credit.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "credit")
public class Credit {

    @Autowired
    public Credit(String creditName) {
        this.creditName = creditName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "credit_name", columnDefinition = "TEXT", nullable = false)
    private String creditName;

    public Credit() {
    }

    public Credit(Integer id, String creditName) {
        this.id = id;
        this.creditName = creditName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditName() {
        return this.creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Credit id(Integer id) {
        setId(id);
        return this;
    }

    public Credit creditName(String creditName) {
        setCreditName(creditName);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", creditName='" + getCreditName() + "'" +
                "}";
    }

}
