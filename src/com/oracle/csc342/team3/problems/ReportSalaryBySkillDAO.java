package com.oracle.csc342.team3.problems;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportSalaryBySkillDAO {
	

public StringBuffer getSkillSummary() throws SQLException
{

    StringBuffer salaryBySkillsReport = new StringBuffer(500);
	String inSkillId = null;
    String inSkillDesc = null;
    double inSalary = 0.0;
    
    Connection con = null;
    PreparedStatement ps= null;
    ResultSet rs=null;
    
    
    try
    {
    
    	con = DBConnect.getConnection();
    	ps=con.prepareStatement("SELECT W.AVGSAL, W.SKID, S.SKILL_DESCRIPTION FROM Team3.SKILL S "
    			+ "JOIN (SELECT ROUND(AVG(ES.SALARY),2) AS AVGSAL, ESK.SKILL_ID AS SKID "
    			+ "FROM Team3.EMPLOYEE_SALARY ES JOIN "
    			+ "Team3.EMPLOYEE_SKILLS ESK ON ES.EMPLOYEE_ID = ESK.EMPLOYEE_ID GROUP BY ESK.SKILL_ID) W "
    			+ "ON S.SKILL_ID = W.SKID "
    			+ "ORDER BY AVGSAL ASC");

    	rs=ps.executeQuery();
    	salaryBySkillsReport.append(String.format("%20s %20s %20s\n","Average Salary","Skill ID", "Skill Description"));
        while(rs.next())
        {
        	
        	inSalary = rs.getInt(1);
            inSkillId = rs.getString(2);
            inSkillDesc = rs.getString(3);
            
            String outRow = String.format("%.3f \t%20s %20s\n", inSalary, inSkillId, inSkillDesc);
            salaryBySkillsReport.append(outRow);
                
        }
        System.out.println("Display Complete");
    }
    catch(SQLException e)
    {
        System.out.println("SQL Error in get salary summary" + e.getSQLState());
        System.out.println("/nError Code: " + e.getErrorCode());
        System.out.println("/nMessage: " + e.getMessage());
        System.exit( 1 );
    }
    catch(Exception e)
    {
        System.out.println("unknown Error in get salary summary");
        System.out.println("/nMessage: " + e.getMessage());
        System.exit( 1 );
    }
    finally
	{
		if (con != null)
			System.out.println("closing salary summary connection \n");
			rs.close();
			ps.close();
	}
    return salaryBySkillsReport;
}


}

	

