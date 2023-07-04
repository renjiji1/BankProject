package mainTest;

import java.util.Scanner;
import java.util.ArrayList;

public class CheckingAccount{
    private long routingNumber;
    private double balance;
    private double interest;
    private String accountNumber;

    CheckingAccount(double balanceP) {
        balance = balanceP;
        interest = 1.0023;
        routingNumber = (long) (Math.random() * 1000000000);
        accountNumber = generateAccountNumber();
    }

    public void account() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nAccount Number:  " + accountNumber);
        System.out.println("Routing Number:  " + routingNumber + "\n");

        int i = 0;
        while (i < 1)
        {
            System.out.println("(1) Deposit Money \n(2) Withdraw Money \n(3) Interest Earned \n(4) Get Balance \n(5) Return to menu");
            System.out.println("Your interest rate is: .23%");
            System.out.print("Enter Option: ");
            int option = input.nextInt();
            System.out.println();

            if (option == 1)
            {
                System.out.print("Enter Amount to Deposit: ");
                double amount = input.nextDouble();
                System.out.println("$"+ amount + " Deposited to the Account\n");
                Deposit(amount);
                System.out.println("Total Amount in Account: " + GetBalance() + "\n");                
            }
            else if (option == 2)
            {
                System.out.print("Enter Amount to Withdraw: ");
                double amount = input.nextDouble();
                System.out.println("$"+ amount + " Withdrawn from the Account\n");
                Withdraw(amount);
                System.out.println("Total Amount in Account: " + GetBalance() + "\n");               
            }
            else if (option == 3)
            {
                System.out.print("Enter Amount of years that passed: ");
                int amount = input.nextInt();
                GetInterest(amount);
                System.out.println("Total Amount in Account: " + GetBalance() + "\n");                
            }
            else if (option == 4) {
            	System.out.print("This is your current Balance: " + balance);
            }
            else if (option == 5)
            {
                System.out.print("Successfully logged out");
                i++;
            }
            else
            {
                System.out.println("Sorry, Try Again");
            }
        }
    } 

    public boolean Withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void Deposit(double amount) {
        balance += amount;
    }

    public double GetBalance() {
        return balance;
    }

    public void GetInterest(int years) {
        balance *= interest * years;
    }
    public String GetAccountNumber() {
        return accountNumber;
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
}
