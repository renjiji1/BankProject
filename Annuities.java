package mainTest;

import java.util.Scanner;
import java.math.*;

public class Annuities 
{
	customer client;
	Annuities(customer cust) {
		client = cust;
	}
    public void testMethod()
    {
    	System.out.println("**********************W-BANK ANNUITY CALCULATOR**********************");
    	
    	Scanner annuityScanner = new Scanner(System.in);
    	System.out.println("How much money do you want to deposit and will receive in increments every month?");
    	double principal = annuityScanner.nextDouble(); //checkings account
    	
    	boolean enoughMoney = false;
    	
    	while(!enoughMoney) {
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
	            if(account.Withdraw(principal)) {
	                enoughMoney = true;
	                System.out.println("Principle paid!");
	            } else {
	            	System.out.println("Not enough money, try another account");
	            }
	        } else {
	        	Savings account = (Savings)client.getAccounts().get(option);
	            if(account.withdrawn(principal)) {
	            	enoughMoney = true;
	            	System.out.println("Principle paid!");
	            } else {
	            	System.out.println("Not enough money, try another account");
	            }
	        }
	        
    	}
    	
		
    	System.out.println("As of now, how many months do you plan to keep this payment: ");
    	
		int month = annuityScanner.nextInt();
		System.out.println("Interest Rates: \nAgressive: 4.4%\nModerate: 4% \nConservative: 3.6%");
		System.out.println("Please enter the type of annuity you want to get (Aggressive: 1; Moderate: 2; Conservative: 3)");
    	int type = annuityScanner.nextInt ();
    	
    	if (type==1)
    	{
    		System.out.println("You have chosen the aggressive annuity, meaning there will be a higher interest rate.");
    		Calculator(1.1, principal, month);
    	}
    	
    	if (type==2)
    	{
    		System.out.println("You have chosen the moderate annuity, meaning the interest rate stays the same.");
    		Calculator(1, principal, month);
    	}
    	
    	if (type==3)
    	{
    		System.out.println("You have chosen the conservative annuity, meaning there will be a lower interest rate.");
    		Calculator(0.9, principal, month);
    	}
    
    }
    
    public static void Calculator(double r, double p, int n)
    {
    	double test1 = Math.pow(1+0.04*r, -n);
        double PV = (1-test1)/(r*0.04);
        double annuity = p/PV;
        
        if (n < 12)
        {
        	
        }
        else
        {
        	int feeMonth = n/12;
            double fee = feeMonth * 0.0025;
            annuity -= (annuity * fee);
        } 
        
        System.out.println("$" + String.format("%.2f", annuity));
    }
}