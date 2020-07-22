package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.BuyerController;
import model.Buyer;
import utility.ConnectionManager;

public class Register {
	
	//object creation
	BuyerController bc=new BuyerController();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Connection con;
	ConnectionManager cm=new ConnectionManager();
	
 public void buyerRegister(Buyer buyer)throws Exception {
	 
	 //calling method of getConnection in ConnectionManager class
	 con=cm.getConnection();
	 
	 //writing query
	 String query="insert into buyer(buyer_ID,firstname,lastname,email,phone,password,confirmpassword,city,state,zip)values(?,?,?,?,?,?,?,?,?,?)";
	 
	 //creating prepare statement
	 PreparedStatement ps=con.prepareStatement(query);
	 
	//setting into table
	 ps.setLong(1,buyer.getBuyerid());
	 ps.setString(2, buyer.getFirstname());
	 ps.setString(3, buyer.getLastname());
	 ps.setString(4, buyer.getEmail());
	 ps.setString(5, buyer.getPhone());
	 ps.setString(6, buyer.getPassword());
	 ps.setString(7, buyer.getConfpassword());
	 ps.setString(8, buyer.getCity());
	 ps.setString(9, buyer.getState());
	 ps.setLong(10, buyer.getZip());
	 
	 //processing prepare statement
	 int count=ps.executeUpdate();
	 
	 System.out.println("Registration successfully completed");
		 
		 //close all connections
		 ps.close();	
	 con.close();
	 
 }
 public void buyerlogin() {}
}
