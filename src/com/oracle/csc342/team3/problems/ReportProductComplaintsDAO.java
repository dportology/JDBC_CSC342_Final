package com.oracle.csc342.team3.problems;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportProductComplaintsDAO {
	

public StringBuffer getSkillSummary() throws SQLException
{

    StringBuffer productComplaintsReport = new StringBuffer(500);
	int ccount = 0;
    int pid = 0;
    String productDescription = null;
    
    Connection con = null;
    PreparedStatement ps= null;
    ResultSet rs=null;
    
    
    try
    {
    
    	con = DBConnect.getConnection();
    	ps=con.prepareStatement("SELECT W.CCOUNT, W.PID, P.PRODUCT_DESCRIPTION "
    			+ "FROM Team3.PRODUCT P JOIN (SELECT PRODUCT_ID AS PID, COUNT(PRODUCT_ID) AS CCOUNT "
    			+ "FROM Team3.ORDER_LINE WHERE ORDER_ID IN (SELECT ORDER_ID FROM Team3.CUST_COMPLAINT) "
    			+ "GROUP BY PRODUCT_ID) W ON P.PRODUCT_ID = W.PID");
        
    	rs=ps.executeQuery();
    	productComplaintsReport.append(String.format("%5s %5s %40s\n","Complaint Count","Product ID","Product Desc"));
        while(rs.next())
        {
        	ccount = rs.getInt(1);
            pid = rs.getInt(2);
            productDescription = rs.getString(3);
            
            String outRow = String.format("%4d \t%4d\t\t%40s \n", ccount, pid, productDescription);
            productComplaintsReport.append(outRow);
                
        }
        System.out.println("Display Complete");
    }
    catch(SQLException e)
    {
        System.out.println("SQL Error in get skill summary" + e.getSQLState());
        System.out.println("/nError Code: " + e.getErrorCode());
        System.out.println("/nMessage: " + e.getMessage());
        System.exit( 1 );
    }
    catch(Exception e)
    {
        System.out.println("unknown Error in get skill summary");
        System.out.println("/nMessage: " + e.getMessage());
        System.exit( 1 );
    }
    finally
	{
		if (con != null)
			System.out.println("closing Person connection \n");
			rs.close();
			ps.close();
	}
    return productComplaintsReport;
}

}

	

