package mainTest;

/* Madison Kravitz & Soham Purav
Bonds Class */

//ignore
/*import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;*/

import java.util.Date;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

class Bonds
{
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private double f;
    private double g;
    private double h;
    private double i;
    private double j;
    customer client;
    double bondsAmount = 0;

    public Bonds(String input, String confirm, String dateSell, String dateBuy, int days, double purchaseprice, double amount, double interest, double withInterest, double total)
    {
        a = input;
        b = confirm;
        c = dateSell;
        d = dateBuy;
        e = days;
        f = purchaseprice;
        g = amount;
        h = interest;
        i = withInterest;
        j = total;
    }
    
    public Bonds(customer cust)
    {
        a = "BUY";
        b = "confirm";
        c = "MM/DD/YYY";
        d = "MM/DD/YYY";
        e = 365;
        f = 25.0;
        g = 25.0;
        h = 6.89;
        i = 2514.85;
        j = 2879.85;
        client = cust;
    }
    

    public void bondUse()
    {
        boolean exit = false;
        while(!exit) {
        	System.out.println("Hello! (1) Buy a bond (2) Sell a bond (3) Exit");
            
            Scanner inputScan = new Scanner(System.in);
            int input = inputScan.nextInt();
        	if(input == 1)
	        {
	            System.out.println("You may purchase from $25 to $10,000 in electronic bonds. Please type in the amount you wish to purchase, including a comma if necessary");
	            Scanner amountScan = new Scanner(System.in);
	            bondsAmount = amountScan.nextDouble(); 
	            
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
                    if(account.Withdraw(bondsAmount)) {
                    
                    	System.out.println("You have purchased $" + bondsAmount + " worth of bonds.");
                    } else {
                    	bondsAmount = 0;
                    	System.out.println("Not enough money, try another account");
                    }
                } else {
                	Savings account = (Savings)client.getAccounts().get(option);
                    if(account.withdrawn(bondsAmount)) {
                    	System.out.println("You have purchased $" + bondsAmount + " worth of bonds.");
                    } else {
                    	bondsAmount = 0;
                    	System.out.println("Not enough money, try another account");
                    }
                }
                
	        }
	        if(input == 2)
	        {
	            //figure out time between dates to see how much interest has been collected
	            System.out.println("Please enter the amount of days it's been since you purchased the bonds.");
	            Scanner dateSellScan = new Scanner(System.in);
	            int days = dateSellScan.nextInt();
	            
            	System.out.println("Please enter how much money worth of bonds you wish to sell. (must be less than the amount of bonds you own)");
	            Scanner purchasePriceScan = new Scanner(System.in);
	            double purchasePrice = purchasePriceScan.nextDouble();
	            if(purchasePrice <= bondsAmount) {
		            bondsAmount -= purchasePrice;
		            
		            double interest = .0689;
		            double withInterest = days * (interest/360) * purchasePrice;// using 360 days to be accurate with real world financial formulas
		            System.out.println("The bond interest rate is currently 6.89% annual, calculated daily. You have earned $" + withInterest + " in interest");
		            
		            double total = purchasePrice + withInterest;
		            
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
	                    account.Deposit(total);
	                } else {
	                	Savings account = (Savings)client.getAccounts().get(option);
	                    account.deposit(total);
	                }
		            System.out.println("In total, you are receiving $" + total + ". Have a nice day!");
	            } else {
	            	System.out.println("Not enough bonds");
	            }
	        
	        }
	        if(input == 3) {
	        	exit = true;
	        }
        }
        
    }
}