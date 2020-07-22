package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import dao.BuyerOperations;
import model.Buyer;
import model.Cart;
import model.OrderProduct;
import service.Log_In;
import service.Register;

public class BuyerController {
	
	 //object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 BuyerOperations bo=new BuyerOperations();
	 
	 //local variable
     Long buyerid;
     
	 public void buyerService() throws Exception {
     Log_In li=new Log_In(); 
		 
		 System.out.println("1.Register");
		 System.out.println("2.Log in");
		 //taking input from user
		 int input=Integer.parseInt(br.readLine());
		 System.out.println("===================================================");
		 
		 if(input == 1) {
			 System.out.println("Enter buyer ID");
			   buyerid=Long.parseLong(br.readLine());
				System.out.println("Enter your first name");
				String firstname=br.readLine();
				System.out.println("Enter your last name");
				String lastname=br.readLine();
				System.out.println("Enter your Email");
				String email=br.readLine();
				System.out.println("enter your phone");
				String phone=br.readLine();
				System.out.println("Enter password");
				String password=br.readLine();
				System.out.println("Confirm passsword");
				String confpassword=br.readLine();
				System.out.println("enter your city");
				String city=br.readLine();
				System.out.println("enter your State");
				String state=br.readLine();
				System.out.println("enter your Zip");
				long zip=Long.parseLong(br.readLine());
				Buyer buyer=new Buyer(buyerid,firstname,lastname,email,phone,password,confpassword,city,state,zip);
				 Register r=new  Register();
				r.buyerRegister(buyer);
				}
		       else if(input==2) {
		    	   System.out.println("Enter your Email");
		    	   String email=br.readLine();
					System.out.println("Enter password");
					String password=br.readLine();
					Buyer buyer=new Buyer(email, password);
			    li.buyerLogin(buyer);
		     }
		       else {
			 System.out.println("Sorry you entered wrong");
			 
		 }
		 
	 }
	public void buyer() throws Exception {
		int choice;
		do {
		System.out.println("1.See profile");
		System.out.println("2.Edit profile");
		System.out.println("3.view the vegetable information");
		System.out.println("4.Order item");
		System.out.println("5.Add to cart");
		System.out.println("6.Order cart item or undo cart item");
		System.out.println("7.Give Feedback");
		System.out.println("8.Exit");
		
		 choice=Integer.parseInt(br.readLine());
		
		switch(choice) {
		case 1:System.out.println("=======================================================");
		       System.out.println("Enter your ID");
		       buyerid=Long.parseLong(br.readLine());
		       bo.seeProfile(buyerid);
		       break;
		case 2:System.out.println("=======================================================");
		       System.out.println("Enter your ID");
		       buyerid=Long.parseLong(br.readLine());
		       bo.editProfile(buyerid);
		       System.out.println("Successfully edited your profile");
		       break;
		case 3:System.out.println("=======================================================");
		       System.out.println("Vegetable information ");
		       System.out.println();
		       bo.viewVegetableInfo();
	           break;
		case 4:System.out.println("=======================================================");
		      System.out.println("Enter your ID number");
		      long buyerid=Long.parseLong(br.readLine());
		      System.out.println("Enter vegetable name");
		      String itemname=br.readLine();
		      System.out.println("Enter quntity");
		      long quantity=Long.parseLong(br.readLine());
		      System.out.println("Enter your street address");
		      String street=br.readLine();
		      System.out.println("Enter your city");
		      String city=br.readLine();
		      System.out.println("Enter your State");
		      String state=br.readLine();
		      System.out.println("Enter your zip");
		      long zip=Long.parseLong(br.readLine());
		      System.out.println("Enter payment Method");
		      String paymentmethod=br.readLine();
		      System.out.println("Pay the Bill");
		      float bill=Float.parseFloat(br.readLine());
		      OrderProduct product=new OrderProduct(buyerid, itemname,quantity,street,city,state,zip, paymentmethod,bill);
		      bo.orderProduct(product);
		      
	          break;
		case 5:System.out.println("=======================================================");
		     System.out.println("Enter vegetable name");
		     String item=br.readLine();
		     System.out.println("Enter quantity");
		     int quantity1=Integer.parseInt(br.readLine());
		     Cart cart=new Cart(item,quantity1);
		     bo.addCart(cart);
	         break;
		case 6:System.out.println("=======================================================");
	      break;
		case 7:System.out.println("=======================================================");
	      break;
		case 8:System.out.println("=======================================================");
	      break;
		
		}
	}while(choice !=9 && choice>9);	 
		
	 }
}
