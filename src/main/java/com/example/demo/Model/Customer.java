package com.example.demo.Model;

    import jakarta.persistence.*;
    import lombok.*;

    /**
     * Entity class representing a Customer.
     * Contains fields for customer ID, name, phone number, and mail ID.
     * Uses Lombok annotations for boilerplate code generation.
     */
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Customer {

        /**
         * Unique identifier for the Customer.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long customerId;

        /**
         * Name of the Customer.
         */
        private String name;

        /**
         * Phone number of the Customer.
         */
        private String phoneNumber;

        /**
         * Email ID of the Customer.
         */
        private String mailId;
    }