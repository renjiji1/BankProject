package mainTest;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;

class FixedRateMortgage {
    private int loan;
    private int p;
    private double i;
    private int n;
    private double payment;
    customer client;
    
    public FixedRateMortgage(customer cust) {
        this.loan = loan;
        this.p = p;
        this.i = i;
        this.n = n;
        this.payment = payment;
        client = cust;
    }
    
    public String FixedMortgage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want a fixed rate loan of 10, 15, or 30 years?");
        this.loan = scanner.nextInt();

        if (this.loan == 10 || this.loan == 15 || this.loan == 30) 
        {
            System.out.println("What is the Price of the Home? ");
            this.p = scanner.nextInt();
            if (this.loan == 10)
                this.i = 6.5;
            else if (this.loan == 15)
                this.i = 6.2;
            else if (this.loan == 30)
                this.i = 5.4;
            this.i = this.i / 100;
            this.n = 12 * loan;
            this.payment = ((this.p * this.i +this.p)/12)/5;
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            return "Your monthly pay is: " + formatter.format(this.payment);
        }
        else 
        {
            System.out.println("Please choose 10, 15 or 30 years.");
            this.loan = scanner.nextInt();
        }
        return null;
    }
}


