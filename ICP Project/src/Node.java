import java.util.ArrayList;
import java.util.Collections;

public class Node {
    private Node Parent;
    private String AirlineCode;
    private String AirportCode;
    private int Stops;

    /**
     * CONSTRUCTOR
     * @param Parent
     * @param AirlineCode
     * @param AirportCode
     * @param Stops
     */

    public Node(Node Parent, String AirlineCode , String AirportCode, int Stops){
        this.Parent = Parent;
        this.AirlineCode = AirlineCode;
        this.AirportCode = AirportCode;
        this.Stops = Stops;

    }

    public Node getParent() {
        return Parent;
    }

    public void setParent(Node parent) {
        Parent = parent;
    }

    public String getAirlineCode() {
        return AirlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        AirlineCode = airlineCode;
    }

    public String getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(String airportCode) {
        AirportCode = airportCode;
    }

    public int getStops() {
        return Stops;
    }

    public void setStops(int stops) {
        Stops = stops;
    }

    public ArrayList<String> solutionPath(){
        ArrayList<String> pathwayList = new ArrayList<>();
        ArrayList<String>  AirportCodes = new ArrayList<>();
        ArrayList<Integer> StopsList = new ArrayList<>();
        ArrayList<String> AirlineCodes = new ArrayList<>();

        Node currentNode = this;

        while(currentNode != null){
            AirportCodes.add(currentNode.getAirportCode());
            StopsList.add(currentNode.getStops());
            AirlineCodes.add(currentNode.getAirlineCode());

            currentNode = currentNode.Parent;
        }
        Collections.reverse(AirportCodes);
        Collections.reverse(StopsList);
        Collections.reverse(AirlineCodes);

        for (int i = 0; i < AirlineCodes.size() -1; i++){
            String result = i+1 + " " + AirlineCodes.get(i+1) + " from " + AirportCodes.get(i + 1) + " to " +
                    AirlineCodes.get(i + 1) + " " + StopsList.get(i) + "stops";

            pathwayList.add(result);
        }

        return pathwayList;

    }
}
