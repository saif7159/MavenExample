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
	public Cars createCar(String carname, String enginetype, String transmissiontype) {
		car = new Cars(carname, enginetype, transmissiontype);
		try {
			ps = con.prepareStatement("Insert into Cars(car_name,engine_type,trans_type) values (?,?,?);");
			ps.setString(1, carname);
			ps.setString(2, enginetype);
			ps.setString(3, transmissiontype);
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
				list.add(new Cars(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
