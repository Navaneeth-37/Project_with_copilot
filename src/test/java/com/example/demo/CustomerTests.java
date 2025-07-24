package com.example.demo;
import com.example.demo.Model.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Customer Entity Tests")
class CustomerTests {

    @Test
    @DisplayName("Should create Customer with all fields set")
    void createCustomerWithAllFields() {
        Customer customer = new Customer(1L, "Alice", "1234567890", "alice@example.com");
        assertEquals(1L, customer.getCustomerId());
        assertEquals("Alice", customer.getName());
        assertEquals("1234567890", customer.getPhoneNumber());
        assertEquals("alice@example.com", customer.getMailId());
    }

    @Test
    @DisplayName("Should allow updating Customer fields")
    void updateCustomerFields() {
        Customer customer = new Customer();
        customer.setCustomerId(2L);
        customer.setName("Bob");
        customer.setPhoneNumber("0987654321");
        customer.setMailId("bob@example.com");
        assertEquals(2L, customer.getCustomerId());
        assertEquals("Bob", customer.getName());
        assertEquals("0987654321", customer.getPhoneNumber());
        assertEquals("bob@example.com", customer.getMailId());
    }

    @Test
    @DisplayName("Should handle null values for optional fields")
    void handleNullValues() {
        Customer customer = new Customer(3L, null, null, null);
        assertEquals(3L, customer.getCustomerId());
        assertNull(customer.getName());
        assertNull(customer.getPhoneNumber());
        assertNull(customer.getMailId());
    }

    @Test
    @DisplayName("Should use no-args constructor")
    void useNoArgsConstructor() {
        Customer customer = new Customer();
        assertNull(customer.getCustomerId());
        assertNull(customer.getName());
        assertNull(customer.getPhoneNumber());
        assertNull(customer.getMailId());
    }

    @Test
    @DisplayName("Should compare Customers with same data as equal")
    void compareCustomersWithSameData() {
        Customer customer1 = new Customer(4L, "Carol", "1112223333", "carol@example.com");
        Customer customer2 = new Customer(4L, "Carol", "1112223333", "carol@example.com");
        assertEquals(customer1, customer2);
    }

    @Test
    @DisplayName("Should generate different hashCodes for different Customers")
    void differentHashCodesForDifferentCustomers() {
        Customer customer1 = new Customer(5L, "Dave", "4445556666", "dave@example.com");
        Customer customer2 = new Customer(6L, "Eve", "7778889999", "eve@example.com");
        assertNotEquals(customer1.hashCode(), customer2.hashCode());
    }
}