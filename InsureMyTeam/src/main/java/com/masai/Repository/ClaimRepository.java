package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	List<Claim> findAll();
    // custom methods, if any
}