package com.selfmaven.test.jdbcexample;

import java.util.List;

public interface CarsDao {
public Cars createCar(String carname,String enginetype,String transmissiontype, String uid);
public List<Cars> getAllCars();
public Cars findById(String uid);
public void deleteById(String uid);
public Cars updateById(String uid,String car_name,String engine,String trans,int choice);
public Cars findByName(String name);

}
