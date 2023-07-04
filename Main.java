package mainTest;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mainTest.customer;
import mainTest.Menu;


public class Main {
    String fname;
String lname;
String age;
String SSN;
String DOB;
static String username;

static String password;

    public static ArrayList<customer> customers = new ArrayList<customer>();
    public static String location;
    
    public static void main(String args[]) throws IOException {
        System.out.println("Welcome to the W Bank, brought to you by Coconut Ink");
        int multiplier = 1;
        int left = 9;
        int right = 10;
        for(int i = 0; i < 19; i++) {
            
            for(int a = 0; a < 20; a++) {
                if(a == left || a == right) {
                    System.out.print("$");
                } else {
                    System.out.print(" ");
                }
                
            }
            if(left == 0 || right == 19) {
                multiplier *= -1;
            }
            left -= multiplier;
            right += multiplier;
            
            System.out.println();
            
        }
        
        Menu menu = new Menu(account());
        menu.menu();
    }
    
    public static customer account() {
        customer newAccount = new customer();
        newAccount.menu();
        customers.add(newAccount);
        return newAccount;
    }
    /*private static void loginMenu() {
        while(login != 1 && login != 2) {
            System.out.println("(1) Make a new account with W Bank, (2) Login");
            Scanner loginScan = new Scanner(System.in);
            login = loginScan.nextInt();
        }
    } */
 // Method to write the information to CSV file
    
}
