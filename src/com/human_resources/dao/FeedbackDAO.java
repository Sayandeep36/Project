package com.human_resources.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human_resources.model.EmpInfo;
import com.human_resources.model.FeedbackInfo;

public class FeedbackDAO {

	
	
	public boolean insertQUERY(FeedbackInfo cobj)
	{
		boolean f = false;
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		
		   pst = con.prepareStatement("insert into feedbackdata(uid,query) values(?,?)");
				     
		   pst.setString(1, cobj.getUid());
		   pst.setString(2, cobj.getQuery());
		  
		   
		   
		   
		   int i = pst.executeUpdate();
				     
		   if(i > 0 )
			   f=true;
		}catch(SQLException e){e.printStackTrace();}
		return f;
	}
		/* finally 
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
	
	}*/
	 public ArrayList<FeedbackInfo> searchFeedback(String eid)
		{
		   ArrayList<FeedbackInfo> custlist = new ArrayList<FeedbackInfo>();
			
			PreparedStatement pst = null;
			   Connection con = null;
			   
			   try
				{
				   con = DBConnection.getMySQlConnection();
				   
				   pst = con.prepareStatement("select * from feedbackdata where uid=?");
					
		
				   pst.setString(1,eid);
				   
				   ResultSet rs= pst.executeQuery();
				     
				   while(rs.next())
				   {
					   FeedbackInfo cobj1 = new FeedbackInfo();
					   
					   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
					   cobj1.setUid(rs.getString(1));
		               cobj1.setQuery(rs.getString(2));
		               cobj1.setReply(rs.getString(3));
		               
					   
					   custlist.add(cobj1);
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
	 
	 
	 
	 public ArrayList<FeedbackInfo> displayAllQ()
		{
		   ArrayList<FeedbackInfo> custlist = new ArrayList<FeedbackInfo>();
			
			PreparedStatement pst = null;
	 	    Connection con = null;
			try
			{
			   con = DBConnection.getMySQlConnection();
			   pst = con.prepareStatement("select * from feedbackdata");
			   ResultSet rs = pst.executeQuery();
					     
			   while(rs.next())
			   {
				   //CREATE NEW OBJECT
				   FeedbackInfo cobj1 = new FeedbackInfo();
				   
				   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
				  
				   cobj1.setUid(rs.getString(1));
	               cobj1.setQuery(rs.getString(2));
	               cobj1.setReply(rs.getString(3));
	               
				   
				   //ADD OBJECT IN THE ARRAYLIST
				   custlist.add(cobj1);
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
	 
	 public boolean UpdateReply(String ereply,String eid)
		{
			boolean f = false;
			
			PreparedStatement pst = null;
	 	    Connection con = null;
			try
			{
			   con = DBConnection.getMySQlConnection();
			   pst = con.prepareStatement("update feedbackdata set reply=? where uid=?");
			   pst.setString(1, ereply);
			   pst.setString(2, eid);
			
			   		   
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
}

