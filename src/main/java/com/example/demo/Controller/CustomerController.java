// src/main/java/com/example/demo/Controller/CustomerController.java
package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Customer entities.
 * Provides endpoints for basic CRUD operations.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Constructor for CustomerController.
     * @param customerService Service layer for customer operations.
     */
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Creates a new customer.
     * @param customer Customer object to be created.
     * @return ResponseEntity containing the created customer.
     */
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer created = customerService.createCustomer(customer);
        return ResponseEntity.ok(created);
    }

    /**
     * Retrieves a customer by ID.
     * @param id ID of the customer to retrieve.
     * @return ResponseEntity containing the customer if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all customers.
     * @return ResponseEntity containing the list of all customers.
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    /**
     * Updates an existing customer.
     * @param id ID of the customer to update.
     * @param customer Updated customer data.
     * @return ResponseEntity containing the updated customer, or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updated = customerService.updateCustomer(id, customer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a customer by ID.
     * @param id ID of the customer to delete.
     * @return ResponseEntity with no content status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}