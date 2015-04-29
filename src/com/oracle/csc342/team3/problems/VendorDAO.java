package com.oracle.csc342.team3.problems;

import java.math.BigDecimal;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorDAO {
	
    public void createVendor(Vendor vendor) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps= null;
        
        System.out.println("Vendor to be Inserted \n");
        System.out.println(vendor.toString());
        
		try
        {
            
        	con = DBConnect.getConnection();
            ps=con.prepareStatement("insert into Team3.vendor (vendor_id, name, street_address, city, state, "
            		+ "postal_code, fax, phone, vendor_contact, tax_id) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setBigDecimal(1, vendor.getVendorID());
            ps.setString(2,vendor.getVendorName());
            ps.setString(3,vendor.getAddress().getStreetAddress());
            ps.setString(4,vendor.getAddress().getCity());
            ps.setString(5,vendor.getAddress().getState());
            ps.setString(6,vendor.getAddress().getPostalCode());
            ps.setString(7,vendor.getFaxNum());
            ps.setString(8,vendor.getPhoneNum());
            ps.setString(9,vendor.getVendorContact());
            ps.setBigDecimal(10,vendor.getTaxID());
            
            ps.executeUpdate();
            System.out.println("Addition Success");
        
        }
        catch(SQLException e)
        {
            System.out.println("Error in Create Vendor" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());

            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in Create Vendor");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
		finally
		{
			if (con != null)
				System.out.println("closing Vendor create statement \n");
			    ps.close();
				
		}
        
    }

    
    public BigDecimal findMaxVendorID() throws SQLException
    {
        BigDecimal maxVendorID = new BigDecimal(0);
        
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        
        try
        {
        	con = DBConnect.getConnection();
        	ps=con.prepareStatement("SELECT MAX(V.VENDOR_ID) FROM Team3.VENDOR V");
            
            rs=ps.executeQuery();
            while(rs.next())
            {
            	maxVendorID = rs.getBigDecimal(1);
                System.out.println("Get Max Vendor Id Success ");      
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error in get max vendor access " + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in get max vendor");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing vendor connection \n");
    			rs.close();
    			ps.close();
    	}
        return maxVendorID;
    }

public Vendor viewVendor(BigDecimal vendorID) throws SQLException
    {

    
        ResultSet rs=null;
        Vendor outVendor = new Vendor();
        Address outAddress = new Address();
        Connection con = null;
        PreparedStatement ps=null;
        
        try
        {
    
        	con = DBConnect.getConnection();
        	ps=con.prepareStatement("SELECT * FROM Team3.VENDOR V WHERE V.VENDOR_ID =?");
            ps.setBigDecimal(1, vendorID);

            rs=ps.executeQuery();
            while(rs.next())
            {
            	outVendor.setVendorID(rs.getBigDecimal(1));
            	outVendor.setVendorName(rs.getString(2));
            	outAddress.setStreetAddress(rs.getString(3));
            	outAddress.setCity(rs.getString(4));
            	outAddress.setState(rs.getString(5));
            	outAddress.setPostalCode(rs.getString(6));
            	outVendor.setAddress(outAddress);
            	outVendor.setFaxNum(rs.getString(7));
            	outVendor.setPhoneNum(rs.getString(8));
            	outVendor.setVendorContact(rs.getString(9));
            	outVendor.setTaxID(rs.getBigDecimal(10));
                
                /* don't need to set parent, must be done when you instantiate the ee class (must setup past classes correctly. */
                
                System.out.println("View Vendor Success");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error in Vendor view access" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in Vendor view access");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing Vendor connection \n");
				rs.close();
				ps.close();	
    	}
        return outVendor;
    }
	public void updateVendor(Vendor vendor) throws SQLException
    {
    
		System.out.println("Vendor to be Updated \n");
		System.out.println(vendor.toString());
		Connection con = null;
    	PreparedStatement ps= null;
    	
        try
        {

        	con = DBConnect.getConnection();
            
        	ps=con.prepareStatement("update Team3.vendor v set v.name =?, v.street_address =?, v.city =?, v.state =?,"
        			+ "v.postal_code =?, v.fax =?, v.phone =?, v.vendor_contact =?, v.tax_id =? where vendor_id = ?");
           
        	ps.setString(1, vendor.getVendorName());
        	ps.setString(2, vendor.getAddress().getStreetAddress());
        	ps.setString(3, vendor.getAddress().getCity());
        	ps.setString(4, vendor.getAddress().getState());
        	ps.setString(5, vendor.getAddress().getPostalCode());
        	ps.setString(6, vendor.getFaxNum());
        	ps.setString(7, vendor.getPhoneNum());
        	ps.setString(8, vendor.getVendorContact());
        	ps.setBigDecimal(9, vendor.getTaxID());
        	ps.setBigDecimal(10, vendor.getVendorID());
        	
            ps.executeQuery();
            System.out.println("updated");
        }
        catch(SQLException e)
	        {
	            System.out.println("Error in Vendor Update" + e.getSQLState());
	            System.out.println("/nError Code: " + e.getErrorCode());
	            System.out.println("/nMessage: " + e.getMessage());
	            System.exit( 1 );
	        }
	    catch(Exception e)
	        {
	            System.out.println("unknown Error in Vendor Update");
	            System.out.println("/nMessage: " + e.getMessage());
	            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing Vendor connection \n");
				ps.close();
    	}
    }
	public void deleteVendor(BigDecimal vendorID) throws SQLException
    {
    
		System.out.println("Vendor to be Deleted \n");
		System.out.println("Vendor Id = " + vendorID + "\n");
		
		
		Connection con = null;
    	PreparedStatement ps=null;
    	
        try
        {
    
        	con = DBConnect.getConnection();
            ps=con.prepareStatement("delete Team3.vendor where vendor_id=?");
            ps.setBigDecimal(1,vendorID);
            ps.executeQuery();
            System.out.println("deleted");
        }
        catch(SQLException e)
        {
            System.out.println("Error in Vendor Delete" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in Vendor delete");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing Vendor connection \n");
				ps.close();
				
    	}
    }

    	public void countVendors() throws SQLException
        {
        
        	Connection con = null;
        	PreparedStatement ps= null;
        	ResultSet rs = null;
        	String sql1 = "SELECT COUNT(*) FROM Team3.VENDOR;";
        	
            try
            {
        
            	con = DBConnect.getConnection();
                ps=con.prepareStatement(sql1);
                int vendorCt = 0;
                
                rs = ps.executeQuery();
                while(rs.next())
                {
                	vendorCt = rs.getInt(1);
                }    
                System.out.println("count Vendors success " + vendorCt);
            }
            catch(SQLException e)
            {
                System.out.println("Error in count Vendor" + e.getSQLState());
                System.out.println("/nError Code: " + e.getErrorCode());
                System.out.println("/nMessage: " + e.getMessage());
                System.exit( 1 );
            }
            catch(Exception e)
            {
                System.out.println("unknown Error in count Vendor");
                System.out.println("/nMessage: " + e.getMessage());
                System.exit( 1 );
            }
            finally
        	{
        		if (con != null)
        			System.out.println("closing count objects \n");
        		    rs.close();
        		    ps.close();
    				    				
        	}
        
    }

    	public void saveVendors(List<Vendor> vendors) throws SQLException
        {
        
        	Connection con = null;
        	
        	String sql1 = "Select count(*) as vendor_count from Team3.vendor v WHERE v.vendor_id = ?";
        	PreparedStatement ps = null;
        	ResultSet rs = null;

        	try
            {
    
        	    con = DBConnect.getConnection();
                ps=con.prepareStatement(sql1);

        	    for (Iterator<Vendor> it = vendors.iterator(); it.hasNext();)
        	      {
        		      Vendor testVendor = it.next();
                      ps.setBigDecimal(1,testVendor.getVendorID());  
                      rs = ps.executeQuery();
                      while(rs.next())
                      {
                        if (rs.getInt(1) == 1)
                        	updateVendor(testVendor);
                        else
                        if (rs.getInt(1) == 0)
                        	createVendor(testVendor);
                        else
                        	throw new RuntimeException("More than one vendor has Vendor Id");
                      }
        	      }    
                
             }
             catch(SQLException e)
              {
                 System.out.println("Error in save Vendor" + e.getSQLState());
                 System.out.println("/nError Code: " + e.getErrorCode());
                 System.out.println("/nMessage: " + e.getMessage());
                 System.exit( 1 );
              }
             catch(Exception e)
              {
                 System.out.println("unknown Error in save Vendor");
                 System.out.println("/nMessage: " + e.getMessage());
                 System.exit( 1 );
              }
             finally
        	  {
                  rs.close();
            	  ps.close();
        	  }
        
        	}
}

	

