package com.mavencar.customer;

import java.util.List;

public interface CustomerDao extends CarBooking{
public Customer createCustomer(String customerName, String customerID, String bookingID, String password);
public boolean validatePassword(String id, String pass);
public List<Customer> getAllCustomer();
}
