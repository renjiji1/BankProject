package mainTest;

class MoneyMarket extends Savings
{   //private variables

    private int MaxTransactions; //max transactions per month
    private double MoneyMarketBalance;
    private double MoneyMarketInterestRate;
    private String MoneyMarketAccountNumber;



    //all the capitalized variables are private

    int TransactionCounter = 0; //used to count the number of transactions made that month

    double MinimumBalance = 1000; //sets the minimum balance for the account to be active

    public MoneyMarket() //default constructor
    {
        //MoneyMarketAccountNumber = getAccountNumber();
        MoneyMarketBalance = 0;
        MoneyMarketInterestRate = 3;
        MaxTransactions = 6;


    }

    public MoneyMarket(String accountnumber, String holdername, double interestrate, int maxtransactions, double balance) //all of the lowercase variables are paramaters
    {


        MoneyMarketAccountNumber = accountnumber;
        MoneyMarketInterestRate = interestrate;
        MaxTransactions = maxtransactions;
        MoneyMarketBalance = balance;
        


    }

    //get and set methods below



    public void setMaxTransactions(int maxtransactions)
    {
        MaxTransactions = maxtransactions;
    }

    public int getMaxTransactions()
    {
        return MaxTransactions;
    }

    public String getAccountNumber() {
        return MoneyMarketAccountNumber;
    }
    
    public void setMoneyMarketInterestRate(double interestRate){
        MoneyMarketInterestRate = MoneyMarketInterestRate; 
    }
    
    public double getMoneyMarketInterestRate()
    {
        System.out.println("This Money Market account's interest rate is " + MoneyMarketInterestRate + "%.");
        return MoneyMarketInterestRate;
        
    }

    //other methods
    

    public void Deposit(double amount) {
        MoneyMarketBalance += amount;
        System.out.println("Your balance is now $" + MoneyMarketBalance);
    }

    public void makePay(double price)
    {
            if (TransactionCounter < 6)
            {


                if ((MoneyMarketBalance - price < MinimumBalance))
                {
                    System.out.println("Insufficient Funds - Your Balance would be $" + (MoneyMarketBalance - price) + ". Your account minimum is $1000.");
                }
                else
                {
                    MoneyMarketBalance -= price;
                    TransactionCounter++;
                    System.out.println("successfully transferred funds");
                    System.out.println("Your current balance is $" + MoneyMarketBalance);
                    System.out.println("You have " + (6-TransactionCounter) + " transactions left for this month");
                }
            }
            else
            {
                System.out.println("Account has reached the max of 6 transactions this month.");
            }
        
        
    }
    
    public void newMonth() {
        TransactionCounter = 0;
        System.out.println("First of the month! Your transaction counter has reset to " + TransactionCounter + "!");
    }

    public void calcInterest() {
        MoneyMarketBalance = (1 + MoneyMarketInterestRate/100)*MoneyMarketBalance;
        System.out.println("After interest, your balance is " + MoneyMarketBalance);
    }

    public double getMoneyMarketBalance()
    {
        System.out.println("Your balance is $" + MoneyMarketBalance);
        return MoneyMarketBalance;
    }
    
    public int getTransactionCount()
    {
        System.out.println("This account has " + TransactionCounter + " transactions this month (MAX 6).");
        return TransactionCounter;
    }
    
}
