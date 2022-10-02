/**
 * @author Afua Boatemaa Amankwaah
 */

public class Routes {
    /**
     * Instance Variables
     */

    // Airline code, Airline ID, Source airport code, Source airport ID, Destination airport code
    private static String AirlineCode;
    private static String SourceAirportCode;
    private static String SourceAirportID;
    private static String DestinationAirportCode;
    private int Stops;


    /**
     * CONSTRUCTOR
     *  @param AirlineCode
     * @param SourceAirportCode
     * @param SourceAirportID
     * @param DestinationAirportCode
     * @param Stops
     *
     */
    public Routes(String AirlineCode, String SourceAirportCode, String SourceAirportID, String DestinationAirportCode, int Stops) {
        this.AirlineCode = AirlineCode;
        this.SourceAirportCode = SourceAirportCode;
        this.SourceAirportID = SourceAirportID;
        this.DestinationAirportCode = DestinationAirportCode;
        this.Stops = Stops;



    }

    public int getStops() {
        return Stops;
    }

    public void setStops(int stops) {
        Stops = stops;
    }

    public static String getAirlineCode() {
        return AirlineCode;
    }

    public static void setAirlineCode(String airlineCode) {
        AirlineCode = airlineCode;
    }

    public static String getSourceAirportCode() {
        return SourceAirportCode;
    }

    public static void setSourceAirportCode(String sourceAirportCode) {
        SourceAirportCode = sourceAirportCode;
    }

    public static String getSourceAirportID() {
        return SourceAirportID;
    }

    public static void setSourceAirportID(String sourceAirportID) {
        SourceAirportID = sourceAirportID;
    }

    public static String getDestinationAirportCode() {
        return DestinationAirportCode;
    }

    public static void setDestinationAirportCode(String destinationAirportCode) {
        DestinationAirportCode = destinationAirportCode;
    }
}




