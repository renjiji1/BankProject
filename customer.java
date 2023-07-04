package mainTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Scanner;


// Gerard Hill, Kelvin Molina, Arthur Tadevosyan



public class customer
{
    // Keyboard for use of console input
    Scanner keyboard = new Scanner(System.in);

    // Variables for the class
    private String f_name;
    private String l_name;
    private String full_name;
    private String dateOfBirth;
    private String SSN;
    private int age;
    

    private String userName;
    private String password;

    private DebitCard custDebitCard;


    
    
    // Hashmap (like a dictionary) that is storing a list of all the customers across the customer class 
    // with the key being username+password and the value being the specific customers list of creditCards
    
    
    

    private ArrayList<Object> customerDebitAccounts = new ArrayList<Object>();

    private ArrayList<CreditCard> customersCreditCards = new ArrayList<CreditCard>();
    

    


    // Base Constructor
    public customer()
    {
        
        f_name = "John";
        l_name = "Doe";
        userName = "JohnDoe975";
        password = "NIL";
        SSN = "000-000-0000";
        full_name = f_name + l_name;
    }

    // Parameterized COnstructor to intialize variables
    public customer(String fname, String lname,String s, String DOB, int a, ArrayList<CreditCard> ccc,DebitCard cdc, String uName, String pWord)
    {
       
        // Makes sure the name contains no special characters
        boolean goodName = checkNames(fname + lname);
        if (goodName)
        {
            f_name = fname;
            l_name = lname;
            full_name = f_name + l_name;
        }
        else
        {
            System.out.println("You have entered invalid characters, please use the set method to change the names.");
        }
        SSN = s;
        dateOfBirth = DOB;
        age = a;
        customersCreditCards = ccc;
        custDebitCard = cdc;
        userName = uName;
        password = pWord;
        
        
        

        
        
    }

    // Sets all the variables based on a menu
    public void menu()
    {
        System.out.println("Welcome to W Bank");
        System.out.println("Would you like to create an account, please type 1 to continue and 2 to exit");

        int z = keyboard.nextInt();
        if (z == 1)
        {
            System.out.println("Please be prepared to give your information to us");

            setName(); // Just uses another method already being used

            System.out.println("Please type your DOB");
            String dobTemp = keyboard.next();
            dateOfBirth = dobTemp;

            System.out.println("Please type your age");
            int a = keyboard.nextInt();
            age = a;

            System.out.println("Please enter your information for the username and password");
            setUserNameOrPassword();
            setUserNameOrPassword();

            



        }
        else if (z == 2)
        {
            return;
        }


    }

    public void printSomething()
    {
        System.out.println("Here you go" + customerDebitAccounts);
    }
    
    

    
    

    // Assigns the customers credit cards to the dict everytime a customer is made
    

    public ArrayList<Object> getAccounts()
    {
        return customerDebitAccounts;
    }

    public ArrayList<CheckingAccount> getCheckingAccounts()
    {
        ArrayList<CheckingAccount> returnThis = new ArrayList<CheckingAccount>();
        for(int i = 0; i < customerDebitAccounts.size();i++)
        {
            if (customerDebitAccounts.get(i).getClass().equals(CheckingAccount.class));
            {
                returnThis.add((CheckingAccount) customerDebitAccounts.get(i));
            }
        }
        return returnThis;
    }

    public ArrayList<Savings> getSavingAccounts()
    {
        ArrayList<Savings> returnThis = new ArrayList<Savings>();
        for(int i = 0; i < customerDebitAccounts.size();i++)
        {
            if (customerDebitAccounts.get(i).getClass().equals(Savings.class));
            {
                returnThis.add((Savings) customerDebitAccounts.get(i));
            }
        }
        return returnThis;
    }

    public ArrayList<MoneyMarket> getMoneyMarketAccounts()
    {
        ArrayList<MoneyMarket> returnThis = new ArrayList<MoneyMarket>();
        for(int i = 0; i < customerDebitAccounts.size();i++)
        {
            if (customerDebitAccounts.get(i).getClass().equals(MoneyMarket.class));
            {
                returnThis.add((MoneyMarket) customerDebitAccounts.get(i));
            }
        }
        return returnThis;

    }




    

    // Just prints the class-wide dict
    

    public void properlyPrintArrayList(ArrayList a)
    {
        System.out.println(a.size());
        for(int i  = 0; i < a.size();i++)
        {
            System.out.println("This is " + a.get(i).toString());
        }
    }

    // Simple get and set methods
    public void setAge(int a)
    {
        age = a;
    }

    public int getAge()
    {
        return age;
    }

    public String getSSN()
    {
        return SSN;
    }

    public void setSSN(String ssnc)
    {
        SSN = ssnc;
    }

    // Sets name and makes sure that it is not invalid
    public void setName()
    {
        Character[] specialChars = {'!','@','#','$','%','^','&','*','(',')'};

        boolean nameIsGood = true;

        System.out.println("Please type your first name");
        String tempFirstName = keyboard.next();
        System.out.println("Please type your last name");
        String tempLastName = keyboard.next();

        

        String tempFullName = tempFirstName + tempLastName;

        for (int i = 0; i < tempFullName.length();i++)
        {
            for (int j = 0; j < specialChars.length;j++)
            {
                if (tempFullName.charAt(i) == specialChars[j])
                {
                    nameIsGood = false;

                    break;
                }
            }
        }
        if (nameIsGood) 
        {
            f_name = tempFirstName;
            l_name = tempLastName;
            full_name = tempFullName;
        }
        else
        {
            // Recursive method to just recall the method if the user has entered an invalid name
            System.out.println("You have inputted invalid characters");
            setName();
        }
        
    }
    // Check name method for paramterized constructor
    private boolean checkNames(String tempFullName)
    {
        Character[] specialChars = {'!','@','#','$','%','^','&','*','(',')'};

        boolean nameIsGood = true;

        for (int i = 0; i < tempFullName.length();i++)
        {
            for (int j = 0; j < specialChars.length;j++)
            {
                if (tempFullName.charAt(i) == specialChars[j])
                {
                    nameIsGood = false;
                    return false;
                }
            }
       }
       if (nameIsGood)
       {
        return true;
       }
       else
       {
        return false;
       }
       
       
       
            
    }

    // Method to get either the first last or full name
    public String getNames()
    {
        int input = 0;


        System.out.println("Please type 1 to return your first name, 2 to return your last name, and 3 to return your full name.");
        try {
            input = keyboard.nextInt();
        } catch (Exception e) {
            System.out.println("Please only type in 1, 2, or 3.");
            getNames();
        }

        if(input == 1)
        {
            return f_name;
        }
        else if (input == 2)
        {
            return l_name;
        }
        else if (input == 3)
        {
            return full_name;
        }
        else 
        {
            System.out.println("None of your input values were correct so we have just given you the full_name.");
            return full_name;
        }


    }

    // More simple set/Get methods for dob
    public void setDOB(String dob)
    {
        dateOfBirth = dob;
    }

    public String getDOB()
    {
        return dateOfBirth;
    }

    // These methods both add a credit to the specified customer-specific array list
    public void addCreditCardToList(CreditCard card)
    {
        customersCreditCards.add(card);
    }

    // Adds the account to the account list
    public void addDebitAccountToAccountList(Object AC)
    {
        customerDebitAccounts.add(AC);
    }
    
    

    // Get the customers credit cards
    public ArrayList<CreditCard> getCCs()
    {
        System.out.println("Please type out your SSN to access your Credit Cards");
        int pword = keyboard.nextInt();
        
        if (pword == Integer.parseInt(SSN))
        {
            System.out.println("Here is a list of the credit cards");
            return customersCreditCards;
            
        }
        else
        {
            System.out.println("You were wrong");
            ArrayList<CreditCard> fakeList = new ArrayList<CreditCard>();
            return fakeList;
        }
    }

    // Gets the debit cards value
    /*public double returnDebitCardAccountValue()
    {
        return custDebitCard.getBalance();
    }*/

   

    

    // Sets the username or password
    public void setUserNameOrPassword()
    {
        Character[] specialChars = {'!','@','#','$','%','^','&','*','(',')'};
       int specialCounter = 0; 

        System.out.print("Please type 1 if you want to set the password and 2 to set the username");
        int num = keyboard.nextInt();


        System.out.println("Please type your full name as one word for security reasons");
        String givenName = keyboard.next();
        if (givenName.equalsIgnoreCase(full_name))
        {
            if (num == 1)
            {
                System.out.println("Please type the new password you want and use special characters");
                String newPword = keyboard.next();
                for(int i = 0; i < newPword.length(); i++)
                {
                    for(int j = 0; j < specialChars.length;j++)
                    {
                        if(newPword.charAt(i) == specialChars[j])
                        {
                            specialCounter +=1;
                        }
                    }
                }
                if(specialCounter >= 1)
                {
                    password = newPword;
                }
                else
                {
                    System.out.println("You need to learn how to use special characters and be secure");
                    setUserNameOrPassword();
                }

                
            }
            else
            {
                System.out.println("Please type the username you want");
                String newUname = keyboard.next();
                userName = newUname;
            }
        }
    }

    // Gets the username or password
    public String getUsername()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }
}