 


import java.util.Scanner;
import java.util.ArrayList;
/**@author Mary A. Stewart
 * the CountriesApp runs the program.
 * This program is about maintaining a list of countries 
 * from a .txt file.
 * */

public class CountriesApp {
	// declare class variables  
	private static CountryDAO countryDAO = null;
	private static Scanner keyboard = null;
/** this is the main method that welcomes the user to the application
 * and displays list of commands
 * 
 * @param args 
 */
	public static void main(String[] args) {
		
		// display a welcome message 
		System.out.println("Welcome to the Countries Welcome Application");
		// set the class variables 
        countryDAO = DAOFactory.getCountryDAO();        
        keyboard = new Scanner(System.in);
        
     // display the command menu 
        displayMenu();
        
     // perform 1 or more actions 
       int choice = 0;
        while (choice!=4)
        {
            // get the input from the user 
            choice = Validator.getInt(keyboard,"Enter menu number", 0, 5);
            System.out.println();
            if (choice==1)
                displayAllCountries();
            else if (choice==2)
                addCountry();
            else if (choice==3)
                deleteCountry();           
            else if (choice==4)
                System.out.println("Bye.\n");           
        }       
                
        
	}
        public static void displayMenu()
        {
            System.out.println("COMMAND MENU");
            System.out.println("1  - List all countries");
            System.out.println("2  - Add a country");
            System.out.println("3  - Delete a country");            
            System.out.println("4  - Exit\n");
        }
        public static void displayAllCountries()
        {
            System.out.println("Country LIST");

            ArrayList<Country> countries = countryDAO.getCountries();
            Country listCountry = null;
            StringBuilder myStringBuilder = new StringBuilder();
            for (int i = 0; i < countries.size(); i++)
            {
                listCountry = countries.get(i);                
                myStringBuilder.append(listCountry.getCountryName());
                myStringBuilder.append("\n");
            }
            System.out.println(myStringBuilder.toString());
        }
        public static void addCountry()
        {
            String countryName = Validator.getString(
                    keyboard, "Enter country name: ");
          
            Country diffCountry = new Country();
            diffCountry.setCountryName(countryName);
                   
            countryDAO.addCountry(diffCountry);

            System.out.println();
            System.out.println(countryName + " " 
                    + " has been added.\n");
        }
        public static void deleteCountry()
        {
            String countryName = Validator.getString(keyboard,
                    "Enter country to delete: ");

            Country goneCountry = countryDAO.getCountry(countryName);

            System.out.println();
            if (goneCountry != null)
            {
                countryDAO.deleteCountry(goneCountry);
                System.out.println(goneCountry.getCountryName()
                + " has been deleted.\n");
            }
            else
            {
                System.out.println("No country matches that country name.\n");
            }
        }

		
		


}
