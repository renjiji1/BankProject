package mainTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ElectronicTransfer {
    private CheckingAccount sourceAccount;
    private String destinationAccount;
    private float amount;
    private Date transferDate;
    private final float transferLimit = 3000.0f;
    private Scanner scanner = new Scanner(System.in);
    private List<ElectronicTransfer> transactions = new ArrayList<>();
    private String accountNum = "No Account";
    customer client;

    public ElectronicTransfer(customer cust) {
        client = cust;
    }

    public CheckingAccount getSourceAccount() {
        return sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public float getAmount() {
        return amount;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void initiateTransfer() {
        System.out.println("Enter transfer amount (Cannot exceed $3000): ");
        amount = Float.parseFloat(scanner.nextLine());
        if (amount <= transferLimit) {
            Scanner menu3 = new Scanner(System.in);
            System.out.print("(1) Confirm transaction // (2) Decline transaction: ");
            int selection3 = menu3.nextInt();
            if (selection3 == 1) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Which account would you like to use? ");
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
                    if(account.Withdraw(amount)) {
                        accountNum = account.GetAccountNumber();
                        transferDate = new Date();
                        transactions.add(this);
                    } else {
                    	System.out.println("Insufficient balance in source account.");
                    }
                } else {
                	Savings account = (Savings)client.getAccounts().get(option);
                    if(account.withdrawn(amount)) {
                    	accountNum = account.getAccountNumber();
                    	 transferDate = new Date();
                         transactions.add(this);
                    } else {
                    	System.out.println("Insufficient balance in source account.");
                    }
                }
            }
        } else {
            System.out.println("Transfer amount exceeds limit of $" + transferLimit + ".");
        }
    }

    public void displayTransactions() {
        System.out.println("Transactions:");
        for (ElectronicTransfer transfer : transactions) {
            System.out.println("From: " + accountNum);
            System.out.println("To: " + transfer.getDestinationAccount());
            System.out.println("Amount: $" + transfer.getAmount());
            System.out.println("Date: " + transfer.getTransferDate());
        }
    }

    public void transfer() {
        ElectronicTransfer electronicTransfer = new ElectronicTransfer(client);
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        while (!quit) {
            System.out.println("(1) Make a transfer, (2) Display transaction, or (3) Return to menu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                electronicTransfer.initiateTransfer();
            } else if (choice == 2) {
                electronicTransfer.displayTransactions();
            } else if (choice == 3) {
                quit = true;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}