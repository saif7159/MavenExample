package com.selfmaven.test.jdbcexample;

import java.util.List;

public interface CarsDao {
public Cars createCar(String carname,String enginetype,String transmissiontype);
public List<Cars> getAllCars();

}
