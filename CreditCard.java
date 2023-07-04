package mainTest;

////////From the humans: Madison and King Soham IV
///New new new NEW NEWcode


////////////////////////////////////////////////////////importing the checking account class
//import CheckingAccount;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;


class CreditCard //Blueprint
{
	private String a;
	private String b;
	private String c;
	private String d;
	private int e;
	private double g;
	private double h;
	private double i;
	private double j;
	 double debt = 0;
	customer client;
	
	
	public CreditCard(String cardnumber, String ExpDate, String CVC, String user, int withdraw, double InterestRate, double CashAdvanceFee, double MonthlyPayment, double StatementBalance)
	{
		a=cardnumber;
		b=ExpDate;
		c=CVC;
		d=user;
		e=withdraw;
		g=InterestRate;
		h=CashAdvanceFee;
		i=MonthlyPayment;
		j=StatementBalance;
	}
	
	public CreditCard(customer cust)
	{
		a = "0000000000000000";
		b = "00/00";
		c = "000";
		d = "Anakin Skywalker";
		e = 0;
		g = .19;
		h = 0;
		i = 0;
		j = 0;
		client = cust;
	
	}
	
	public void getValues()
	{
	
	
	//////////////////////////////////////////// MAIN MENU FOR CREDIT CLASS
		int moneywithdrawed = e;
		System.out.println("Welcome! We will generate your card in a moment.");
	    
	    int creditcardnumberpart1 = ((int)(Math.random()*9000)+1000) ;//Creates 1st part of creditcardnumber
	    int creditcardnumberpart2 = ((int)(Math.random()*9000)+1000);//Creates 2nd part of creditcardnumber
	    int creditcardnumberpart3 = ((int)(Math.random()*9000)+1000);//Creates 3rd part of creditcrdnumber
	    int creditcardnumberpart4 = ((int)(Math.random()*9000)+1000);//Creates 4rth part of creditcardnumbeR
	   
	    //Credit Cardnumber formation from int to string
	    String a = String.valueOf(creditcardnumberpart1) + String.valueOf(creditcardnumberpart2) + String.valueOf(creditcardnumberpart3) + String.valueOf(creditcardnumberpart4);
	     
	    System.out.println("Your Card Number:" + a );
	    
	    //Formation of Expiration Date
	    String slash = "/";
	    String b = ((int)(Math.random()*12)+1) + slash + ((int)(Math.random()*99)+22);
	    
	    
	    System.out.println("Your expiration Date: " + b);
	    
	    //Formation of CVC
	    int securitycode = ((int)(Math.random()*999)+100);
	    String c = String.valueOf(securitycode);
	    System.out.println("Your CVC is: " + c);
	    
	      boolean exit = false;
	      while(!exit) {
	    	  System.out.println("What would you like to do with your credit card? (1) Pay monthly bills (2) Pay (3) Exit");
			  Scanner pay = new Scanner (System.in);
			  int bills = pay.nextInt();
			  
			  if(bills == 1)
			  {
			      ////////////////////////////////// ASKS THE USER WHETHER THEY WANT TO PAY MINIMUM AMOUNT OF MAX
			      System.out.println("Would you like to pay your (1) full amount, or (2) the minimum?");
			      Scanner balance = new Scanner(System.in);
			      int minormax = balance.nextInt();
			      
			      double monthlyPay = 0;
			      if(minormax == 1)
			      {
				      monthlyPay = debt;
			      }
			      if(minormax == 2) 
			      {
			          System.out.println("Interest is added to your unpayed payment (19%)");
			    	  monthlyPay = debt * .15;
			    	  debt += debt * g;
			    	  
			      }
			      
	                System.out.println("which account would you like to use? ");
	                int actNum = 1;
	                for(int i = 0; i < client.getAccounts().size(); i++) {
	                    String type = "";
	                    if(client.getAccounts().get(i) instanceof CheckingAccount) {
	                        type = "Checkings";
	                        CheckingAccount account = (CheckingAccount)client.getAccounts().get(i);
	                        System.out.println("(" + actNum + ")" + account.GetAccountNumber() + " : "  + type);
	                    } else {
	                        type = "Savings";
	                        Savings account = (Savings)client.getAccounts().get(i);
	                        System.out.println("(" + actNum + ")" + account.getAccountNumber() + " : "  + type);
	                    }
	                    actNum++;
	                }
	                Scanner scan = new Scanner(System.in);
	                int option = scan.nextInt()-1;
	                if(client.getAccounts().get(option) instanceof CheckingAccount) {
	                	CheckingAccount account = (CheckingAccount)client.getAccounts().get(option);
	                    if(account.Withdraw(monthlyPay)) {
	                        debt -= monthlyPay;
	                    } else {
	                    	System.out.println("Not enough money, try another account");
	                    }
	                } else {
	                	Savings account = (Savings)client.getAccounts().get(option);
	                    if(account.withdrawn(monthlyPay)) {
	                        debt -= monthlyPay;
	                    } else {
	                    	System.out.println("Not enough money, try another account");
	                    }
	                }
	                System.out.println("Your current debt is: " + debt);
			  }
			    //if they typed withdraw
		      if(bills == 2)
		      {
			      System.out.println("How much money do you want to pay?");
			      Scanner responseformoneywithdrawed = new Scanner(System.in);
			      double withdraw = responseformoneywithdrawed.nextDouble();              
	              debt += withdraw;
	              System.out.println("You have successfully payed $" + withdraw);
		              
	          } 
		      if(bills == 3) {
		    	  exit = true;
		      }
	     }           
	}     
}
