package com.human_resources.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.human_resources.model.MGInfo;
import com.human_resources.dao.DBConnection;

public class MgDAO 
{
	
	public MGInfo loginMg(String mid , String mpass)
	{
		MGInfo cobj= null; 
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("select * from mgdata where mgid=? and mgpass=?");
		   pst.setString(1, mid);
		   pst.setString(2, mpass);  		   
		   ResultSet rs = pst.executeQuery();
				     
		   if(rs.next())
		   {    
			   // CREATE OBJECT
               cobj = new MGInfo();
			   //PUT VALUE WITHIN OBJECT FETCHING FROM RESULTSET
               cobj.setMgid(rs.getString(1));
               cobj.setMgname(rs.getString(3));
               
               
		   }
		}catch(SQLException e){e.printStackTrace();}
		 finally 
		 {
	   		 if(pst != null)
			 {
				try 
				{
					pst.close();
				} catch (SQLException e) {e.printStackTrace();}
			 }
			
			 if(con != null)
			 {
				try
				{
					con.close();
				} catch (SQLException e) {e.printStackTrace();}
			 }
		}
		
	    return cobj;}
	
	
}
