package mainTest;

//Matt Esposito and Arav Goyal
import java.util.Scanner;
import java.util.ArrayList;

class DebitCard extends Card{
  private String CardType;
  private double CardAccountBalance;
  double debitWithdrawalFee;
  double debitTransactionFee;
  boolean isdebitActive;

  double amountWithdrawnFromSavings = 0; //this will be used later for a printout

  Scanner DebitInput = new Scanner(System.in);
  String option = "blank"; //used in the withdraw method later
  CheckingAccount connectedAccount;
  customer client;

  public DebitCard()
  {
      isdebitActive = getCardActive();
      debitWithdrawalFee = getWithdrawalFee();
      debitTransactionFee = getTransactionFee();

      CardAccountBalance = 0;
      CardType = "Debit";
  }

  public DebitCard(customer cust)
  {
      client = cust;

  }
  public void card() {  
	  Scanner scan = new Scanner(System.in);
	  
	  boolean exit = false;
	  while(!exit) {
		  System.out.println("Hello! (1) Activate card (2) Connect Checking Account (3) Pay for Something (4) Exit");
		  int option = scan.nextInt();
		  if(option == 1) {
			  isdebitActive = true;
			  System.out.println("Your account is activated!");
		  }
		  if(option == 2) {
			  System.out.println("which account would you like to connect? ");
              int actNum = 1;
              ArrayList<CheckingAccount> checkings = new ArrayList<CheckingAccount>();
              for(int i = 0; i < client.getAccounts().size(); i++) {
                  String type = "";
                  if(client.getAccounts().get(i) instanceof CheckingAccount) {
                      type = "Checkings";
                      CheckingAccount account = (CheckingAccount)client.getAccounts().get(i);
                      System.out.println("(" + actNum + ")" + account.GetAccountNumber() + " : "  + type);
                      checkings.add(account);
                      actNum++;
                  } 
                  
              }
              int optionAcc = scan.nextInt()-1;
          	  CheckingAccount account = checkings.get(optionAcc);
              connectedAccount = account;
              System.out.println(connectedAccount);
		  }
		  if(option == 3) {
			  if(isdebitActive) {
				  System.out.println("What would you like to pay for?");
				  String item = scan.next();
				  System.out.println("How much does it cost?");
				  double price = scan.nextDouble();
				  if(connectedAccount.Withdraw(price)) {
					  System.out.println("successfully payed for " + item + " that cost $" + price);
					  System.out.println("curent balance is " + connectedAccount.GetBalance());
				  } else {
					  System.out.println("not enough money");
				  }
			  }
		  }
		  if(option == 4) {
			  exit = true;
		  }
	  } 
  }
  /*double maxWithdraw;

  public void withdraw(double withdrawAmount)
  {
      if (isdebitActive == true){


          if ((CardAccountBalance - (withdrawAmount + debitWithdrawalFee)) >= 0)
          {
              CardAccountBalance -= withdrawAmount;
              CardAccountBalance -= debitWithdrawalFee;
              //if the user has enough money in their account, it takes the money out
          }

          else
          {
              maxWithdraw = CardAccountBalance;
              System.out.println("There isn't enough money in the account, the most we can withdraw is " + maxWithdraw);
              System.out.println("Would you like to withdraw $" + maxWithdraw + "? Type 'yes' to withdraw. Type 'overdraft' to withdraw anyway. (Overdraft fees will be deducted from your savings account, if available)");

              option = DebitInput.nextLine();

              if (option.equalsIgnoreCase("yes"))
                  CardAccountBalance -= maxWithdraw;

              else if (option.equalsIgnoreCase("overdraft"))
              {
                  if ((((SavingsBalance - (withdrawAmount - CardAccountBalance)) - debitWithdrawalFee) - 20) < 0)
                  {
                      System.out.println("You don't have enough money in your checking and savings account to withdraw $" + maxWithdraw);
                      System.out.println("Would you like to withdraw $" + maxWithdraw + " from your checking account? Type 'yes' or 'no'");
                      option = DebitInput.nextLine();
                      if (option.equalsIgnoreCase("yes"))
                          CardAccountBalance -= maxWithdraw;
                      if (option.equalsIgnoreCase("no"))
                          System.out.println("Transaction cancelled");
                  }
                  else
                  {
                      CardAccountBalance -= maxWithdraw;
                      amountWithdrawnFromSavings = ((SavingsBalance - (withdrawAmount - CardAccountBalance)) - debitWithdrawalFee);
                      SavingsBalance -= (withdrawAmount - CardAccountBalance);
                      SavingsBalance -= 20;
                      System.out.println("Successfully withdrew $" + maxWithdraw + " from your checking account, and $" + amountWithdrawnFromSavings + " from your savings account");
                      System.out.println("This includes overdraft and withdrawal fees");
                  }

              }

              else
                  System.out.println("Transaction Cancelled.");
              

          }

      }

      else
      {
          System.out.println("Card is not active.");
      }

  }

  public void makePay(double price) {

      if (isdebitActive == true){

          if ((CardAccountBalance - (price + debitTransactionFee)) >= 0)
          {
              CardAccountBalance -= price;
              CardAccountBalance -= debitTransactionFee;

          }
          else
          {
              System.out.println("Card Declined.");

          }

      }

      else
      {
          System.out.println("Card is not active.");
      }


  }

  public void setBalance(double Balance)
  {
      CardAccountBalance = Balance;
  }

  public double getBalance()
  {
      return CardAccountBalance; //returns the remaining balance of the account
  }*/
}
