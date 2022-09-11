import java.util.ArrayList;
/**
* An application class to help you test your BusRoute class
* @author Nick Meek and Karen Gray
*/
public class BusRouteApp{
  
   public static void main(String[] args){
   
   
      BusRoute route = new BusRoute("City Circle", "Bus Hub");
      System.out.println("Initialise:\n" + route);
      
      route.addStop("Dog Park", 60, 60, "Bus Hub");
      route.addStop("Port", 60, 60, "Dog Park");
      route.addStop("Park", 60, 60, "Port");
      route.addStop("Cemetery", 60, 60, "Park");
      route.addStop("Cinema", 60, 60, "Cemetery");
      route.addStop("Mall", 60, 60, "Cinema");
      route.addStop("Golf Course", 60, 60, "Mall");
      route.addStop("Swimming Pool", 60, 60, "Golf Course");
      route.addStop("Hospital", 60, 60, "Swimming Pool");
      route.addStop("Zoo", 60, 60, "Hospital");
      route.addStop("Museum", 60, 60, "Zoo");
     
     
      System.out.println("Initial Route for the " + route.getRouteId() +":\n" + route);
      //add more tests
      
      route.addStop("New Park", 30, 30, "Cinema");
      route.addStop("Vet Clinic", 40, 20, "Bus Hub");
      
      route.suspendStop("Mall");
      route.suspendStop("Cinema");
      route.removeStop("Swimming Pool");
      route.activateStop("Cinema");
      
      
      System.out.println("*".repeat(40));
      System.out.println("Modified Route for the " + route.getRouteId() +":\n" + route);
      System.out.println("*".repeat(40));
      System.out.println("Number of seconds between the Swimming Pool and the Cemetery: " + route.secondsBetween2Stops("Swimming Pool", "Cemetery"));
      System.out.println("Number of seconds between the Museum and the Port: " + route.secondsBetween2Stops("Museum", "Port"));
   }
}

