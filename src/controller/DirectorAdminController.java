package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import model.Buyer;
import model.ProductDetails;
import model.UserDetails;
import dao.*;

public class DirectorAdminController {
	
	public void directorAdmin() throws Exception {
		
		//Object creation
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DirectorAdminOperations da=new DirectorAdminOperations();
		
		//local variables
		int choice;
		
		do {	
		System.out.println("1.Add User");
		System.out.println("2.Update User");
		System.out.println("3.Remove User");
		System.out.println("4.View Users List");
		System.out.println("5.Add Product");
		System.out.println("6.Update Product");
		System.out.println("7.Remove Product");
		System.out.println("8.View Product List");
		choice=Integer.parseInt(br.readLine());
		switch(choice) {
		case 1:System.out.println("=======================================================");
		       System.out.println("enter user id");
		       Long userid=Long.parseLong(br.readLine()); 
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
		       UserDetails user=new UserDetails(userid,firstname,lastname,email,phone,usertype);
		       da.addUser(user);
		       System.out.println("Succesfull inserted user");
		       System.out.println("====================================================");
		       
		       break;
		case 2:System.out.println("-------------------------------------------------------");
		      System.out.println("enter user_Id");
		      Long user_id=Long.parseLong(br.readLine());
		      da.updateUser(user_id);
		       break;
		case 3:System.out.println("--------------------------------------------------------");
		       System.out.println("enter user_Id");
		       Long id_user=Long.parseLong(br.readLine());
		       da.removeUSer(id_user);
		       System.out.println("--------------------------------------------------------");
		       break;
		case 4:System.out.println("====================================================");
               da.viewUserList();
               System.out.println("====================================================");
               break;

		case 5:System.out.println("====================================================");
		       System.out.println("enter product id");
		       int productid=Integer.parseInt(br.readLine());
		       System.out.println("enter product name");
		       String productname=br.readLine();
		       System.out.println("enter product cost");
		       float productcost=Float.parseFloat(br.readLine());
		       ProductDetails product=new ProductDetails(productid,productname,productcost);
		       da.addProduct(product);
		       System.out.println("----------------------------------------------------");
		       break;       
		case 6:System.out.println("====================================================");
		       System.out.println("enter vegetable id ");
		       int id_product=Integer.parseInt(br.readLine());
		       da.productUpdate(id_product);
		       
		       System.out.println("====================================================");
		       break;
		case 7:System.out.println("====================================================");
		       break;
		case 8:System.out.println("====================================================");
		       da.viewProductList();
		       System.out.println("====================================================");
		       break;
		default:System.out.println("You entered Wrong one");
		       break;
		}
		}while(choice !=9 && choice >9);
	}	

}
