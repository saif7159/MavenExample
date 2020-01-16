package com.mavencar.customer;

import com.selfmaven.test.jdbcexample.Cars;


public interface CarBooking {
	
public Cars bookCar(String carid, String customerId);
}
