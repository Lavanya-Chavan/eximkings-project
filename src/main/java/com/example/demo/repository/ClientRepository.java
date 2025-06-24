package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {

    // Get the maximum numeric part of the client_id
    @Query("SELECT MAX(CAST(SUBSTRING(c.clientId, 3) AS int)) FROM Client c")
    Integer findMaxClientIdNumber();
}
