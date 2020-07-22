package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Date;

import model.Cart;
import model.OrderProduct;
import utility.ConnectionManager;

public class BuyerOperations {
	
	 //object creation
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Connection con;
		ConnectionManager cm=new ConnectionManager();

	public void seeProfile(Long buyerid) throws Exception{
	
	//calling method of getConnection in ConnectionManager class
	 con=cm.getConnection();
	 
	 //writing query
	 String query="select * from Buyer where buyer_ID="+buyerid;
	//create statement
 	Statement st=con.createStatement();
 	
 	//execute statement
 	ResultSet rs=st.executeQuery(query);
 	System.out.println();
 	System.out.println("Buyer_id    first_name      last_name   email     phone_number    password    confirm_password   city    state     zip ");
 	System.out.println();
 	while(rs.next()){
 		
 	//fetching values
     System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getString(6)+
    		  "  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getLong(10));
 	}
     //closing all connections
     st.close();
     con.close();
}

	public void editProfile(Long buyerid)throws Exception {
		
		 //calling method of getConnection in ConnectionManager class	 
		 con=cm.getConnection();
		 
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE buyer SET firstname=?,lastname=?,email=?,phone=?,password=?,confirmpassword=?,city=?,state=?,zip=? where buyer_ID="+buyerid);
		 
		 //taking input from user
	     System.out.println("enter firstname");
	     String firstname=br.readLine(); 
	     System.out.println("enter lastname");
	     String lastname=br.readLine(); 
	     System.out.println("enter email");
	     String email=br.readLine();
	     System.out.println("enter phone number");
	     String phone=br.readLine();
	     System.out.println("enter pasword number");
	     String password=br.readLine();
	     System.out.println("enter confirm password number");
	     String confopassword=br.readLine();
	     System.out.println("enter your city number");
	     String city=br.readLine();
	     System.out.println("enter your state number");
	     String state=br.readLine();
	     System.out.println("enter your zip");
	     long zip=Long.parseLong(br.readLine());
	     
	     //setting values into table
	     ps.setString(1, firstname);
	     ps.setString(2, lastname);
	     ps.setString(3, email);
	     ps.setString(4, phone);
	     ps.setString(5, password);
	     ps.setString(6, confopassword);
	     ps.setString(7, city);
	     ps.setString(8, state);
	     ps.setLong(9, zip);
	    
	     //processing prepare statement
	     int count=ps.executeUpdate();
	     System.out.println(count+"row/s user updated succesfully");
	     
	     //closing all connections
			ps.close();		
	}
	public void viewVegetableInfo() throws Exception {
		 DirectorAdminOperations daop=new  DirectorAdminOperations(); 
		 daop.viewProductList();
	}

	public void orderProduct(OrderProduct product)throws Exception {
		
		 //calling method of getConnection in ConnectionManager class
   	 con=cm.getConnection();
   	 
   	 //writing query
   	 String query="insert into order_product(to_street,to_city,to_state,to_zip,paymenttype,buyer_id,dispatches_date,dispatches_time,vegetablename,quantity,money_paid)values(?,?,?,?,?,?,?,?,?,?,?)";
   	 
   	 //generating local time object
   	 LocalDateTime  localDateTime=LocalDateTime.now();
     //get localDate and localTime object from above
   	 LocalDate localDate= localDateTime.toLocalDate();
   	 LocalTime localTime=localDateTime.toLocalTime();
   	 
   	//covert Date,time values from local to sql
   	 java.sql.Date date=java.sql.Date.valueOf(localDate);
   	 java.sql.Time time=java.sql.Time.valueOf(localTime);
   	 
   	 
   	 //creating prepare statement
   	 PreparedStatement ps=con.prepareStatement(query);
   	 
   	 //setting values into database
     ps.setString(1,product.getStreet());
     ps.setString(2, product.getCity());
     ps.setString(3, product.getState());
     ps.setLong(4, product.getZip());
     ps.setString(5, product.getPaymentmethod());
     ps.setLong(6, product.getBuyerid());
     ps.setDate(7, date);
     ps.setObject(8, time);
     ps.setString(9, product.getItemname());
     ps.setLong(10, product.getQuantity());
     ps.setFloat(11, product.getBill());
  
   	 //executing prepare statement
   	 int count=ps.executeUpdate();
   	 
		 System.out.println("Your order Succussfully completed, your  Welcome !");
		 
		 //close all connections
		 ps.close();	
   	 con.close();
		
	}

	public void addCart(Cart cart)throws Exception {
		
		
		 //calling method of getConnection in ConnectionManager class
  	 con=cm.getConnection();
  	 
  	 //writing query
  	 String query="insert into cart(quantity,product_name)values(?,?)";
  	 
	 //creating prepare statement
   	 PreparedStatement ps=con.prepareStatement(query);
  	 
   	 ps.setInt(1, cart.getQuantity());
   	 ps.setString(2, cart.getItemname());
   	 
   //executing prepare statement
   	 int count=ps.executeUpdate();
   	 
		 System.out.println("Succussfully completed  Cart");
		 
		 //close all connections
		 ps.close();	
   	 con.close();
	}

	
}