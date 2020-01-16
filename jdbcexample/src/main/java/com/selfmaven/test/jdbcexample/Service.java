package com.selfmaven.test.jdbcexample;

import java.util.List;

import com.mavencar.customer.Customer;

public interface Service {
public Cars createCar(String name, String engine, String trans, String uid, int units, int bookings);
public List<Cars> getAllCars();
public Cars findById(String uid);
public void deleteById(String uid);
public Cars updateById(String uid, String carname,String engine, String trans,int choice);
public List<Cars> findByName(String name);
public Customer createCustomer(String customername, String customerId, String bookingId, String password);
public boolean validatePassword(String id, String password);

}
