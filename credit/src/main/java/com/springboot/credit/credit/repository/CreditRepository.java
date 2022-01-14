package com.springboot.credit.credit.repository;

import com.springboot.credit.credit.model.Credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
}