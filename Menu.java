package mainTest;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Menu 
{
	String user;
	String pass;
	public static customer client;
	public static ArrayList<Object> objects = new ArrayList<Object>();
    Menu(customer clientSide) {
        client = clientSide;
    }

	public void menu () 
	{
	while(true) 
	{
	    System.out.println("Please select what you would like to do with W Bank today:\n");
	    System.out.println("(1) Access/Open Savings Account");      //works//
	    System.out.println("(2) Access/Open Checking Account");   //works//
	    System.out.println("(3) Access/Open Student/College Loan");  //works//
	    System.out.println("(4) Access/Open Mortgage Loan");    //works//
	    System.out.println("(5) Access/Open Business/Commercial Loan");  //errors//
	    System.out.println("(6) Access/Open Safe Deposit Box");   //works//
	    System.out.println("(7) Access/Open Certificate of Deposit");    //works//
	    System.out.println("(8) Access/Open Money Market Account"); //works//
	    System.out.println("(9) Access ATM machine");  //errors//
	    System.out.println("(10) Access Electronic Transfers");  //errors//
	    System.out.println("(11) Access/Open Home Equity Loan");    //works//
	    System.out.println("(12) Access/Open Personal Loan");   //works//
	    System.out.println("(13) Access Bank Locations");     //works//
	    System.out.println("(14) Access/Open Debit Card");    //works//
	    System.out.println("(15) Access/Open Credit Card");  //errors//
	    System.out.println("(16) Access Foreign Exchange");  //works//
	    System.out.println("(17) Access Bonds");    //NO CLASS//
	    System.out.println("(18) Access Annuities");   //works//
	    System.out.println("(19) Access Insurance Products");  //NO CLASS//
	    System.out.println("(20) Access Car Loans");
	    System.out.println("(21) Exit");
	
	
	    Scanner Customer = new Scanner(System.in);
	    int menu = Customer.nextInt();
	    
	    if (menu == 1) 
	    {
	        Savings savings = new Savings();
	        savings = (Savings)FindObjects(savings);
	        if(savings == null) {
	        	savings = new Savings();
	        	client.addDebitAccountToAccountList(savings);
	        	objects.add(savings);
	        }  
	        savings.balanacedep();
	        
	    }
	    
	    if (menu == 2) 
	    {
	        CheckingAccount checking = new CheckingAccount(0);
	        checking = (CheckingAccount)FindObjects(checking);
	        if(checking == null) {
	        	checking = new CheckingAccount(0);
	        	client.addDebitAccountToAccountList(checking);
	        	objects.add(checking);
	        }   
	        checking.account();
	    }
	
	    
	    if (menu == 3) 
	    {
	        StudentLoan classObj = new StudentLoan(client);
	        classObj = (StudentLoan)FindObjects(classObj);
	        if(classObj == null) {
	        	classObj = new StudentLoan(client);
	        	objects.add(classObj);
	        }
	        classObj.studentLoanSchedule();
	    }
	
	    if (menu == 4) 
	    {
		    System.out.println("Please select what kind of mortgage you would like to take out:\n");
		    System.out.println("(1) Fixed Rate");
		    System.out.println("(2) Adjustable Rate");
		    Scanner mort = new Scanner(System.in);
		    int mort1 = mort.nextInt();
	        
	        if (mort1 == 1)
	        {
		        FixedRateMortgage mortgage = new FixedRateMortgage(client);
		        mortgage = (FixedRateMortgage)FindObjects(mortgage);
		        if(mortgage == null) {
		        	mortgage = new FixedRateMortgage(client);
		        	objects.add(mortgage);
		        }
		        mortgage.FixedMortgage();
	        }
	        if (mort1 == 2)
	        {
		        ARMortgage mortgage2 = new ARMortgage(client);
		        mortgage2 = (ARMortgage)FindObjects(mortgage2);
		        if(mortgage2 == null) {
		        	mortgage2 = new ARMortgage(client);
		        	objects.add(mortgage2);
		        }
		        mortgage2.ARMortgageCalc();
	        }
	    }
	    
	    if (menu == 5) 
	    {
	        CommercialLoan business = new CommercialLoan(client);   
	        business = (CommercialLoan)FindObjects(business);
	        if(business == null) {
	        	business = new CommercialLoan(client);
	        	objects.add(business);
	        }
	        business.Commercial();
	    }
	   
	    if (menu == 6) 
	    {
	    	boolean exitSFD = false;
	    	BankLocations locationB = new BankLocations();
	        System.out.println(locationB.getLocations());
	        String location = locationB.yourLocation();
	        
	        SafetyDepositBox safe = new SafetyDepositBox(location, client);
	        safe = (SafetyDepositBox)FindObjects(safe);
	        if(safe == null) {
	        	safe = new SafetyDepositBox(location, client);
	        	objects.add(safe);
	        }
	        safe.createNewBox();
	    	while(!exitSFD) {
			    System.out.println("Please select what you would like to do in your Safe Deposit Box:\n");
			    System.out.println("(1) Add Item");
			    System.out.println("(2) Remove Item");
			    System.out.println("(3) Replace");
			    System.out.println("(4) See Contents");
			    System.out.println("(5) Pay annual fee");
			    System.out.println("(6) Exit");
			    
			    Scanner six = new Scanner(System.in);
			    int six1 = six.nextInt();
	 
		             
		        if (six1 == 1)
		        { 
		        	System.out.println(safe.addItem());
		        }
		        if (six1 == 2)
		        {    
		        	System.out.println(safe.removeItem());
		        }
		        if (six1 == 3)
		        {  
		        	System.out.println(safe.replaceItem());
		        }
		        if (six1 == 4)
		        {  
		        	System.out.println(safe.getContents());
		        }
		        if (six1 == 5)
		        {  
		        	System.out.println(safe.PayAnnualRate());
		        }
		        if (six1 == 6)
		        {  
		        	exitSFD = true;
		        }
		    }
	    }
	
	     
	    if (menu == 7) 
	    {
	        Certificateofdeposit certificate = new Certificateofdeposit();
	        certificate = (Certificateofdeposit)FindObjects(certificate);
	        if(certificate == null) {
	        	certificate = new Certificateofdeposit();
	        	objects.add(certificate);
	        }
	        certificate.welcome();
	    }
	    
	    if (menu == 8)
	    {    
		    MoneyMarket money = new MoneyMarket();
		    money = (MoneyMarket)FindObjects(money);
	        if(money == null) {
	        	money = new MoneyMarket();
	        	objects.add(money);
	        }
		    boolean exitMMA = false;
		    while(!exitMMA) {
		    	System.out.println("Please select what you would like to do with the Money Market Account:\n");
			    System.out.println("(1) Show your Account Balance");
			    System.out.println("(2) Deposit Money");
			    System.out.println("(3) Make a Payment");
			    System.out.println("(4) Show your Interest Rate");
				System.out.println("(5) Calculate your new Balance after Interest");
				System.out.println("(6) Show your Transaction Count");
				System.out.println("(7) Reset your Transaction Count");
			    System.out.println("(8) Return to Main Selection");
		    	Scanner eight = new Scanner(System.in);
		    	int eig = eight.nextInt();
		    	if (eig == 1)
		        {
					//gets the money market account balance
			        money.getMoneyMarketBalance();
		        }
		    	if(eig == 2) {
					//
		    		System.out.println("Enter the Amount you're Depositing: ");
		    		int amount = eight.nextInt();
		    		money.Deposit(amount);
		    	}
		        if (eig == 3)
		        {
					//makes a payment
		        	System.out.println("Enter the Amount you're Spending: ");
		        	int amount = eight.nextInt();
			        money.makePay(amount);
		        }
		        if(eig == 4) {
					//gets the interest rate
					money.getMoneyMarketInterestRate();
		        }
		        if(eig == 5) {
					//calculates your new balance after interest
		        	money.calcInterest();
		        }
				if(eig == 6)
				{
					money.getTransactionCount();
				}
				if(eig == 7)
				{
					//resets the transaction count to 0
					money.newMonth();
				}
				if(eig == 8)
				{
					exitMMA = true;
				}
		    }
		    
	        
	        
	    }
	
	    
	    if (menu == 9) 
	    {
	    	BankLocations locationB = new BankLocations();
	        System.out.println(locationB.getLocations());
	        String location = locationB.yourLocation();
	        
	        ATM ATM1 = new ATM(location, false); 
	        ATM1 = (ATM)FindObjects(ATM1);
	        if(ATM1 == null) {
	        	ATM1 = new ATM(location, false);
	        	objects.add(ATM1);
	        }
	        boolean exitATM = false;
	        while(!exitATM) {
	        	System.out.println("(1) Deposit, (2) Withdraw, (3) Exit");
		        Scanner scanAtm = new Scanner(System.in);
		        int scanInt = scanAtm.nextInt();
		        if(scanInt == 1) {
		        	ATM1.depositMoney(client);
		        }
		        if(scanInt == 2) {
		        	ATM1.withdrawMoney(client);
		        }
		        if(scanInt == 3) {
		        	exitATM = true;
		        }
	        }
	        
	    }
	    
	    if (menu == 10) 
	    {
	    	ElectronicTransfer electronic = new ElectronicTransfer(client); 
	    	electronic = (ElectronicTransfer)FindObjects(electronic);
	        if(electronic == null) {
	        	electronic = new ElectronicTransfer(client);
	        	objects.add(electronic);
	        }
	    	electronic.transfer();
	    }
	    
	    if (menu == 11) 
	    {
	        HomeEquityLoan classObj = new HomeEquityLoan(client);
	        classObj = (HomeEquityLoan)FindObjects(classObj);
	        if(classObj == null) {
	        	classObj = new HomeEquityLoan(client);
	        	objects.add(classObj);
	        }
	        classObj.homeEquityLoanSchedule();
	    }
	    
	    if (menu == 12) 
	    {
	        PersonalLoan personal = new PersonalLoan(client);
	        personal = (PersonalLoan)FindObjects(personal);
	        if(personal == null) {
	        	personal = new PersonalLoan(client);
	        	objects.add(personal);
	        }
	        personal.Personal();  
	    }
	   
	    if (menu == 13) 
	    {
		    System.out.println("Please select what you would like to do with our bank   locations:\n");
		    System.out.println("(1) Show our current locations");
		    System.out.println("(2) Locate yourself");
		    Scanner thirteen = new Scanner(System.in);
		    BankLocations location = new BankLocations(); 
		    int three = thirteen.nextInt();
	        
	        if (three == 1)
	        {
	        	System.out.println(location.getLocations());
	        }
	        if (three == 2)
	        {
	        	System.out.println("your location is: " + location.yourLocation());
	        }
	     }
	
	     
	    if (menu == 14)
	    {
		    DebitCard card1 = new DebitCard(client);
		    card1 = (DebitCard)FindObjects(card1);
	        if(card1 == null) {
	        	card1 = new DebitCard(client);
	        	
	        	objects.add(card1);
	        }
		    card1.card();
	    }
	    
	    if (menu == 15) 
	    {
	        CreditCard credit = new CreditCard(client);   
	        credit = (CreditCard)FindObjects(credit);
	        if(credit == null) {
	        	credit = new CreditCard(client);
	        	objects.add(credit);
	        }
	        credit.getValues();
	    }
	    
	    if (menu == 16) 
	    {
	        ForeginExchange foreign = new ForeginExchange(); 
	        foreign = (ForeginExchange)FindObjects(foreign);
	        if(foreign == null) {
	        	foreign = new ForeginExchange();
	        	objects.add(foreign);
	        }
	        foreign.testMethod();
	    }
	    
	    if (menu == 17) 
	    {
	        Bonds bonds = new Bonds(client);  
	        bonds = (Bonds)FindObjects(bonds);
	        if(bonds == null) {
	        	bonds = new Bonds(client);
	        	objects.add(bonds);
	        }
	        bonds.bondUse();
	    }
	    
	   if (menu == 18) 
	    {
	        Annuities annuities1 = new Annuities(client); 
	        annuities1 = (Annuities)FindObjects(annuities1);
	        if(annuities1 == null) {
	        	annuities1 = new Annuities(client);
	        	objects.add(annuities1);
	        }
	        annuities1.testMethod();
	    }
	    
	    if (menu == 19) 
	    {
	        BankInsurance insurance = new BankInsurance(client);   
	        insurance = (BankInsurance)FindObjects(insurance);
	        if(insurance == null) {
	        	insurance = new BankInsurance(client);
	        	objects.add(insurance);
	        }
	        insurance.account();
	    }
	    if (menu == 20) {
	    	CarLoan loan = new CarLoan(client);
	    	loan = (CarLoan)FindObjects(loan);
	        if(loan == null) {
	        	loan = new CarLoan(client);
	        	objects.add(loan);
	        }
	    	loan.Car();
	    }
	    if (menu == 21)
	    {
	        System.out.println("\nThank you for visiting W Bank, we hope you come back soon! ");
	        break;
	    }	
	  }
   }
    public Object FindObjects(Object object) {
    	Scanner scan = new Scanner(System.in);
    	int option = 0;
    	for(int i = 0; i < objects.size(); i++) {
    		if(objects.get(i).getClass().equals(object.getClass())) {
    			System.out.println("Would you like to access a (1) pre-existing instance of this feature or (2) create a new one?");
    			option = scan.nextInt();
    			break;
    		} else if(i == objects.size()-1) {
    			return null;
    		}
    	}
    	
    	if(option == 1) {
    		int objCounter = 1;
    		ArrayList<Object> sameObjects = new ArrayList<Object>();
	    	for(Object objs : objects) {
	    		if(objs.getClass().equals(object.getClass())) {
	    			System.out.println("(" + objCounter + ")" + "instance number "  + objCounter);
	    			sameObjects.add(objs);
	    			objCounter++;
	    		}
	    		if(objects.indexOf(objs) == objects.size()-1) {
	    			int objChoice = scan.nextInt();
	    			return sameObjects.get(objChoice-1);
	    		}
	    	}
    	}
    	if(option == 2) {
    		return null;
    	}
    	return null;
    }

}
 
