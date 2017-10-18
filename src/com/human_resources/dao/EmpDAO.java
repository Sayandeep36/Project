package com.human_resources.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import com.human_resources.dao.DBConnection;
import com.human_resources.model.DesigInfo;
import com.human_resources.model.EmpInfo;

public class EmpDAO 
{
	public boolean insertRecord(EmpInfo cobj)
	{
		boolean f = false;
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		
		   pst = con.prepareStatement("insert into empdata(empname,empid,emppass,dob,gender,phnno,country,city,caddress,paddress,email,empstatus,empproject) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				     
		   pst.setString(1, cobj.getEmpname());
		   pst.setString(2, cobj.getEmpid());
		   pst.setString(3, cobj.getEmppass());
		   pst.setString(4, cobj.getDob());
		   pst.setString(5, cobj.getGender());
		   pst.setString(6, cobj.getPhnno());
		   pst.setString(7, cobj.getCountry());
		   pst.setString(8, cobj.getCity());
		   pst.setString(9, cobj.getCaddress());
		   pst.setString(10, cobj.getPaddress());
		   pst.setString(11, cobj.getEmail());
		   pst.setString(12, cobj.getEmpstatus());
		   pst.setString(13, cobj.getEmpproject());

		   
		   
		   
		   int i = pst.executeUpdate();
				     
		   if(i > 0 )
			   f=true;
			  
		}catch(SQLException e){e.printStackTrace();}
		return f;
		/*finally 
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
		}*/
	
		
	}
	
	public EmpInfo loginCheck(String eid , String epass)
	{
		EmpInfo cobj= null; 
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("select * from empdata where empstatus='true' and (empid=? and emppass=?)");
		   pst.setString(1, eid);
		   pst.setString(2, epass);	   
		   ResultSet rs = pst.executeQuery();
				     
		   if(rs.next())
		   {    
			   // CREATE OBJECT
               cobj = new EmpInfo();
			   //PUT VALUE WITHIN OBJECT FETCHING FROM RESULTSET
               cobj.setEmpname(rs.getString(1));
               cobj.setEmpid(rs.getString(2));
               cobj.setDob(rs.getString(4));
               cobj.setGender(rs.getString(5));
               cobj.setPhnno(rs.getString(6));
               cobj.setCountry(rs.getString(7));
               cobj.setCity(rs.getString(8));
			   cobj.setCaddress(rs.getString(9));
			   cobj.setPaddress(rs.getString(10));
			   cobj.setEmail(rs.getString(11));
			   
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
	
	
		   public ArrayList<EmpInfo> searchRecord(String eid)
			{
			   ArrayList<EmpInfo> custlist = new ArrayList<EmpInfo>();
				
				PreparedStatement pst = null;
				   Connection con = null;
				   
				   try
					{
					   con = DBConnection.getMySQlConnection();
					   
					   pst = con.prepareStatement("select empname,empid,emppass,dob,dept,gender,phnno,desig,country,city,caddress,paddress,email,salary,cl,pl,doj,empstatus,did,empproject  from empdata where empid=?");
						
			
					   pst.setString(1,eid);
					   
					   ResultSet rs= pst.executeQuery();
					     
					   while(rs.next())
					   {
						   EmpInfo cobj1 = new EmpInfo();
						   
						   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
						   cobj1.setEmpname(rs.getString(1));
			               cobj1.setEmpid(rs.getString(2));
			               cobj1.setEmppass(rs.getString(3));
			               cobj1.setDob(rs.getString(4));
			               cobj1.setDept(rs.getString(5));
			               cobj1.setGender(rs.getString(6));
			               cobj1.setPhnno(rs.getString(7));
			               cobj1.setDesig(rs.getString(8));
			               cobj1.setCountry(rs.getString(9));
			               cobj1.setCity(rs.getString(10));
						   cobj1.setCaddress(rs.getString(11));
						   cobj1.setPaddress(rs.getString(12));
						   cobj1.setEmail(rs.getString(13));
						   cobj1.setSalary(rs.getString(14));
						   cobj1.setCl(rs.getString(15));
						   cobj1.setPl(rs.getString(16));
						   cobj1.setDoj(rs.getString(17));
						   cobj1.setEmpstatus(rs.getString(18));
						   cobj1.setDid(rs.getString(19));
						   cobj1.setEmpproject(rs.getString(20));
						   
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
		   
		   
		   public ArrayList<EmpInfo> searchMgRecord(String eid)
			{
			   ArrayList<EmpInfo> custlist = new ArrayList<EmpInfo>();
				
				PreparedStatement pst = null;
				   Connection con = null;
				   
				   try
					{
					   con = DBConnection.getMySQlConnection();
					   
					   pst = con.prepareStatement("select empname,empid,dob,dept,desig,city,email,empproject from empdata where empid=?");
						
			
					   pst.setString(1,eid);
					   
					   ResultSet rs= pst.executeQuery();
					     
					   while(rs.next())
					   {
						   EmpInfo cobj1 = new EmpInfo();
						   
						   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
						   cobj1.setEmpname(rs.getString(1));
			               cobj1.setEmpid(rs.getString(2));
			               cobj1.setDob(rs.getString(3));
			               cobj1.setDept(rs.getString(4));
			               cobj1.setDesig(rs.getString(5));
			               cobj1.setCity(rs.getString(6));						   
						   cobj1.setEmail(rs.getString(7));	
						   cobj1.setEmpproject(rs.getString(8));

						   
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

		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		
			
		   public boolean Update(String epass,String edob,String egender,String ephnno,String ecoun,String ect,String ecad,String epadd,String em,String eid)
			{
				boolean f = false;
				
				PreparedStatement pst = null;
		 	    Connection con = null;
				try
				{
				   con = DBConnection.getMySQlConnection();
				   pst = con.prepareStatement("update empdata set emppass=?,dob=?,gender=?,phnno=?,country=?,city=?,caddress=?,paddress=?,email=? where empid=?");
				   pst.setString(1, epass);
				   pst.setString(2, edob);
				   pst.setString(3, egender);
				   pst.setString(4, ephnno);
				   pst.setString(5, ecoun);
				   pst.setString(6, ect);
				   pst.setString(7, ecad);
				   pst.setString(8, epadd);
				   pst.setString(9, em);
				  pst.setString(10, eid);
				   
				   		   
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
	   
		   
		   
		   public boolean UpdateEmp(String ename,String edob,String dpt,String egender,String ephnno,String dsg,String ecoun,String ect,String ecad,String epadd,String em,String slry,String c,String p,String dj,String stus,String dd,String eid)
			{
				boolean f = false;
				
				System.out.println(eid);
				
				PreparedStatement pst = null;
		 	    Connection con = null;
				try
				{
				   con = DBConnection.getMySQlConnection();
				   pst = con.prepareStatement("update empdata set empname=?,dob=?,dept=?,gender=?,phnno=?,desig=?,country=?,city=?,caddress=?,paddress=?,email=?,salary=?,cl=?,pl=?,doj=?,empstatus=?,did=? where empid=?");
				   pst.setString(1, ename);
				   pst.setString(2, edob);
				   pst.setString(3, dpt);
				   pst.setString(4, egender);
				   pst.setString(5, ephnno);
				   pst.setString(6, dsg);
				   pst.setString(7, ecoun);
				   pst.setString(8, ect);
				   pst.setString(9, ecad);
				   pst.setString(10, epadd);
				   pst.setString(11, em);
				   pst.setString(12, slry);
				   pst.setString(13, c);
				   pst.setString(14, p);
				   pst.setString(15, dj);
				   pst.setString(16, stus);
				   pst.setString(17, dd);
				  pst.setString(18, eid);
 
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

		   public boolean UpdateProject(String eid,String prj)
			{
				boolean f = false;
				
				System.out.println(eid);
				
				PreparedStatement pst = null;
		 	    Connection con = null;
				try
				{
				   con = DBConnection.getMySQlConnection();
				   pst = con.prepareStatement("update empdata set empproject=? where empid=?");
				   pst.setString(1, prj);
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
		   
		   
		   public ArrayList<EmpInfo> ShowProject(String prj)
			{
			   ArrayList<EmpInfo> plist = new ArrayList<EmpInfo>();
				
				PreparedStatement pst = null;
				   Connection con = null;
				   
				   try
					{
					   con = DBConnection.getMySQlConnection();
					   
					   pst = con.prepareStatement("select empname,empid,dept,desig,email from empdata where empproject=?");
						
			
					   pst.setString(1,prj);
					   
					   ResultSet rs= pst.executeQuery();
					     
					   while(rs.next())
					   {
						   EmpInfo cobj1 = new EmpInfo();
						   
						   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
						   cobj1.setEmpname(rs.getString(1));
			               cobj1.setEmpid(rs.getString(2));
			               cobj1.setDept(rs.getString(3));
			               cobj1.setDesig(rs.getString(4));
						   cobj1.setEmail(rs.getString(5));	


						   
						   plist.add(cobj1);
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
				   return plist;
			}

		   
		   
		   
	   
		   

	   
		   
		   
		   public boolean insertrequest(EmpInfo cobj)
			{
				boolean f = false;
				PreparedStatement pst = null;
		 	    Connection con = null;
				try
				{
				   con = DBConnection.getMySQlConnection();
				
				   pst = con.prepareStatement("insert into leavedata(lid,uid,leaves,days,dos) values(?,?,?,?,?)");
				   pst.setString(1, cobj.getLid());   
				   pst.setString(2, cobj.getUid());     

				   pst.setString(3, cobj.getLeaves());
				   pst.setString(4, cobj.getDays());
				   pst.setString(5, cobj.getDos());
				  
				   
				   
				   
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
		   
		   
		   
		   
		   public ArrayList<EmpInfo> showRequest(String uid)
			{
			   ArrayList<EmpInfo> custlist = new ArrayList<EmpInfo>();
				System.out.println(uid);
				PreparedStatement pst = null;
				   Connection con = null;
				   
				   try
					{
					   con = DBConnection.getMySQlConnection();
					   
					   pst = con.prepareStatement("select * from leavedata where uid=?");
						
			
					   pst.setString(1,uid);

					   
					   ResultSet rs= pst.executeQuery();
					     
					   while(rs.next())
					   {
						   EmpInfo cobj1 = new EmpInfo();
						   
						   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
						   cobj1.setUid(rs.getString(1));
						   cobj1.setLid(rs.getString(2));
			               cobj1.setLeaves(rs.getString(3));
			               cobj1.setDays(rs.getString(4));
			               cobj1.setDos(rs.getString(5));
			               cobj1.setLstatus(rs.getString(6));
			               
			               
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
		   
		   
		   
		   public ArrayList<EmpInfo> displayLeaveRequests()
			{
			   ArrayList<EmpInfo> custlist = new ArrayList<EmpInfo>();
				
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
					   EmpInfo obj = new EmpInfo();
					   
					   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
					   
					   
					   obj.setLid(rs.getString(1));
					   obj.setUid(rs.getString(2));
					   obj.setLeaves(rs.getString(3));
					   obj.setDays(rs.getString(4));
					   obj.setMax(rs.getString(5));
					   obj.setAvailable(rs.getString(6));

					   obj.setDos(rs.getString(7));
					   obj.setLstatus(rs.getString(8));
					   
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
		   
		   
		   
		   
		   public boolean deleteRecords(EmpInfo cobj)
			{   boolean f=false;
				PreparedStatement pst = null;
				   Connection con = null;
				   try
					{
					   con = DBConnection.getMySQlConnection();
					   
					   pst = con.prepareStatement("delete from empdata where empid=?");
						     
					   pst.setString(1, cobj.getEmpid());
					  
						     
					   int i= pst.executeUpdate();
						     
					   if(i>0)
						   f=true;
						  
				     }catch(SQLException e){e.printStackTrace();}
				   return f;
			}
		   
		   

public ArrayList<EmpInfo> mgdisplayAllEmp()
{
   ArrayList<EmpInfo> custlist = new ArrayList<EmpInfo>();
	
	PreparedStatement pst = null;
	    Connection con = null;
	try
	{
	   con = DBConnection.getMySQlConnection();
	   pst = con.prepareStatement("select empname,empid,dob,dept,desig,city,email from empdata");
	   ResultSet rs = pst.executeQuery();
			     
	   while(rs.next())
	   {
		   //CREATE NEW OBJECT
		   EmpInfo cobj1 = new EmpInfo();
		   
		   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
		  
		   cobj1.setEmpname(rs.getString(1));
           cobj1.setEmpid(rs.getString(2));
           cobj1.setDob(rs.getString(3));
           cobj1.setDept(rs.getString(4));
           cobj1.setDesig(rs.getString(5));
           cobj1.setCity(rs.getString(6));
		   cobj1.setEmail(rs.getString(7));
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



		   
		   
		   public ArrayList<EmpInfo> displayAllEmp()
			{
			   ArrayList<EmpInfo> custlist = new ArrayList<EmpInfo>();
				
				PreparedStatement pst = null;
		 	    Connection con = null;
				try
				{
				   con = DBConnection.getMySQlConnection();
				   pst = con.prepareStatement("select empname,empid,emppass,dob,dept,gender,phnno,desig,country,city,caddress,paddress,email,salary,cl,pl,doj,empstatus,empproject  from empdata");
				   ResultSet rs = pst.executeQuery();
						     
				   while(rs.next())
				   {
					   //CREATE NEW OBJECT
					   EmpInfo cobj1 = new EmpInfo();
					   
					   //EXTRACT VALUE FROM ResultsetS & STORE in the OBJECT
					  
					   cobj1.setEmpname(rs.getString(1));
		               cobj1.setEmpid(rs.getString(2));
		               cobj1.setEmppass(rs.getString(3));
		               cobj1.setDob(rs.getString(4));
		               cobj1.setDept(rs.getString(5));
		               cobj1.setGender(rs.getString(6));
		               cobj1.setPhnno(rs.getString(7));
		               cobj1.setDesig(rs.getString(8));
		               cobj1.setCountry(rs.getString(9));
		               cobj1.setCity(rs.getString(10));
					   cobj1.setCaddress(rs.getString(11));
					   cobj1.setPaddress(rs.getString(12));
					   cobj1.setEmail(rs.getString(13));
					   cobj1.setSalary(rs.getString(14));
					   cobj1.setCl(rs.getString(15));
					   cobj1.setPl(rs.getString(16));
					   cobj1.setDoj(rs.getString(17));
					   cobj1.setEmpstatus(rs.getString(18));
					   cobj1.setEmpproject(rs.getString(19));
					   
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
		}

