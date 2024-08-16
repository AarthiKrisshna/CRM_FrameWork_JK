package com.comcast.crm.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con;
	public void getDataBaseConnection() throws SQLException
	{ try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);;
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	catch (Exception e) {
		System.out.println("Exception handled");// TODO: handle exception
	}
	}
	public void closeDBConnection() throws SQLException
	{
		con.close();
	}
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet resultset=null;
		try {
		Statement stat=con.createStatement();
		resultset = stat.executeQuery(query);
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return resultset;
	}
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int result=0;
		try {
		Statement stat=con.createStatement();
		 result=stat.executeUpdate(query);
		
		}
		catch (Exception e) 
		{
				System.out.println("exceptionhandled");// TODO: handle exception
		}
		return result;
	}
}
