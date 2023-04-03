package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // custom methods, if any
}