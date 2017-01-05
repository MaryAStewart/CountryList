
public class DAOFactory {
	public static CountryDAO getCountryDAO()
    {
        CountryDAO cDAO = new CountryTextFile();
        return cDAO;
    }
}
