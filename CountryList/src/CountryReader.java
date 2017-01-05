import java.util.ArrayList;

public interface CountryReader {
	
	Country getCountry(String countryName);
    ArrayList<Country> getCountries();

}
