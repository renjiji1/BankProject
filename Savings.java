package mainTest;

import java.util.ArrayList;
import java.util.Scanner;
public class Savings {
 
    private String AccountNumber = null;
    private double Balance;
    private static double InterestRate = .026;
    private Scanner input = new Scanner(System.in);

    // constructors///
    public Savings()
    {
        AccountNumber = generateAccountNumber();
        double Balance = 0;
        double InterestRate = 0.0025;;
    }

    // to get the methods///
    public String getAccountNumber() {
        return AccountNumber;
    }

    public String generateAccountNumber()
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1 ; i < 10 ; i++)
        {
            numbers.add((int)(Math.random() * 10));
        }
        return numbers.toString().replace("[" , "").replace(" " , "").replace("," , "").replace("]" , "");
    } 
    
    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getInterestRate() {
        return InterestRate;

    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }


    // when deposit increase balanace///
    public void deposit(double amount) {
        Balance = Balance+ amount;

    }
    ///when withdraw more than balance////
    public boolean withdrawn(double amount) {
        if (amount > Balance) {
            return false;
        }

        ////if it is less so withdraw//
        Balance -= amount;

        return true;
    }
    ///interest rate///

    public double calculateInterest() {
        return Balance * InterestRate;
    }

    public void balanacedep(){
        System.out.println("Welcome to your savings account!");
        System.out.println("Your account number is: " + AccountNumber);
        System.out.println("Your current balance is: " + Balance);
        System.out.println("This is your interest rate on this account - 2.6%");
        boolean exit = false;
        while(!exit) {
        	System.out.println("(1) Withdraw (2) Deposit (3) Get Balance (4) Get Interest (5) Return to Menu");
        	int option = input.nextInt();
        	if(option == 1 ){
        		System.out.println("Enter the amount you would like to withdraw: ");
	            double withdraw = input.nextDouble();
	            if(withdrawn(withdraw)) {
	            	System.out.println("Your new balance is: " + Balance);
	            } else {
	            	System.out.println("Not enough money");
	            }  
	        }
	        if(option == 2){
				System.out.println("Enter the amount you would like to deposit: ");
	            double deposit = input.nextDouble();
	            Balance += deposit;
	            System.out.println("Your new balance is: " + Balance);
	        }
	        if(option == 3) {
	        	System.out.println("Your current balance is: " + (Balance));
	        }
	        if(option == 4) {
	        	Balance += calculateInterest();
	        	System.out.println("Your new balance after interest is: " + (Balance));
	        }
	        if(option == 5) {
	        	exit = true;
	        }
        }
        



        
    }
}