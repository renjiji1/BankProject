package mainTest;

import java.util.ArrayList;
import java.util.Scanner;

//import javax.lang.model.util.ElementScanner6;

// By gerard, kelvin, arthur

public class ATM {

    Scanner keyboard = new Scanner(System.in);
    
    private String location;
    private boolean ATM_TYPE; // Just describes whether or not it is the banks atm or not true being it is false being it is not
    private static int ATM_NUM = 0;
    

    public ATM()
    {
        location = "HQ";
        ATM_TYPE = true;
        ATM_NUM = ATM_NUM+1;
        
    }

    public ATM(String loc, Boolean aType)
    {
        location = loc;
        ATM_TYPE = aType;
    }

    public double withdrawMoney(customer cust1)
    {
        double withdrawAmount = 0;

        System.out.println("Please input how much money you would like to withdraw");
        try {
            withdrawAmount = keyboard.nextDouble();
        } catch (Exception numerException) {
            System.out.println("Please do not type in anything but a number");
            withdrawMoney(cust1);
        }
        
        // Placeholder code until I get the account class
    
        System.out.println("Which account would you like to use, please type the number as they are listed out.?");
        ArrayList<Object> accountList = cust1.getAccounts();
        for(int i = 0; i < accountList.size();i++)
        {
            if (accountList.get(i).getClass().equals(CheckingAccount.class))
            {
                System.out.println(i + " " +  ((CheckingAccount) accountList.get(i)).GetAccountNumber());
            }
            else if (accountList.get(i).getClass().equals(Savings.class)) 
            {
                System.out.println(i + " " +  ((Savings) accountList.get(i)).getAccountNumber());
            }
            else if (accountList.get(i).getClass().equals(MoneyMarket.class))
            {
                System.out.println(i + " " +  ((MoneyMarket) accountList.get(i)).getAccountNumber());
            }
           
        }
        
        int index = keyboard.nextInt();

        

        if(accountList.get(index).getClass().equals(CheckingAccount.class))
        {
            
            if (((CheckingAccount) accountList.get(index)).Withdraw(withdrawAmount))
            {
                System.out.println("You have withdrawn your money!");
                return withdrawAmount;
            }
            
        }
        else 
        {
            
            if (((Savings) accountList.get(index)).withdrawn(withdrawAmount))
            {
                System.out.println("You have withdrawn your money!");
                return withdrawAmount;
            }
        }
        return 0.0;

        
    }

    public void depositMoney(customer cust1)
    {
        int depositAmount = 0;

        System.out.println("Please input how much money you would like to deposit");
        try {
            depositAmount = keyboard.nextInt();
        } catch (Exception numerException) {
            System.out.println("Please do not type in anything but a number");
            depositMoney(cust1);
        }
        
      
    
        System.out.println("Which account would you like to use, please type the number as they are listed out.?");
        ArrayList<Object> accountList = cust1.getAccounts();
        for(int i = 0; i < accountList.size();i++)
        {
            if (accountList.get(i).getClass().equals(CheckingAccount.class))
            {
                System.out.println(i + " " +  ((CheckingAccount) accountList.get(i)).GetAccountNumber());
            }
            else if (accountList.get(i).getClass().equals(Savings.class)) 
            {
                System.out.println(i + " " +  ((Savings) accountList.get(i)).getAccountNumber());
            }
            else if (accountList.get(i).getClass().equals(MoneyMarket.class))
            {
                System.out.println(i + " " +  ((MoneyMarket) accountList.get(i)).getAccountNumber());
            }
           
        }
        
        int index = keyboard.nextInt();

        if(accountList.get(index).getClass().equals(CheckingAccount.class))
        {
            System.out.println("You have deposited your money!");
            ((CheckingAccount) accountList.get(index)).Deposit(depositAmount);
        }
        else
        {
            System.out.println("You have deposited your money!");
            ((Savings) accountList.get(index)).deposit(depositAmount);
        }

        
    }

    public void setAtmType(boolean aType)
    {
        ATM_TYPE = aType;
    }

    public boolean getAtmType()
    {
        return ATM_TYPE;
    }

    public void setLocation(String loc)
    {
        location = loc;
    }
    

    
    
}
