package mainTest;

import java.util.Scanner;


public class Certificateofdeposit {
	   
   private static String type;
    private static double balance;
  
   private static int years;
   
    private static double InterestRate;
    private static Scanner input = new Scanner(System.in);
  
 public  Certificateofdeposit()
    {
        String type="";
        double balance = 0;
        double InterestRate = 0;
        
       
        int years= 0;
    }
    // constructor
    public Certificateofdeposit(String type, double balance,int years, double interestrate ) {
        type=type;
        balance = balance;
    
        
        years=years;
       
        InterestRate = interestrate;
        
      
    }

    // getters and setters
  public String gettype() {
        return type;
    }

    public void settype(String type) {
        type = type;
    }

    public double getbalance() {
        return balance;
    }

    public void setBalance(double balance) {
        balance = balance;
    }


 public int getyears() {
        return years;
    }

    public void setBalance(int years) {
        years = years;
    }
   public double getInterestRate() {
        return InterestRate;

    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }

    

    public  void welcome() {
    	if (years==3 && (type=="m" || type=="M")){
            balance=balance*(1+0.0225);
        }
          if (years==6 && (type=="m" || type=="M")){
            balance=balance*(1+0.039);
        }
        if (years==1 ){
            balance=balance*(1+0.043);
        }
        if (years==3 && (type=="y" || type=="Y")){
            balance=balance*(1+0.043);
        }
        if (years==6 && (type=="y" || type=="Y")){
            balance=balance*(1+0.043);
        }
       
      
         double balance1=0;
         int year=0;
         double withdraw=0;
        System.out.println("Welcome to Cerificate of Deposit");
        System.out.println("Do you want to deposit? 1 for yes , 2 for no");
        int option = input.nextInt();
        
        if( option == 1 ){
            System.out.println("Enter the amount you would like to deposit: ");
            double deposit = input.nextDouble();
             System.out.println("1)  3months, 2) 6months, 3)  1 year, 4)  3 years 5)  6years  choose an option from 1 to 5  ");
                year = input.nextInt();
            balance1 =balance1+ deposit+balance;
            System.out.println("Your new balance is: " + balance1);
        }
       
         if (year==1){
             
            balance1=balance1*(1+0.0225);
            System.out.println("Your new balance after 3months is: " + balance1);
        }
          if (year==2 ){
            balance1=balance1*(1+0.039);
            System.out.println("Your new balance after 6months is: " + balance1);
        }
        if (year==3 ){
            balance1=balance1*(1+0.043);
            System.out.println("Your new balance after 1 year is: " + balance1);
        }
        if (year==4 ){
            balance1=balance1*(1+0.043);
            System.out.println("Your new balance after 3 years is: " + balance1);
        }
        if (year==5 ){
            balance1=balance1*(1+0.043);
            System.out.println("Your new balance after 6 years is: " + balance1);
        }
        
        
         System.out.println("Do you want to withdraw? 1 for yes , 2 for no");
        int get = input.nextInt();
        
         if( get == 1 ){
           System.out.println("Enter the amount you would like to withdraw: ");
             withdraw = input.nextDouble();
            

        }
        if(get==2){
            System.out.println("Have a good day");
        }
      if((balance1+balance- withdraw)<0){
            System.out.println("cannot do the withdraw your withdraw is more than your balance");
        }
        if((balance1+balance- withdraw)>0){
            balance1 =balance1+balance- withdraw;
            System.out.println("Your new balance is: " + balance1);
            System.out.println("Have a good day");
        }
}
}
