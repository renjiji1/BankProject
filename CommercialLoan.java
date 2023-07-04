package mainTest;

import java.util.Scanner;

public class CommercialLoan{
    
    // Variables in which were used throughout code
  static customer client;  
  private double loanAmount;
  private double interestRate;
  private int creditScore;
  private int loanTerm; 
  private double revenueAmo;
  private int yearsBus; //has to be entered in months
  
  // Default constructor that was used throughtout code
  public CommercialLoan(customer cust) {
	  client = cust;
  }
  public CommercialLoan(double loanAmount, double interestRate, int creditScore, int loanTerm, double revenueAmo, int yearsBus) {
    this.loanAmount = loanAmount;
    this.interestRate = interestRate;
    this.creditScore = creditScore;
    this.loanTerm = loanTerm;
    this.revenueAmo = revenueAmo;
    this.yearsBus = yearsBus;
    
}

  // Methods
  // Below shows how the monthly interest rate, the monthly payment, and the total interest were created
  
  public  double getMonthlyPayment() {
    double monthlyInterestRate = this.interestRate / 12; // 12 represents the months
    double monthlyPayment = this.loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -this.loanTerm));
    return monthlyPayment;
  } 

  public double getTotalPayment() {
    return this.getMonthlyPayment() * this.loanTerm;
  }

  public double getTotalInterest() {
    return this.getTotalPayment() - this.loanAmount;
  }
  
    public void Commercial() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("-------------------Welcome to W BanK Commercial Loan Application-------------------");
    System.out.println("");
    
    System.out.print("Enter loan amount: $");
    double loanAmount = scanner.nextDouble();

    System.out.print("Enter interest rate (in decimals) : ");
    double interestRate = scanner.nextDouble();

    System.out.print("Enter credit score: ");
    int creditScore = scanner.nextInt();

    System.out.print("Enter loan term (in months): ");
    int loanTerm = scanner.nextInt();
    
    System.out.print("Enter your businesses revenue amount: $");
    int revenueAmo = scanner.nextInt();
    
    System.out.print("Enter the years your buisness has been open: ");
    int yearsBus = scanner.nextInt();
    

    CommercialLoan loan1 = new CommercialLoan(loanAmount, interestRate, creditScore, loanTerm, revenueAmo, yearsBus);
    System.out.println("Your monthly payment is " + loan1.getMonthlyPayment());
    System.out.println("Your total payment is " + loan1.getTotalPayment());
    System.out.println("Your total interest is " + loan1.getTotalInterest());
    
    // Below demonstrates if the credit score is less than or equal to 600, then theres two different options that will be outputed
    
     if (creditScore >= 600) {
            System.out.println("Congratulations! Your loan has been approved.");
        } else {
            System.out.println("Sorry, your loan has been denied due to your low credit score.");
        }

    // Below asks the customer if they would like to apply for the loan

        System.out.println("Do you want to apply for the loan? (1) yes, (2) no");
        int choice = scanner.nextInt();
        if (choice == 1) 
        {
            System.out.println("Your loan application has been submitted successfully!");
            System.out.println("You will have to pay $" + loanAmount + " per month for the next " + loanTerm + " years ");
            System.out.println("Thank you for applying!");
        } 
        else {
            System.out.println("");
            System.out.println("-------------Thank You for using W Bank Car Loan Application!!!!------------");
        }
        double monthlyFine = (loanAmount + (loanAmount * (interestRate/12) * loanTerm)) / loanTerm;
        boolean exit = false;
	    while(!exit) {
	        System.out.println("(1) Make a monthly payment? (2) Return to Menu");
	        Scanner scan = new Scanner(System.in);
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
	                if(account.Withdraw(monthlyFine)) {
	                    loanAmount -= monthlyFine;
	                } else {
	                	System.out.println("Not enough money, try another account");
	                }
	            } else {
	            	Savings account = (Savings)client.getAccounts().get(option);
	                if(account.withdrawn(monthlyFine)) {
	                    loanAmount -= monthlyFine;
	                } else {
	                	System.out.println("Not enough money, try another account");
	                }
	            }
	            System.out.println("Your current debt is: " + loanAmount);
	            System.out.println("Your interest was : " + interestRate/12 * (loanAmount + monthlyFine));
	        }
	        if(monthlyPay == 2) {
	            exit = true;
	        }
	    }
    }
}
