package mainTest;

import java.util.Scanner; 
import java.util.ArrayList;
import java.time.Month;

class HomeEquityLoan {
    public static customer client;
    HomeEquityLoan(customer cust) {
    	client = cust;
    }
    public static void homeEquityLoanSchedule() {
        
        double loanAmount = 0.0;
        double loanTerm = 0.0;
        double interestRate = .06;
        double startMonth = 0.0;
        double startYear = 0.0;
        int startDay = 1;
        double balance = loanAmount;
        double paymentMonth = startMonth;
        double paymentYear = startYear;
        double totalInterest = 0.0;
        double monthlyPayment = 0.0;
        double payment = 0.0;
        double monthlyPrincipal = 0.0;
        double monthlyInterest = 0.0;
        boolean loop = true;
        double homeValue = 0.0;
        double mortgageBalance = 0.0;
        
        while (loop == true) {
            // Menu
            System.out.println("");
            System.out.println("-------------------Welcome to W Bank Home Equity Loan Manager------------------");
            System.out.println("");
            Scanner menu = new Scanner(System.in);
            System.out.print("Enter 1 to create a new home equity loan // Enter 2 to open current home equity loan // Enter 3 to quit program :  ");
            int selection = menu.nextInt();
            if (selection == 3) {
                System.out.println("");
                System.out.println("Thank you for using W Bank Home Equity Loan Manager. Exiting program...");
                loop = false;
            }
            else if (selection == 1) {  
                System.out.println("");
                System.out.println("-----New Home Equity Loan Form-----");
                System.out.println("");
                Scanner loanInfo = new Scanner(System.in);
            
                // Form to collect loan data from user
                
                // Question 7: Home Value
                System.out.print("Enter estimated home value ($): ");
                homeValue = loanInfo.nextDouble();
                
                // Question 6: Mortgage Balance
                System.out.print("Enter current mortgage balance ($): ");
                mortgageBalance = loanInfo.nextDouble();
                
                double LTV = (mortgageBalance / homeValue) * 100;
                double maxLoanAmount = (.8 * homeValue) - mortgageBalance;
                System.out.println("Current Loan-to-Value Ratio: " + LTV);
                System.out.println("Maximum Loan Amount: " + maxLoanAmount);
                System.out.println("");

                // Question 1: Loan Amount
                System.out.print("Enter loan amount ($): ");
                loanAmount = loanInfo.nextDouble();
                if (loanAmount <= maxLoanAmount) {
                }
                else {
                    System.out.println("Invalid Loan Amount.");
                    loanAmount = 0.0;
                }
                    
                
                // Question 2: Loan Term
                System.out.print("Enter loan term (in months): ");
                loanTerm = loanInfo.nextInt();

                // Question 4: Start Month
                System.out.print("Enter start month number: ");
                startMonth = loanInfo.nextInt();

                // Question 5: Start Year
                System.out.print("Enter start year: ");
                startYear = loanInfo.nextInt();
                
                System.out.println("");
                System.out.println("Student Loan Created. Go to open current loan to view and make payments. Exiting...");
            }
            else if (selection == 2) {
                      
                balance = loanAmount;
                paymentMonth = startMonth;
                paymentYear = startYear;
                totalInterest = 0.0;
                monthlyPayment = 0.0;

                // Schedule Labels
                System.out.println("");
                System.out.println("----------------------------------------Current Student Loan Schedule----------------------------------------");
                System.out.println("");
                ArrayList<String> scheduleHeaders = new ArrayList<String>();
                scheduleHeaders.add("Payment Month");
                scheduleHeaders.add("Payment Year");
                scheduleHeaders.add("Monthly Payment");
                scheduleHeaders.add("Monthly Principal");
                scheduleHeaders.add("Monthly Interest");
                scheduleHeaders.add("Total Interest");
                scheduleHeaders.add("Current Balance");
                System.out.println(scheduleHeaders);
        
                for(int i=1;i<=loanTerm;i++){  
                    
                    
                    // Calculating Payment Date
                    paymentMonth += 1;
                    if (paymentMonth > 12) {
                        paymentYear += 1;
                        paymentMonth = 1;
                    }
                    String PaymentMonth = String.format("%02.0f", paymentMonth)+"";
            
                    // Calculating Payment Year
                    String PaymentYear = String.format("%.0f", paymentYear)+"";
            
                    // Calculating Monthly Payment
                    monthlyPayment = loanAmount * ((interestRate/12)/(1-(Math.pow(1+(interestRate/12),(-1*loanTerm)))));
                    String MonthlyPayment = String.format("%.2f", monthlyPayment)+"";    
            
                    // Calculating Monthly Interest
                    monthlyInterest = (balance * interestRate) / 12;
                    String MonthlyInterest = String.format("%.2f", monthlyInterest)+"";
                
                    //Calculating Total Interest
                    totalInterest = totalInterest + monthlyInterest;
                    String TotalInterest = String.format("%.2f", totalInterest)+"";
            
                    // Calculating Monthly Principal
                    monthlyPrincipal = monthlyPayment - monthlyInterest;
                    String MonthlyPrincipal = String.format("%.2f", monthlyPrincipal)+"";
            
                    // Calculating Balance
                    balance = balance - monthlyPrincipal;
                    String Balance = String.format("%.2f", balance)+"";
            
                    // Printing Schedule
                    ArrayList<String> scheduleData = new ArrayList<String>();
                    scheduleData.add("......"+ PaymentMonth + "......");
                    scheduleData.add("...." + PaymentYear + "....");
                    scheduleData.add("...$" + MonthlyPayment + "...");
                    scheduleData.add("....$" + MonthlyPrincipal + "....");
                    scheduleData.add("....$" + MonthlyInterest + "....");
                    scheduleData.add("....$" + TotalInterest + "....");                        
                    scheduleData.add("....$" + Balance + "....");
                    System.out.println(scheduleData);
                  
                }
        
                Scanner menu2 = new Scanner(System.in);
                System.out.println("");
                System.out.print("Enter 1 to make a payment // Enter 2 to quit: ");
                int selection2 = menu2.nextInt();
                
                if (selection2 == 1) {
                    System.out.println("Your payment is $" + String.format("%.2f", monthlyPayment));
                    Scanner menu3 = new Scanner(System.in);
                    boolean enoughMoney = false;
                    System.out.print("Enter 1 to confirm transaction // Enter 2 to decline: ");
                    int selection3 = menu3.nextInt();
                    if (selection3 == 1) {
                        Scanner scan = new Scanner(System.in);
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
                            if(account.Withdraw(monthlyPayment)) {
                                enoughMoney = true;
                            } else {
                            	System.out.println("Not enough money, try another account");
                            }
                        } else {
                        	Savings account = (Savings)client.getAccounts().get(option);
                            if(account.withdrawn(monthlyPayment)) {
                            	enoughMoney = true;
                            } else {
                            	System.out.println("Not enough money, try another account");
                            }
                        }
                        
                        startMonth += 1;
                        if (paymentMonth > 12) {
                        paymentYear += 1;
                        paymentMonth = 1;
                        }
                        monthlyPayment = loanAmount * ((interestRate/12)/(1-(Math.pow(1+(interestRate/12),(-1*loanTerm)))));
                        monthlyInterest = (balance * interestRate) / 12;
                        totalInterest = totalInterest + monthlyInterest;
                        monthlyPrincipal = monthlyPayment - monthlyInterest;                        
                        loanTerm = loanTerm - 1;
                        if(enoughMoney) {
                        	loanAmount = loanAmount - monthlyPrincipal;
                        }
                        System.out.println("Your current debt is: " + loanAmount);  
                        System.out.println("Transaction completed. Exiting...");
                    }
                    else if (selection3 == 2) {
                        System.out.println("Transaction declined. Exiting...");
                    }
                }
                else if (selection2 == 2) {
                    System.out.println("Exiting...");
                }
            }  
            else {
                System.out.println("");
                System.out.println("Not a valid input. Restarting...");
            }
        }
    }
}
