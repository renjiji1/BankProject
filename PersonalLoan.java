package mainTest;

import java.util.Scanner;
import mainTest.customer;
import mainTest.CheckingAccount;
import mainTest.Savings;

public class PersonalLoan {
    public static customer client;
    private static double weeklyRate;
    PersonalLoan(customer cust) {
        client = cust;
        weeklyRate = 0;
    }
    public static void Personal() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the W Bank Personal Loan Office");
        System.out.println("How much would you like to loan out?");
            double loan = scan.nextDouble();

        System.out.println("Your requested amount is $" + loan);
        System.out.println();
        System.out.println("Over how many weeks would you like to pay the loan off? (52 = 1 year)");
            int weeks = scan.nextInt();

            // Takes credit score from input and subtracts 1000 from it to form an interest rate based on their credit score
            // Then rounds the  Total interest and divides it by 100 to put it into decimal form            
        System.out.println("What is your credit score?");
            int credit = scan.nextInt();       
                double interest1 = 1000 - (credit); 
                double interest = interest1 / 50; 
            int totalInterest = (int)Math.round(loan * interest/100);
        
        boolean exit = false;
        weeklyRate = loan / weeks;
        if (credit > 0) {
            if (credit == 0) {
                System.out.println("Your credit score is invalid");
            }
            else if (credit > 850) {
                System.out.println("Your credit score is invalid");
            }
            else if (credit < 450) {
                System.out.println("Your credit score is too low for a personal loan at W Bank");
            }
            else {
                System.out.println();
                // Then it shows all of the information on the loan to the user
                System.out.println("************************************************");
                    
                System.out.println("Credit Score: " + credit);
                System.out.println("Loan amount: $" + loan);
                System.out.println("Total interest: $" + totalInterest);
                System.out.println("$" + weeklyRate +  " weekly for " + weeks + " weeks");    
                System.out.println("************************************************"); 
            }
        }
        
        while(!exit) {
            System.out.println("(1) Make a monthly payment? (2) Make another loan (3) Exit");
            int monthlyPay = scan.nextInt();
            if(monthlyPay == 1) {
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
                int option = scan.nextInt()-1;
                if(client.getAccounts().get(option) instanceof CheckingAccount) {
                	CheckingAccount account = (CheckingAccount)client.getAccounts().get(option);
                    if(account.Withdraw(weeklyRate)) {
                        loan -= weeklyRate;
                    } else {
                    	System.out.println("Not enough money, try another account");
                    }
                } else {
                	Savings account = (Savings)client.getAccounts().get(option);
                    if(account.withdrawn(weeklyRate)) {
                        loan -= weeklyRate;
                    } else {
                    	System.out.println("Not enough money, try another account");
                    }
                }
                System.out.println("Your current debt is: " + loan);
            }
            if(monthlyPay == 2) {
                System.out.println("How much would you like to take out? ");
                double amount = scan.nextDouble();
                loan += amount;
                System.out.println("your new total debt is " + loan);
                System.out.println("How many weeks would you like to pay it off for? ");
                int wks = scan.nextInt();
                weeks += wks;
                System.out.println("the total amount of weeks is now " + weeks);
            }
            if(monthlyPay == 3) {
                exit = true;
            }
        }
	} 
}
