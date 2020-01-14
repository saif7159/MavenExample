package com.selfmaven.test.jdbcexample;

import java.util.List;

public interface Service {
public Cars createCar(String name, String engine, String trans);
public List<Cars> getAllCars();
}
