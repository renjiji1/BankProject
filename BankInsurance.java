package mainTest;

import java.util.Scanner;
import java.text.NumberFormat;

class BankInsurance {
    private static final double BASE_RATE = 0.025;

    private double jewelry;
    private double electronics;
    private double clothing;
    private double furniture;
    private double assets;
    private int age;
    private int numAccidents;
    private double premium;
    private double homeValue;
    private int homeAge;
    private int claims;
    private double vehicleValue;
    private String coverage;
    customer client;
    
    public BankInsurance(customer cust) 
    {
        this.jewelry = jewelry;
        this.electronics = electronics;
        this.clothing = clothing;
        this.furniture = furniture;
        this.assets = assets;
        this.premium = premium;
        this.age = age;
        this.numAccidents = numAccidents;
        this.vehicleValue = vehicleValue;
        this.homeValue = homeValue;
        this.homeAge = homeAge;
        this.claims = claims;
        this.coverage = coverage;
        client = cust;
    }
    
    public void account() 
    {
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (i < 1)
        {
            System.out.println("Which Insurance would you like to apply to?");
            System.out.println("(1) Renters Insurance \n(2) Automotive Insurance \n(3) Home-Owners Insurance \n(4) Exit");
            System.out.print("Enter Option: ");
            int option = input.nextInt();
            System.out.println();
            
            double rate = 0;
            if (option == 1)
            {
            	rate = calculateRentersInsurance();
                System.out.println("Your insurance rate is: " + rate);
            }
            else if (option == 2)
            {
            	rate = calculateAutomotiveInsurancePremium();
            	System.out.println("Your insurance rate is: " + rate);
            }
            else if (option == 3)
            {
            	rate = calculateHomeownersInsurancePremium();
            	System.out.println("Your insurance rate is: " + rate);
            }
            else if (option == 4)
            {
                System.out.print("Successfully exited");
                i++;
            }
            else
            {
                System.out.println("Sorry, Try Again");
            }
            if(option >= 1 && option <= 3) {
            	System.out.println("which account would you like to use? ");
    	        int actNum = 1;
    	        for(int a = 0; a < client.getAccounts().size(); a++) {
    	            String type = "";
    	            if(client.getAccounts().get(a) instanceof CheckingAccount) {
    	                type = "Checkings";
    	                CheckingAccount account = (CheckingAccount)client.getAccounts().get(a);
    	                System.out.println("(" + actNum + ")" + account.GetAccountNumber() + " : "  + type);
    	            } else {
    	                type = "Savings";
    	                Savings account = (Savings)client.getAccounts().get(a);
    	                System.out.println("(" + actNum + ")" + account.getAccountNumber() + " : "  + type);
    	            }
    	            actNum++;
    	        }
    	        Scanner scan = new Scanner(System.in);
    	        int option2 = scan.nextInt()-1;
    	        if(client.getAccounts().get(option2) instanceof CheckingAccount) {
    	        	CheckingAccount account = (CheckingAccount)client.getAccounts().get(option2);
    	            if(account.Withdraw(rate)) {
    	                System.out.println("rate paid!");
    	            } else {
    	            	System.out.println("Not enough money, try another account");
    	            }
    	        } else {
    	        	Savings account = (Savings)client.getAccounts().get(option2);
    	            if(account.withdrawn(rate)) {
    	            	System.out.println("rate paid!");
    	            } else {
    	            	System.out.println("Not enough money, try another account");
    	            }
    	        }
            }
        }
    } 

    public double calculateRentersInsurance() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the total value of all your jewelry?: ");
        this.jewelry = scanner.nextDouble();
        System.out.print("What is the total value of all your electronics?: ");
        this.electronics = scanner.nextDouble();
        System.out.print("What is the total value of all your clothing?: ");
        this.clothing = scanner.nextDouble();
        System.out.print("What is the total value of all your furniture?: ");
        this.furniture = scanner.nextDouble();
        System.out.print("What is the total value of other assets?: ");
        this.assets = scanner.nextDouble();
        this.premium = ((this.jewelry + this.electronics + this.clothing + this.furniture + this.assets) * BASE_RATE) /12;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Your monthly renters insurance will be " + formatter.format(this.premium));
        return this.premium;
    }

    public double calculateAutomotiveInsurancePremium() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the value of your vehicle?: ");
        this.vehicleValue = scanner.nextDouble();
        System.out.print("What is the age of the vehicle?: ");
        this.age = scanner.nextInt();
        System.out.print("How many accidents was this vehicle in?: ");
        this.numAccidents = scanner.nextInt();
        this.premium = this.vehicleValue * 0.005;
        if (this.age >= 5) {
            this.premium *= 1.2;
        }
        
        if (this.numAccidents > 0) {
            this.premium *= (1 + (0.1 * this.numAccidents));
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Your monthly auto insurance will be " + formatter.format(this.premium));
        return this.premium;
    }
    
    public double calculateHomeownersInsurancePremium() 
    {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("What is the estimated value of your home?: ");
	    this.homeValue = scanner.nextDouble();
	    System.out.print("What is the age of your home?: ");
	    this.homeAge = scanner.nextInt();
	    System.out.print("How many claims have you made on your homeowners insurance in the past 5 years?: ");
	    this.claims = scanner.nextInt();
	    
	    this.premium = homeValue * 0.005;
	    if (this.homeAge >= 20) {
	        this.premium *= 1.2;
	    } else if (this.homeAge >= 10) {
	        this.premium *= 1.1;
	    }
	    if (this.claims > 0) {
	        this.premium *= (1 + (0.2 * this.claims));
	    }
	    System.out.print("Do you want to add earthquake/flood coverage? (y/n): ");
	    this.coverage = scanner.next();
	    if (this.coverage.equalsIgnoreCase("y")) {
	        this.premium += this.homeValue * 0.002;
	    }
	    this.premium = this.premium / 12;
	    NumberFormat formatter = NumberFormat.getCurrencyInstance();
	    System.out.println("Your monthly homeowners insurance will be " + formatter.format(this.premium));
	    return this.premium;
    }
} 

