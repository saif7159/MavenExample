package com.selfmaven.test.jdbcexample;

import java.util.List;

public class ServiceImpl implements Service {
	CarsDao cd = null;
	{
		cd = new CarsDaoImpl();
	}
	@Override
	public Cars createCar(String name, String engine, String trans, String uid) {
		
		return cd.createCar(name, engine, trans, uid);
	}

	@Override
	public List<Cars> getAllCars() {
		
		return cd.getAllCars();
	}

	@Override
	public Cars findById(String uid) {
		
		return cd.findById(uid);
	}

	@Override
	public void deleteById(String uid) {
	cd.deleteById(uid);
		
	}

}
