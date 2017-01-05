import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**CountryTextFile implements CountryDAO which extends CountryWriter
 * and CountryReader
 * @author Mary A. Stewart
 * 
 *
 */
public class CountryTextFile implements CountryDAO {
	
	private ArrayList<Country> countries = null;
	
    private Path countriesPath = null;
    private File countriesFile = null;
	
    public CountryTextFile ()
    {
    	countriesPath = Paths.get("countrieslist.txt");
    	countriesFile = countriesPath.toFile();
    	countries = this.getCountries();
    	
    }
	
	public ArrayList<Country> getCountries(){
		if (countries != null)
            return countries;        

        countries = new ArrayList<>(); 
        if (Files.exists(countriesPath)){
        	try(BufferedReader in = new BufferedReader(        							
        							new FileReader(countriesFile)))
        	{        		
        		// load the array list with Country objects created from
        		// the data in the file
        		
        		String line = in.readLine();
        		while (line !=null)
        		{
        			       			
        			Country country = new Country();
        			country.setCountryName(line);
        			countries.add(country);
        			
        			line = in.readLine();
        		}
        	}
        	catch (IOException e)
        	{
        		System.out.println(e);
        		return null;
        	}
        }        

        return countries;            
    }
	 public Country getCountry(String countryName)
	    {
	        for (Country theCountry : countries)
	        {
	            if (theCountry.getCountryName().equals(countryName))
	                return theCountry;
	        }
	        return null;
	    }
	 public boolean addCountry(Country diffCountry)
	    {
	        countries.add(diffCountry);
	        return this.saveCountry();
	    }

	    public boolean deleteCountry(Country goneCountry)
	    {
	        countries.remove(goneCountry);
	        return this.saveCountry();
	    }
	   
	    public boolean updateCountry(Country changedCountry)
	    {
	        // get the old country and remove it
	        Country oldCountry = this.getCountry(changedCountry.getCountryName());
	        int i = countries.indexOf(oldCountry);
	        countries.remove(i);

	        // add the updated country
	        countries.add(i, changedCountry);

	        return this.saveCountry();
	    }
	    private boolean saveCountry()   
	    {   
	    	try (PrintWriter out = new PrintWriter(
	    			               new BufferedWriter(
	    			               new FileWriter(countriesFile))))
	    	{
	    		// save the Country objects in the array list to the file
	    		for (Country savedCountry : countries)
	    		{
	    			out.println(savedCountry.getCountryName());
	    			
	    		}
	    		
	    	}
	    	catch (IOException e){
	    		System.out.println(e);
	    		return false;
	    	}
	        
	        return true;
	    }
		
}


