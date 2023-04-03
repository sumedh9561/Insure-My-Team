package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
    // custom methods, if any
}