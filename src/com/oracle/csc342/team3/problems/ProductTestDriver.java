package com.oracle.csc342.team3.problems;
import java.sql.*;
import java.math.*;
import java.util.*;

//maintain vendor and product
//queries:
//what are the most complained about products
//what area/territory received the most/least complaints and which reps from those areas fields the most complaints
//which is the highest/lowest paying jobs based on skills

public class ProductTestDriver {
	
	List<Product> contacts = new ArrayList<Product>();
	String hostname;
	String port;
	String sid;
	String id;
	String pwrd;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String inHostname) {
		this.hostname = inHostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String inPort) {
		this.port = inPort;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String inSid) {
		this.sid = inSid;
	}

	public String getId() {
		return id;
	}

	public void setId(String inId) {
		this.id = inId;
	}

	public String getPwrd() {
		return pwrd;
	}

	public void setPwrd(String inPwrd) {
		this.pwrd = inPwrd;
	}
      

	public void testCreate() throws SQLException, Exception {
		
		
		BigDecimal increment = new BigDecimal(1);
		BigDecimal nextProductId = new BigDecimal(1);  
		Connection conn;
		
 		conn = DBConnect.getConnection(hostname, port, sid, id, pwrd);
		ProductDAO productDAO = new ProductDAO();
		nextProductId  = productDAO.findMaxProductId();
		nextProductId = nextProductId.add(increment);
	    Product p = new Product(nextProductId);
	    BigDecimal productID = new BigDecimal(1234);
	    p.setProductID(productID);
	    BigDecimal lineID = new BigDecimal(10);
	    p.setLineID(lineID);
	    p.setProductDesc("dat dank");
	    p.setProductFinish("datepic finish doh");
	    BigDecimal standardPrice = new BigDecimal(5);
	    p.setProductStandardPrice(standardPrice);
	    contacts.add(p);
	    
	    productDAO.saveProducts(contacts);
	    
	    conn.commit();

	   // personDAO.savePeople(contacts);
	   // conn.commit();
	   // Reports2DAO skills = new Reports2DAO();
	   // StringBuffer skillsReport = skills.getSkillSummary();
	   // System.out.println(skillsReport);
	    	    
	}

	public void printContacts() throws Exception {
		
		
		Iterator<Product> it=contacts.iterator();
		int productNumber = 0;
        while(it.hasNext())

		{
        	productNumber++;
			Product products =(Product)it.next();

			System.out.println(" Product " + productNumber + " = " + products.toString());
		}
	
	}
	
	public static void main(String[] args)  
	{
		
	    /*  This command instantiates a class instance passing the connection object.  */   
	    ProductTestDriver testProduct = new ProductTestDriver();

        try {
        	   
			   /*  call purge method to delete all rows from new summary table   */    
	    	   
	    	   //testPerson.setHostname(args[0]);
	    	   //testPerson.setPort(args[1]);
	    	   //testPerson.setSid(args[2]);
	    	   //testPerson.setId(args[3]);
	    	   //testPerson.setPwrd(args[4]);
	    	   
        	testProduct.setHostname("localhost");
        	testProduct.setPort("1521");
        	testProduct.setSid("CSC342");
        	testProduct.setId("system");
        	testProduct.setPwrd("9872598725");
	    	    
        	testProduct.testCreate();
	    	//testProduct.printContacts();
	    	
        	ReportProductComplaintsDAO test = new ReportProductComplaintsDAO();
	    	StringBuffer x = test.getSkillSummary();
	    	
	    	String s = x.toString();
	    	
	    	System.out.println(s);
	    }
	    catch (Exception ex) {
	    	 System.out.println("Error in testing");
	    	 System.out.println(ex.getMessage());
         	 ex.printStackTrace();
         	 System.exit( 1 );
	    }
	}

	}
