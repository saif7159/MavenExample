package com.selfmaven.test.jdbcexample;

import java.util.List;

public class ServiceImpl implements Service {
	CarsDao cd = null;
	{
		cd = new CarsDaoImpl();
	}
	@Override
	public Cars createCar(String name, String engine, String trans) {
		
		return cd.createCar(name, engine, trans);
	}

	@Override
	public List<Cars> getAllCars() {
		
		return cd.getAllCars();
	}

}
