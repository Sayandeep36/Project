package com.human_resources.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human_resources.model.DesigInfo;
import com.human_resources.model.EmpInfo;
import com.human_resources.model.HRInfo;
import com.human_resources.dao.DBConnection;
import com.human_resources.model.DesigInfo;

public class HrDAO 
{
	
	
	
	public HRInfo loginHr(String hid , String hpass)
	{
		HRInfo cobj= null; 
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("select * from hrdata where hrid=? and hrpass=?");
		   pst.setString(1, hid);
		   pst.setString(2, hpass);  		   
		   ResultSet rs = pst.executeQuery();
				     
		   if(rs.next())
		   {    
			   // CREATE OBJECT
               cobj = new HRInfo();
			   //PUT VALUE WITHIN OBJECT FETCHING FROM RESULTSET
               cobj.setHrname(rs.getString(1));
               cobj.setHrid(rs.getString(2));
               cobj.setHrdob(rs.getString(4));
               cobj.setHrgender(rs.getString(5));
               cobj.setHrphn(rs.getString(6));
               cobj.setHrsalary(rs.getString(7));
               
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
