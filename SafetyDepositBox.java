package mainTest;

import java.util.ArrayList;
import java.util.Scanner;

class SafetyDepositBox 
{

    private String userLocation;
    private ArrayList<String> contents;
    private customer client;
    private int maxItems;
    private double annualRate;

    public SafetyDepositBox(String userLocation, customer cust) 
    {
        this.userLocation = userLocation;
        contents = new ArrayList<String>();
        client = cust;
    }

    public void createNewBox() 
    {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Let's create a new Safety Deposit Box.");
        System.out.print("How many items do you want to store in your box? (5, 10, 15 or custom): ");
        String numItems = scanner.nextLine();
        if (numItems.equalsIgnoreCase("5")) 
        {
            maxItems = 5;
        } 
        else if (numItems.equalsIgnoreCase("10")) 
        {
            maxItems = 10;
        } 
        else if (numItems.equalsIgnoreCase("15")) 
        {
            maxItems = 15;
        } else {
            System.out.print("Enter the number of items you want to store in your box: ");
            maxItems = scanner.nextInt();
        }
        annualRate = maxItems * 5.0;
        System.out.println("Annual rate for your box is $" + annualRate);
        contents = new ArrayList<String>(maxItems);
        System.out.println("Your new Safety Deposit Box is ready to use.");
    }

    public String addItem() 
    {
        if (contents.size() == maxItems) 
        {
            return "You have reached the maximum number of items allowed in your box.";
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter what you would like to add to your Safety Deposit Box: ");
            String item = scanner.nextLine();
            contents.add(item);
            return "We added the item, " + item + ", to your contents.";
        }
    }

    public String removeItem() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the slot number of what you would like to remove from your Safety Deposit Box: ");
        int itemRemove = scanner.nextInt();
        contents.remove(itemRemove);
        return "We removed the item in slot " + itemRemove + " from your contents.";
    }

    public String replaceItem() 
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Please enter the slot number of what you would like to replace from your Safety Deposit Box: ");
        int itemNumber = scanner.nextInt();
        System.out.print("Please enter an item to replace it from your Safety Deposit Box: ");
        String replacedItem = scanner1.nextLine();
        contents.set(itemNumber, replacedItem);
        return "We removed the item in slot " + itemNumber + " from your contents and replaced it with " + replacedItem + ".";
    }

    public String getContents() 
    {
        String items = "";
        for (String item : contents) 
        {
            items += item + ", ";
            System.out.println(item);
        }
        return "Your Safety Deposit Box that is located in " + this.userLocation + " contains " + items;
    }

    public double getAnnualRate() 
    {
        System.out.println("Your annual rate is $" + annualRate + " per year.");
        return annualRate;
    }

    public String PayAnnualRate() 
    {
     Scanner scan = new Scanner(System.in);
      System.out.println("which account would you like to use?: ");
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
          if(account.Withdraw(getAnnualRate())) {
        	 return "Successfully paid, thank you!";
          } else {
          	return "Not enough money, try another account please.";
          }
      } else {
      	Savings account = (Savings)client.getAccounts().get(option);
          if(account.withdrawn(getAnnualRate())) {
        	  return "Successfully paid, thank you!";
          } else {
          	return "Not enough money, try another account please.";
          }
      }
  }
} 
