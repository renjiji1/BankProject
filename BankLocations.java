package mainTest;

import java.util.Scanner;

class BankLocations 
{
    private String[] locations;
    
    public BankLocations()  
    { 
      this.locations = new String[]{"Houston TX", "Old Bridge NJ", "New York City New York", "Dallas TX", 
      "Los Angeles CA", "Chicago IL", "Phoenix AZ", "Philadelphia PA", 
      "San Diego CA", "Newark NJ", "Fort Payne AL", "Brea CA"};
    } 
    
    public String getLocations()  
    { 
      String location = "";
      for(String local : locations) {
    	  location += local + ", ";
      }
      return "These are our current locations, " + location; 
    }
    
    public String yourLocation()
    {
      Scanner scanner1 = new Scanner(System.in);
      System.out.print("Where are you located? (Case Sensitive): ");
      String where = scanner1.nextLine();
      for(String location : locations)
      {
    	if(location.equals(where)) {
    		return where;
    	}
        
      }
      return "Not a location";
    }
}

