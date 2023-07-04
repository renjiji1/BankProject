package mainTest;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;

class ARMortgage {
    
    private int principal;
    private float annualInterest;
    private float monthlyInterest;
    private int years;
    private int numberOfPayments;
    private double mortgage;
    customer client;
    
    public ARMortgage(customer cust)  { 
        this.principal = principal; 
        this.annualInterest = annualInterest; 
        this.monthlyInterest = monthlyInterest;
        this.years = years; 
        this.numberOfPayments = numberOfPayments;
        this.mortgage = mortgage;
        client = cust;
    } 

    
    public void ARMortgageCalc() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much money do you want loaned: ");
        this.principal = scanner.nextInt();

        System.out.println("Annual Interest Rate: ");
        this.annualInterest = scanner.nextFloat();
        this.monthlyInterest = annualInterest / 100 / 12;

        System.out.println("Period (Years): ");
        this.years = scanner.nextInt();
        this.numberOfPayments = years * 12;

        this.mortgage = this.principal * (this.monthlyInterest * Math.pow(1 + this.monthlyInterest, this.numberOfPayments)) / (Math.pow(1 + this.monthlyInterest, this.numberOfPayments) - 1);
       
        System.out.println("Mortgage per month: " + mortgage);
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
            if(account.Withdraw(mortgage)) {
                System.out.println("You have successfully paid off your fee");
            } else {
            	System.out.println("Not enough money, try another account");
            }
        } else {
        	Savings account = (Savings)client.getAccounts().get(option);
            if(account.withdrawn(mortgage)) {
            	System.out.println("You have successfully paid off your fee");
            } else {
            	System.out.println("Not enough money, try another account");
            }
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
    }
}