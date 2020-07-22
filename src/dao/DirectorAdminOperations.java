package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

import model.Buyer;
import model.ProductDetails;
import model.UserDetails;
import utility.ConnectionManager;

public class DirectorAdminOperations {
	
    //object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Connection con;
	ConnectionManager cm=new ConnectionManager();
	
     public void addUser(UserDetails user) throws Exception {
    	 
         //calling method of getConnection in ConnectionManager class
    	 con=cm.getConnection();
    	 
    	 //creating prepare statement
    	 PreparedStatement ps=con.prepareStatement("insert into userdetails(user_ID,user_firstname,user_lastname,email,phone,user_type)values(?,?,?,?,?,?)");
    	 
    	 //setting values into database
         ps.setLong(1, user.getUserid());
    	 ps.setString(2, user.getFirstname());
    	 ps.setString(3, user.getLastname());
    	 ps.setString(4, user.getEmail());
    	 ps.setString(5, user.getPhone());
    	 ps.setString(6, user.getUsertype());
    	 
    	 //executing prepare statement
    	 int count=ps.executeUpdate();
    	 
 		 System.out.println(count+"row/s affecteded");
 		 
 		 //close all connections
 		 ps.close();	
    	 con.close();
    	 }
     
     public void updateUser(Long user_id) throws Exception {
    
    //calling method of getConnection in ConnectionManager class	 
	 con=cm.getConnection();
	 
	 //creating prepare statement
	 PreparedStatement ps=con.prepareStatement("UPDATE userdetails SET user_firstname=?,user_lastname=?,email=?,phone=?,user_type=? where user_ID="+user_id);
	 
	 //taking input from user
     System.out.println("enter firstname");
     String firstname=br.readLine(); 
     System.out.println("enter lastname");
     String lastname=br.readLine(); 
     System.out.println("enter email");
     String email=br.readLine();
     System.out.println("enter phone number");
     String phone=br.readLine();
     System.out.println("enter user type");
     String usertype=br.readLine();
     
     //setting values into table
     ps.setString(1, firstname);
     ps.setString(2, lastname);
     ps.setString(3, email);
     ps.setString(4, phone);
     ps.setString(5, usertype);
    
     //processing prepare statement
     int count=ps.executeUpdate();
     System.out.println(count+"row/s user updated succesfully");
     
     //closing all connections
		ps.close();	
 	    con.close();
    }
     
     public void removeUSer(Long id_user) throws Exception {
    	 
    	//calling method of getConnection in ConnectionManager class 
	     con=cm.getConnection();
	     
	     //creating prepare statement
	     PreparedStatement ps=con.prepareStatement("DELETE FROM userdetails where user_ID="+id_user);
	     
	     //executing prepare statement
	     int count=ps.executeUpdate();
	     
	     System.out.println(count+"row/s user deleted succusfully");
	     
	     //closing all connections
		 ps.close();	
	 	 con.close();
     }
    public void viewUserList() throws Exception {
    	
    	//connection establishing
    	con=cm.getConnection();
    	String query="select * from Userdetails";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	System.out.println();
    	System.out.println("Users_id      user_firstname      user_last_name      phone_number      user_type");
    	System.out.println();
    	while(rs.next()){
    	//fetching values
        System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getString(6));
    	}
        //closing all connections
        st.close();
        con.close();
    } 
	public void addProduct(ProductDetails product) throws Exception {
		
		//connection establishing
	     con=cm.getConnection();
	     
	     //creating Prepare statement
	    PreparedStatement ps=con.prepareStatement("insert into productdetails(product_ID,productname,cost)values(?,?,?)");
        
	    //setting values into table
		ps.setInt(1, product.getProduct_ID());
		ps.setString(2, product.getProductname());
		ps.setFloat(3, product.getCost());
		
		//proceed Prepare Statement
		 int count=ps.executeUpdate();
    	 
		System.out.println(count+"row/s affecteded");
		
		//closing all connections	
		ps.close();	
 	    con.close();
	
	}
	public void productUpdate(int id_product) throws Exception{
		
		//calling method of getConnection in ConnectionManager class
		 con=cm.getConnection();
		 
		 System.out.println();
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE productdetails SET productname=?,cost=? where product_ID="+id_product);
		 
		 //taking input from user
		 System.out.println("enter vegetable name");
		 String productname=br.readLine();
		 System.out.println("enter vegetable cost");
		 float cost=Float.parseFloat(br.readLine());
		 
		 //setting values
		 ps.setString(1, productname);
		 ps.setFloat(2, cost);
		
		//processing prepare statement
		 int count=ps.executeUpdate();
		 
		 System.out.println(count+"row/s vegetable information updated succesfully");
		 
		 // closing all connections 
			ps.close();	
	 	   con.close();
		 
	}
     
	
	public void viewProductList() throws Exception  {
		
		//writing query
        String query="select * from productdetails";
        //connection establishing
        con=cm.getConnection();
        
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	System.out.println();
    	System.out.println("Product_id     product_name      cost");
    	System.out.println();
    	while(rs.next()){
    	//fetching values
        System.out.println(rs.getInt(1)+"                 "+rs.getString(2)+"              "+rs.getFloat(3));
    	}
        //closing all connections
        st.close();
        con.close();
		
	}

}