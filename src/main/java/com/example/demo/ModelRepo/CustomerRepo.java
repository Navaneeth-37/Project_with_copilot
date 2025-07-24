package com.example.demo.ModelRepo;

import com.example.demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Customer entities.
 * Extends JpaRepository to provide CRUD operations and query methods.
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}