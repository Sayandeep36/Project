package com.human_resources.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public static Connection getMySQlConnection()
	{
	  Connection con=null;
	  try
	  {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee7","root","sandy1995");
	  }catch(SQLException e){e.printStackTrace();}
	  catch(ClassNotFoundException e){e.printStackTrace();}
	   
	
	  return con;
	}
}