package com.mavencar.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.selfmaven.test.jdbcexample.CarConnectionFactory;
import com.selfmaven.test.jdbcexample.Cars;

public class CustomerDaoImpl implements CustomerDao {
	private CarConnectionFactory ccf = null;
	private Connection con = null;
	private PreparedStatement ps= null;
	private CustomerDao cust = null;
	{
		ccf = CarConnectionFactory.generateConnection();
		con = ccf.getConnection();
		
	}
	

	@Override
	public Cars bookCar(String carid, String customerId) {
		Cars c = null;
		try {
		ps = con.prepareStatement("select car_units,car_bookings from Cars where car_id = '"+carid+"';");
		ResultSet rs = ps.executeQuery();
		int units = rs.getInt("car_units");
		int bookings = rs.getInt("car_bookings");
		if(units>=1)
		{
			units--;
			bookings++;
			ps = con.prepareStatement("Update Cars set car_units = "+units+",car_bookings ="+bookings+"where car_id='"+carid+"';");
			ps.executeUpdate();
			ps = con.prepareStatement("Update Customer set booking_id='"+carid+customerId+"' where cust_id='"+customerId+"';");
			ps.executeUpdate();
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer createCustomer(String customerName, String customerID, String bookingID, String password) {
		Customer cust = new Customer(customerName, customerID, bookingID, password);
		try {
		PreparedStatement ps = con.prepareStatement("Insert into Customer values(?,?,?,?);");
		ps.setString(1, customerName);
		ps.setString(2, customerID);
		ps.setString(3, bookingID);
		ps.setString(4, password);
		ps.executeUpdate();
		System.out.println("Created! Login with your id password now");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cust;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return null;
	}

	@Override
	public boolean validatePassword(String id, String pass) {
		boolean result = false;
		String password = null;
		try {
			ps = con.prepareStatement("select password from Customer where cust_id ='"+id+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				password = rs.getString("password");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(password.equals(pass))
		{
			System.out.println("Login Success...");
			result = true;
		}
		else {
			System.out.println("Failed try again...");
		}
		return result;
	}

}
