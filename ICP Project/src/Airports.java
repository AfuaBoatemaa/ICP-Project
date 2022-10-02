/**
 * @author Afua Boatemaa Amankwaah
 */

public class Airports {
    /**
     * Instance Variables
     */
    private String AirportID;
    private String AirportName;
    private String City;
    private String Country;
    private String IATACode;

    /**
     * CONSTRUCTOR
     *
     * @param AirportID
     * @param AirportName
     * @param City
     * @param Country
     * @param IATACode
     */
    public Airports(String AirportID, String AirportName, String City, String Country, String IATACode) {
        this.AirportID = AirportID;
        this.AirportName = AirportName;
        this.City = City;
        this.Country = Country;
        this.IATACode = IATACode;

    }

    public String getAirportID() {
        return AirportID;
    }

    public void setAirportID(String airportID) {
        AirportID = airportID;
    }

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }
}






