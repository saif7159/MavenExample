package com.selfmaven.test.jdbcexample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CarConnectionFactory {
private static CarConnectionFactory ccf = null;
private Connection con = null;
private CarConnectionFactory()
{
	}
public static CarConnectionFactory generateConnection() {
	if(ccf==null)
	{
		return new CarConnectionFactory();
	}
	else {
		return ccf;
	}
}
public Connection getConnection()
{
	try {
		FileInputStream fi = new FileInputStream("Cars.properties");
		Properties prop = new Properties();
		prop.load(fi);
		String url = prop.getProperty("connection.url");
		String user = prop.getProperty("connection.username");
		String password = prop.getProperty("connection.password");
		con = DriverManager.getConnection(url,user,password);
				
	} catch (IOException  | SQLException sql) {
		// TODO Auto-generated catch block
		sql.printStackTrace();
	}
	return con;
}
}
