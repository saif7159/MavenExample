package com.selfmaven.test.jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarsDaoImpl implements CarsDao {
	private CarConnectionFactory ccf = null;
	private Connection con = null;
	private PreparedStatement ps= null;
	private Cars car = null;
	{
		ccf = CarConnectionFactory.generateConnection();
		con = ccf.getConnection();
		
	}
	@Override
	public Cars createCar(String carname, String enginetype, String transmissiontype, String uid) {
		car = new Cars(carname, enginetype, transmissiontype,uid);
		try {
			ps = con.prepareStatement("Insert into Cars(car_name,engine_type,trans_type,car_uid) values (?,?,?,?);");
			ps.setString(1, carname);
			ps.setString(2, enginetype);
			ps.setString(3, transmissiontype);
			ps.setString(4, uid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public List<Cars> getAllCars() {
		List<Cars> list = new ArrayList<Cars>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select car_name,engine_type,trans_type from Cars;");
			while(rs.next())
			{
				list.add(new Cars(rs.getString(1),rs.getString(2),rs.getString(3),null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cars findById(String uid) {
		Cars car = null;
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select car_name,engine_type,trans_type from Cars where car_uid='"+uid+"';");
		while(rs.next())
		{
			car = new Cars(rs.getString(1),rs.getString(2),rs.getString(3),null);
		}}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		return car;
	}

	@Override
	public void deleteById(String uid) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("Delete from Cars where car_uid='"+uid+"';");
			System.out.println("Entry removed");
		   }
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
	
	}

	@Override
	public Cars updateById(String uid, String carname,String engine, String trans,int choice) {
		Cars c = null;
		try {
			
			Statement stmt = con.createStatement();
			switch(choice)
			{
			case 1: stmt.executeUpdate("Update Cars set car_name = '"+carname+"' where car_uid='"+uid+"';");
					break;
			case 2: stmt.executeUpdate("Update Cars set engine_type = '"+engine+"' where car_uid='"+uid+"';");
					break;
			case 3: stmt.executeUpdate("Update Cars set trans_type = '"+trans+"' where car_uid='"+uid+"';");
					break;
			default: 
					break;		
			
			}
			c=findById(uid);
			
			}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Cars> findByName(String name) {
		Cars c = null;
		List<Cars> list = new ArrayList<Cars>();
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select car_name,engine_type,trans_type from Cars where car_name='"+name+"' Order By engine_type DESC;");
		while(rs.next())
		{
			c = new Cars(rs.getString(1),rs.getString(2),rs.getString(3),null);
			list.add(c);
		}}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		
		return list;
	}		
	}

