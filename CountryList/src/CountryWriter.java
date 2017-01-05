
public interface CountryWriter {
	boolean addCountry(Country diffCountry);
    boolean updateCountry(Country changedCountry);
    boolean deleteCountry(Country goneCountry);

}
