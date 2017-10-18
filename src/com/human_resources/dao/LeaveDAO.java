package com.human_resources.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import com.human_resources.dao.DBConnection;
import com.human_resources.model.EmpInfo;
import com.human_resources.model.LeaveInfo;;
public class LeaveDAO {
	
	public boolean updateLeaveStatus(String estatus,String elid)
	{
		boolean f = false;
		
		System.out.println(elid);
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("update leavedata set lstatus=? where lid=?");
		     pst.setString(1, estatus);
		   pst.setString(2, elid);
		

		   int i = pst.executeUpdate();
		   
		     
		   if(i > 0 )
			   f=true;
		
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
		
	    return f;
	}
   
   
   
   
   
   public LeaveInfo checkLeave(String lid)
	{
	   LeaveInfo cobj= null; 
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("select * from leavedata where lid=?");
		   pst.setString(1, lid);
		   
		   ResultSet rs = pst.executeQuery();
				     
		   if(rs.next())
		   {    
			   // CREATE OBJECT
               cobj = new LeaveInfo();
			   //PUT VALUE WITHIN OBJECT FETCHING FROM RESULTSET
               cobj.setLid(rs.getString(1));
               cobj.setUid(rs.getString(2));
               cobj.setLeaves(rs.getString(3));
               cobj.setDays(rs.getString(4));
               cobj.setDos(rs.getString(5));
               cobj.setLstatus(rs.getString(6));
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
   
   public ArrayList<LeaveInfo> displayLeaveRequests()
			{
			   ArrayList<LeaveInfo> custlist = new ArrayList<LeaveInfo>();
				
				PreparedStatement pst = null;
		 	    Connection con = null;
				try
				{
				   con = DBConnection.getMySQlConnection();
				   pst = con.prepareStatement("select * from leavedata");
				   ResultSet rs = pst.executeQuery();
						     
				   while(rs.next())
				   {
					   //CREATE NEW OBJECT
					   LeaveInfo obj = new LeaveInfo();
					   
					   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
					   
					   
					   obj.setLid(rs.getString(1));
					   obj.setUid(rs.getString(2));
					   obj.setLeaves(rs.getString(3));
					   obj.setDays(rs.getString(4));
					   obj.setDos(rs.getString(5));
					   obj.setLstatus(rs.getString(6));
					   
					   //ADD OBJECT IN THE ARRAYLIST
					   custlist.add(obj);
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
				
			    return custlist;
			}
		   
   
   public boolean decrementCL(String uid,String edays)
  	{
  	   LeaveInfo cobj= null; 
		boolean f1 = false;
		

  		PreparedStatement pst = null;
  		PreparedStatement pst1 = null;
  		String m;
  		
   	    Connection con = null;
  		try
  		{
  		   con = DBConnection.getMySQlConnection();
  		   pst = con.prepareStatement("select cl from empdata where empid=?");
  		   pst.setString(1, uid);
  		   ResultSet rs = pst.executeQuery();
  		   rs.next();
           int x=Integer.parseInt(rs.getString(1));
  		   int y=Integer.parseInt(edays);
  		   
  		   int d=x-y;
          m=""+d;
           pst1 = con.prepareStatement("update empdata set cl=? where empid=?");
          pst1.setString(1, m);
             pst1.setString(2, uid);
		   
		   int i = pst1.executeUpdate();
		   
		   if(i > 0 )
			   f1=true;
		
		     
		 
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
	   		if(pst1 != null)
			 {
				try 
				{
					pst1.close();
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
  		
  	    return f1;}
   
   
   
   public boolean decrementPL(String uid,String edays)
 	{
 	   LeaveInfo cobj= null; 
		boolean f2 = false;
		

 		PreparedStatement pst = null;
 		PreparedStatement pst1 = null;
 		String m;
 		
  	    Connection con = null;
 		try
 		{
 		   con = DBConnection.getMySQlConnection();
 		   pst = con.prepareStatement("select pl from empdata where empid=?");
 		   pst.setString(1, uid);
 		   ResultSet rs = pst.executeQuery();
 		   rs.next();
          int x=Integer.parseInt(rs.getString(1));
         int y=Integer.parseInt(edays);
 		   int d=x-y;
          m=""+d;
         
 		   pst1 = con.prepareStatement("update empdata set pl=? where empid=?");
          pst1.setString(1, m);
      pst1.setString(2, uid);
		  int i = pst1.executeUpdate();
		   if(i > 0 )
			   f2=true;
		
		     
		 
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
	   		if(pst1 != null)
			 {
				try 
				{
					pst1.close();
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
 		
 	    return f2;}




public boolean deleteLeave(LeaveInfo cobj)
	{   boolean f=false;
		PreparedStatement pst = null;
		   Connection con = null;
		   try
			{
			   con = DBConnection.getMySQlConnection();
			   
			   pst = con.prepareStatement("delete from leavedata where lid=?");
				     
			   pst.setString(1, cobj.getLid());
			  
				     
			   int i= pst.executeUpdate();
				     
			   if(i>0)
				   f=true;
				  
		     }catch(SQLException e){e.printStackTrace();}
		   return f;
	}


}
