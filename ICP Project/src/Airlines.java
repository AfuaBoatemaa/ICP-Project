
import java.util.Scanner;
import java.io.*;



/**
 * @author Afua Boatemaa Amankwaah
 */

public class Airlines {
            /**
             * Instance Variables
             */
            private static String AirlineID;
            private static String AirlineName;
            private String Alias;
            private String IATACode;

    /**
     * CONSTRUCTOR
     * @param AirlineID
     * @param AirlineName
     * @param Alias
     * @param IATACode
     *
     */
        public Airlines(String AirlineID, String AirlineName, String Alias, String IATACode){
        this.AirlineID = AirlineID;
        this.AirlineName = AirlineName;
        this.Alias = Alias;
        this.IATACode = IATACode;

}

        public static void main(String[] args) {

            try{ BufferedReader airportBr = new BufferedReader(new FileReader("airlines.csv"));
                }

            catch (IOException ie){
                    System.out.println("Error: " + ie.getMessage());
                }
            }

        }

