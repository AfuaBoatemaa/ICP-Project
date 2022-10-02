import java.io.*;
import java.util.*;

public class Main {

    //Hashmap
    static HashMap<String, ArrayList<String>> AirportMapOne = new HashMap<>(); //Contains City country mapping to Airport code
    static HashMap<String, String> AirportMapTwo = new HashMap<>(); //Maps Airport codes to City and country

    //Hashmap
    static HashMap<String, ArrayList<Routes>> routeHashmap = new HashMap<>();


    public static void main(String[] args) {

        //Reading the routes file
        try {
            BufferedReader bufferedroutes = new BufferedReader(new FileReader("routes.csv"));
            String routesline = bufferedroutes.readLine();


            while (routesline != null) {
                //Separating routes data by commas
                String[] Routesinfo = routesline.split(",");

                //Route objects
                Routes route = new Routes(Routesinfo[0], Routesinfo[1], Routesinfo[2], Routesinfo[4], Integer.parseInt(Routesinfo[7]));

                String SourceAirportCode = Routesinfo[2];

                ArrayList<Routes> routesArrayList = routeHashmap.get(SourceAirportCode);
                if (routesArrayList != null){
                    routesArrayList.add(route);
                    routeHashmap.put(SourceAirportCode, routesArrayList);
                }else {
                    ArrayList<Routes> newRouteslist = new ArrayList<>();
                    newRouteslist.add(route);
                    routeHashmap.put(SourceAirportCode, newRouteslist);
                }

                routesline = bufferedroutes.readLine();
            }
            //Reading the airport file

            BufferedReader airportBr = new BufferedReader(new FileReader("airports.csv"));
            String airportlines = airportBr.readLine();


            while (airportlines != null) {
                String[] AirportInfo = airportlines.split(",");

                String CityCountry = AirportInfo[2] + "," + AirportInfo[3];
                String airportCode = AirportInfo[4];


                ArrayList<String> airportCodes = AirportMapOne.get(airportCode);

                if (airportCodes != null) {
                    airportCodes.add(airportCode);
                    AirportMapOne.put(CityCountry, airportCodes);
                }
                else {
                    ArrayList<String> AirportCodes2 = new ArrayList<>();
                    AirportCodes2.add(airportCode);
                    AirportMapOne.put(CityCountry, AirportCodes2);
                }

                AirportMapTwo.put(airportCode, CityCountry);

                airportlines = airportBr.readLine();

            }

            FileReader inputFile = new FileReader("AccraWinniPeg.txt");
            BufferedReader bufferedFile = new BufferedReader(inputFile);

            String startCityAndCountry = bufferedFile.readLine();
            String destinationCityAndCountry = bufferedFile.readLine();

            ArrayList<String> output = breadthFirstSearch(startCityAndCountry, destinationCityAndCountry);

            File outputFile = new File("outputfile");

            FileWriter outputData = new FileWriter("outputfile");

            ArrayList<String> Test = breadthFirstSearch("Accra,Ghana","Winnipeg,Canada");
            System.out.println(Test);
            
        }
        catch (IOException ie) {
            System.out.println("Error: " + ie.getMessage());
        }

    }
    //Implementing Breadth First search Algorithm
    public static ArrayList<String> breadthFirstSearch(String startState, String goalState) {
        Queue<Node> frontier = new ArrayDeque<>();
        Set<String> Explored = new HashSet<>();

        ArrayList<String> ListAirports = AirportMapOne.get(startState);

        for (String AirportCode : ListAirports) {
            frontier.add(new Node(null, null, AirportCode, 0));
        }

        while (frontier.size() > 0) {
            Node node = frontier.remove();
            Explored.add(node.getAirportCode());

            ArrayList<Routes> routesArrayList = routeHashmap.get(node.getAirportCode());
            if (routesArrayList != null) {
                for (Routes childstates : routesArrayList) {
                    Node child = new Node(node, childstates.getAirlineCode(), childstates.getDestinationAirportCode(), childstates.getStops());

                    String endCityandCountry = AirportMapTwo.get(child.getAirportCode());

                    if (!frontier.contains(child) && !Explored.contains(child.getAirportCode())) {
                        if (endCityandCountry.equals(goalState)) {
                            return child.solutionPath();
                        }
                        frontier.add(child);
                    }
                }
            }
        }

        return null;
    }

}

