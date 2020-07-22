package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controller.BuyerController;
import model.Buyer;
import utility.ConnectionManager;

public class Log_In {

	  //object creation
	    BuyerController bc=new BuyerController();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Connection con;
		ConnectionManager cm=new ConnectionManager();
	public void buyerLogin(Buyer buyer) throws Exception{
		//connection establishing
    	con=cm.getConnection();
    	
    	String email=buyer.getEmail();
    	String phone=buyer.getPhone();
    	String password=buyer.getPassword();
    	String query="select email,phone,password from buyer";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	while(rs.next()) {
    		String dbemail=rs.getString("email");
    		String dbpassword=rs.getString("password");
    	if((email.equals(dbemail)) && (password.equals(dbpassword)))
    	{
    		System.out.println("Successfully logined");
    		bc.buyer();
    	}
    	else {
    		System.out.println("email/password incorrect");
    	}
	}
	}
}
