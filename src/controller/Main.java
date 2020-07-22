package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//generate local date and time
		LocalDateTime ldt=LocalDateTime.now();
		
		//DateTime formating
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
		
		
		System.out.println();
		System.out.println("===============================================================================");
		System.out.println("WELCOME TO ELECTRONIC VEGETABLE MARKERT              Date: "+ldt.format(dtf));
		System.out.println("===============================================================================");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice;
		
		while(true) {
			System.out.println("1.Director-Admin");
			System.out.println("2.Buyer");
			System.out.println("3.Seller");
			System.out.println("4.Visitor");
			
			choice=Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:System.out.println();
				   System.out.println("---------------------------------------------------");
			       DirectorAdminController a=new DirectorAdminController();
			       a.directorAdmin();
			       break;
			case 2:System.out.println("====================================================");
			       BuyerController bc=new BuyerController();
			       bc.buyerService();
			       System.out.println("====================================================");
			       break;
			case 3:System.out.println("====================================================");
			       System.out.println("Seller");
			       System.out.println("====================================================");
	               break;
			case 4:System.out.println("====================================================");
		           System.out.println("Visitor");
		           System.out.println("====================================================");
                   break;        
		 default:System.out.println("You entered wrong one!");
				   break;    
			}
		}
		
	}

}

