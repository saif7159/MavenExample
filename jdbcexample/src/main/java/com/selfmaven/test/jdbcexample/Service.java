package com.selfmaven.test.jdbcexample;

import java.util.List;

public interface Service {
public Cars createCar(String name, String engine, String trans, String uid);
public List<Cars> getAllCars();
public Cars findById(String uid);
public void deleteById(String uid);
}
