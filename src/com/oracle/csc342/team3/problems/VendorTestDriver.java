package com.oracle.csc342.team3.problems;
import java.sql.*;
import java.math.*;
import java.util.*;

//maintain vendor and product
//queries:
//what are the most complained about products
//what area/territory received the most/least complaints and which reps from those areas fields the most complaints
//which is the highest/lowest paying jobs based on skills

public class VendorTestDriver {
	
	List<Vendor> contacts = new ArrayList<Vendor>();
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
		BigDecimal nextVendorId = new BigDecimal(1);
		Address address;
		Connection conn;
		
 		conn = DBConnect.getConnection(hostname, port, sid, id, pwrd);
 		VendorDAO vendorDAO = new VendorDAO();
		nextVendorId  = vendorDAO.findMaxVendorID();
		nextVendorId = nextVendorId.add(increment);
	    Vendor v = new Vendor(nextVendorId);
	    BigDecimal vendorID = new BigDecimal(12);
	    v.setVendorID(vendorID);
	    v.setVendorName("flambe");
	    address = new Address();
	    v.setAddress(address);
	    v.address.setStreetAddress("61 New King St");
	    v.address.setCity("Enfield");
	    v.address.setState("Connecticut");
	    v.address.setPostalCode("06082");
	    v.address.setCity("Enfield");
	    v.setPhoneNum("1-860-745-7745");
	    v.setFaxNum("1-860-745-3002");
	    v.setVendorContact("Alex Davenport");
	    BigDecimal taxID = new BigDecimal(21);
	    v.setTaxID(taxID);
	   
	    contacts.add(v);
	    
	    vendorDAO.saveVendors(contacts);
	    
	    conn.commit();

	   // personDAO.savePeople(contacts);
	   // conn.commit();
	   // Reports2DAO skills = new Reports2DAO();
	   // StringBuffer skillsReport = skills.getSkillSummary();
	   // System.out.println(skillsReport);
	    	    
	}

	public void printContacts() throws Exception {
		
		
		Iterator<Vendor> it=contacts.iterator();
		int vendorNumber = 0;
        while(it.hasNext())

		{
        	vendorNumber++;
        	Vendor vendors =(Vendor)it.next();

			System.out.println(" Vendor " + vendorNumber + " = " + vendors.toString());
		}
	
	}
	
	public static void main(String[] args)  
	{
		
	    /*  This command instantiates a class instance passing the connection object.  */   
	    VendorTestDriver testVendor = new VendorTestDriver();

        try {
        	   
			   /*  call purge method to delete all rows from new summary table   */    
	    	   
	    	   //testPerson.setHostname(args[0]);
	    	   //testPerson.setPort(args[1]);
	    	   //testPerson.setSid(args[2]);
	    	   //testPerson.setId(args[3]);
	    	   //testPerson.setPwrd(args[4]);
	    	   
        	testVendor.setHostname("localhost");
        	testVendor.setPort("1521");
        	testVendor.setSid("CSC342");
        	testVendor.setId("system");
        	testVendor.setPwrd("9872598725");
	    	    
        	testVendor.testCreate();
        	testVendor.printContacts();
	    }
	    catch (Exception ex) {
	    	 System.out.println("Error in testing");
	    	 System.out.println(ex.getMessage());
         	 ex.printStackTrace();
         	 System.exit( 1 );
	    }
	}

	}
