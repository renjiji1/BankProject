//Foreign Exchange
//Tvisha Chandupatla & Samhita Pokkunuri
//Period 1B


import java.util.Scanner;

class ForeginExchange {


    public void testMethod()
    {

        System.out.println("Currencies Avaliable: ");

        String[] currencyPrint = {"United States Dollar (USD)", "Euro (EUR)", "British Pound Sterling (GBP)", "Canadian Dollar (CAD)", "Japanese Yen (JPY)"};



        String[] currencies = {"USD", "EUR", "GBP", "CAD", "JPY"};

        for (int i = 0; i < currencyPrint.length; i++)
        {
            System.out.println(currencyPrint[i]);
        }

        System.out.println();


        Scanner currencyScanner = new Scanner(System.in);
        System.out.print("Please enter the currency you would like to convert from: ");
        String deposit = currencyScanner.nextLine();

        int checker = 1;
        while (checker == 1) {
            for (int i = 0; i < currencies.length; i++) {
                if (deposit.equalsIgnoreCase(currencies[i])) {
                    checker = 0;
                    break;
                }
            }
            if (checker == 1) {
                System.out.print("That was an invalid input. Please try again: ");
                deposit = currencyScanner.nextLine();
            }
        }

        checker = 1; // reset counter

        System.out.print("Please enter the currency you would like to convert to: ");
        String withdraw = currencyScanner.nextLine();
        while (checker == 1) {
            for (int i = 0; i < currencies.length; i++) {
                if (withdraw.equalsIgnoreCase(currencies[i])) {
                    checker = 0;
                    break;
                }
            }
            if (checker == 1) {
                System.out.print("That was an invalid input. Please try again: ");
                withdraw = currencyScanner.nextLine();
            }
        }

        System.out.println();

        System.out.print("Please enter the deposit: ");
        double depositedAmount = currencyScanner.nextDouble();

		CheckingAccount checkingAccount = new CheckingAccount(0);
		checkingAccount.Withdraw(depositedAmount);

        ConversionCalculator(depositedAmount, deposit, withdraw);

        System.out.println("Have a nice day!");
    }

    public static void ConversionCalculator(double deposit, String currencyGiven, String currencyOutputted)
    {
        double conversion = 0.0;
        //USD to ___
        if (currencyGiven.equalsIgnoreCase("USD") && currencyOutputted.equalsIgnoreCase("EUR"))
        {
            conversion = deposit * 0.94297568;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("USD") && currencyOutputted.equalsIgnoreCase("GBP"))
        {
            conversion = deposit * 0.8437075;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("USD") && currencyOutputted.equalsIgnoreCase("CAD"))
        {
            conversion = deposit * 1.3646958;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("USD") && currencyOutputted.equalsIgnoreCase("JPY"))
        {
            conversion = deposit * 134.56663;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("GBP") && currencyOutputted.equalsIgnoreCase("USD"))
        {
            conversion = deposit * 1.2198573;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("GBP") && currencyOutputted.equalsIgnoreCase("EUR"))
        {
            conversion = deposit * 1.1274026;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("GBP") && currencyOutputted.equalsIgnoreCase("CAD"))
        {
            conversion = deposit * 1.635112;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("GBP") && currencyOutputted.equalsIgnoreCase("JPY"))
        {
            conversion = deposit * 156.80483;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("CAD") && currencyOutputted.equalsIgnoreCase("USD"))
        {
            conversion = deposit * 0.74605114;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("CAD") && currencyOutputted.equalsIgnoreCase("EUR"))
        {
            conversion = deposit * 0.68951164;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("CAD") && currencyOutputted.equalsIgnoreCase("GBP"))
        {
            conversion = deposit * 0.61158676;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("CAD") && currencyOutputted.equalsIgnoreCase("JPY"))
        {
            conversion = deposit * 95.894674;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("JPY") && currencyOutputted.equalsIgnoreCase("USD"))
        {
            conversion = deposit * 0.0077674096;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("JPY") && currencyOutputted.equalsIgnoreCase("EUR"))
        {
            conversion = deposit * 0.0071803405;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("JPY") && currencyOutputted.equalsIgnoreCase("GBP"))
        {
            conversion = deposit * 0.006359134;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("JPY") && currencyOutputted.equalsIgnoreCase("CAD"))
        {
            conversion = deposit * 0.010427142;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("EUR") && currencyOutputted.equalsIgnoreCase("USD"))
        {
            conversion = deposit * 1.0670716;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("EUR") && currencyOutputted.equalsIgnoreCase("GBP"))
        {
            conversion = deposit * 0.88559627;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("EUR") && currencyOutputted.equalsIgnoreCase("CAD"))
        {
            conversion = deposit * 1.452122;
            System.out.println("$" + String.format("%.2f", conversion));
        }

        if (currencyGiven.equalsIgnoreCase("EUR") && currencyOutputted.equalsIgnoreCase("JPY"))
        {
            conversion = deposit * 139.26366;
            System.out.println("$" + String.format("%.2f", conversion));
        }


    }
}