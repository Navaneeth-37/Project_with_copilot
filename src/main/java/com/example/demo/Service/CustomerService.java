package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.ModelRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to Customer entities.
 * Provides methods for basic CRUD operations.
 */
@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    /**
     * Constructor for CustomerService.
     * @param customerRepo Repository for Customer entity operations.
     */
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    /**
     * Creates a new Customer.
     * @param customer Customer object to be created.
     * @return The created Customer entity.
     */
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    /**
     * Retrieves a Customer by its ID.
     * @param id The ID of the Customer.
     * @return An Optional containing the Customer if found, or empty if not.
     */
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    /**
     * Retrieves all Customers.
     * @return A list of all Customer entities.
     */
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    /**
     * Updates an existing Customer.
     * @param id The ID of the Customer to update.
     * @param updatedCustomer The Customer object with updated data.
     * @return The updated Customer entity, or null if not found.
     */
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepo.findById(id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    customer.setMailId(updatedCustomer.getMailId());
                    return customerRepo.save(customer);
                })
                .orElse(null);
    }

    /**
     * Deletes a Customer by its ID.
     * @param id The ID of the Customer to delete.
     */
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}