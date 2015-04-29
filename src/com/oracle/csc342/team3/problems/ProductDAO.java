package com.oracle.csc342.team3.problems;

import java.math.BigDecimal;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
	
    public void createProduct(Product product) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps= null;
        
        System.out.println("Product to be Inserted \n");
        System.out.println(product.toString());
        
		try
        {
            
        	con = DBConnect.getConnection();
            ps=con.prepareStatement("insert into Team3.product (PRODUCT_ID, PRODUCT_LINE_ID, PRODUCT_DESCRIPTION, PRODUCT_FINISH, PRODUCT_STANDARD_PRICE) values(?,?,?,?,?)");
            ps.setBigDecimal(1, product.getProductID());
            ps.setBigDecimal(2,product.getLineID());
            ps.setString(3,product.getProductDesc());
            ps.setString(4,product.getProductFinish());
            ps.setBigDecimal(5,product.getProductStandardPrice());
            
            ps.executeUpdate();
            System.out.println("Addition Success");
        
        }
        catch(SQLException e)
        {
            System.out.println("Error in Create Product" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());

            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in Create Product");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
		finally
		{
			if (con != null)
				System.out.println("closing Product create statement \n");
			    ps.close();
				
		}
        
    }

    
    public BigDecimal findMaxProductId() throws SQLException
    {
        BigDecimal maxProductId = new BigDecimal(0);
        
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        
        try
        {
        	con = DBConnect.getConnection();
        	ps=con.prepareStatement("SELECT MAX(P.PRODUCT_ID) FROM Team3.PRODUCT P");
            
            rs=ps.executeQuery();
            while(rs.next())
            {
            	maxProductId = rs.getBigDecimal(1);
                System.out.println("Get Max Product Id Success ");      
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error in get max product access " + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in get max product");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing product connection \n");
    			rs.close();
    			ps.close();
    	}
        return maxProductId;
    }

public Product viewProduct(BigDecimal productID) throws SQLException
    {

    
        ResultSet rs=null;
        Product outProduct = new Product();
        Connection con = null;
        PreparedStatement ps=null;
        
        try
        {
    
        	con = DBConnect.getConnection();
        	ps=con.prepareStatement("SELECT * FROM Team3.PRODUCT P WHERE P.PRODUCT_ID =?");
            ps.setBigDecimal(1, productID);

            rs=ps.executeQuery();
            while(rs.next())
            {
            	outProduct.setProductID(rs.getBigDecimal(1));
            	outProduct.setLineID(rs.getBigDecimal(2));
            	outProduct.setProductDesc(rs.getString(3));
            	outProduct.setProductFinish(rs.getString(4));
            	outProduct.setProductStandardPrice(rs.getBigDecimal(5));
                
                /* don't need to set parent, must be done when you instantiate the ee class (must setup past classes correctly. */
                
                System.out.println("View Product Success");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error in Product view access" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in Product view access");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing Product connection \n");
				rs.close();
				ps.close();	
    	}
        return outProduct;
    }
	public void updateProduct(Product product) throws SQLException
    {
    
		System.out.println("Product to be Updated \n");
		System.out.println(product.toString());
		Connection con = null;
    	PreparedStatement ps= null;
    	
        try
        {

        	con = DBConnect.getConnection();
            
        	ps=con.prepareStatement("update Team3.product p set p.product_line_id = ?, p.product_description = ?,"
        			+ "p.product_finish = ?, p.product_standard_price = ? where product_id = ?");
           
        	ps.setBigDecimal(1, product.getLineID());
        	ps.setString(2, product.getProductDesc());
        	ps.setString(3, product.getProductFinish());
        	ps.setBigDecimal(4, product.getProductStandardPrice());
        	ps.setBigDecimal(5, product.getProductID());
        	
            ps.executeQuery();
            System.out.println("updated");
        }
        catch(SQLException e)
	        {
	            System.out.println("Error in Product Update" + e.getSQLState());
	            System.out.println("/nError Code: " + e.getErrorCode());
	            System.out.println("/nMessage: " + e.getMessage());
	            System.exit( 1 );
	        }
	    catch(Exception e)
	        {
	            System.out.println("unknown Error in Product Update");
	            System.out.println("/nMessage: " + e.getMessage());
	            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing Product connection \n");
				ps.close();
    	}
    }
	public void deleteProduct(BigDecimal productID) throws SQLException
    {
    
		System.out.println("Product to be Deleted \n");
		System.out.println("Product Id = " + productID + "\n");
		
		
		Connection con = null;
    	PreparedStatement ps=null;
    	
        try
        {
    
        	con = DBConnect.getConnection();
            ps=con.prepareStatement("delete Team3.product where product_id=?");
            ps.setBigDecimal(1,productID);
            ps.executeQuery();
            System.out.println("deleted");
        }
        catch(SQLException e)
        {
            System.out.println("Error in Product Delete" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        catch(Exception e)
        {
            System.out.println("unknown Error in Product delete");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit( 1 );
        }
        finally
    	{
    		if (con != null)
    			System.out.println("closing Product connection \n");
				ps.close();
				
    	}
    }

    	public void countProducts() throws SQLException
        {
        
        	Connection con = null;
        	PreparedStatement ps= null;
        	ResultSet rs = null;
        	String sql1 = "SELECT COUNT(*) FROM Team3.PRODUCT;";
        	
            try
            {
        
            	con = DBConnect.getConnection();
                ps=con.prepareStatement(sql1);
                int productCt = 0;
                
                rs = ps.executeQuery();
                while(rs.next())
                {
                    productCt = rs.getInt(1);
                }    
                System.out.println("count Products success " + productCt);
            }
            catch(SQLException e)
            {
                System.out.println("Error in count Products" + e.getSQLState());
                System.out.println("/nError Code: " + e.getErrorCode());
                System.out.println("/nMessage: " + e.getMessage());
                System.exit( 1 );
            }
            catch(Exception e)
            {
                System.out.println("unknown Error in count Products");
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

    	public void saveProducts(List<Product> products) throws SQLException
        {
        
        	Connection con = null;
        	
        	String sql1 = "Select count(*) as product_count from Team3.Product p WHERE p.product_id = ?";
        	PreparedStatement ps = null;
        	ResultSet rs = null;

        	try
            {
    
        	    con = DBConnect.getConnection();
                ps=con.prepareStatement(sql1);

        	    for (Iterator<Product> it = products.iterator(); it.hasNext();)
        	      {
        		      Product testProduct = it.next();
                      ps.setBigDecimal(1,testProduct.getProductID());  
                      rs = ps.executeQuery();
                      while(rs.next())
                      {
                        if (rs.getInt(1) == 1)
                        	updateProduct(testProduct);
                        else
                        if (rs.getInt(1) == 0)
                        	createProduct(testProduct);
                        else
                        	throw new RuntimeException("More than one product has Product Id");
                      }
        	      }    
                
             }
             catch(SQLException e)
              {
                 System.out.println("Error in save Product" + e.getSQLState());
                 System.out.println("/nError Code: " + e.getErrorCode());
                 System.out.println("/nMessage: " + e.getMessage());
                 System.exit( 1 );
              }
             catch(Exception e)
              {
                 System.out.println("unknown Error in save Product");
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

	

