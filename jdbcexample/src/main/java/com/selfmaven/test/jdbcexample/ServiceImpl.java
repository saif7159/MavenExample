package com.selfmaven.test.jdbcexample;

import java.util.List;

import org.w3c.dom.CDATASection;

import com.mavencar.customer.Customer;
import com.mavencar.customer.CustomerDao;
import com.mavencar.customer.CustomerDaoImpl;

public class ServiceImpl implements Service {
	CarsDao cd = null;
	CustomerDao custdao = null;
	{
		cd = new CarsDaoImpl();
		custdao = new CustomerDaoImpl();
	}
	@Override
	public Cars createCar(String name, String engine, String trans, String uid, int units, int bookings) {
		
		return cd.createCar(name, engine, trans, uid, units , bookings);
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

	@Override
	public Cars updateById(String uid, String carname, String engine, String trans, int choice) {
		
		return cd.updateById(uid, carname, engine, trans, choice);
	}

	@Override
	public List<Cars> findByName(String name) {
		
		return cd.findByName(name);
	}

	@Override
	public Customer createCustomer(String customername, String customerId, String bookingId, String password) {
		
		return custdao.createCustomer(customername, customerId, bookingId, password) ;
	}

	@Override
	public boolean validatePassword(String id, String password) {
		return custdao.validatePassword(id, password);
		
	}

}
