/**
* A class to represent and manage a busRoute which is comprised of a number of BusStops
* and provide information about the time between any pair of BusStops
* @author Nick Meek and Karen Gray
*/
public class BusRoute<T extends BusStop> extends CircularDoubleLinkedList<T>{

   /**The id of this route*/
   private String routeId;

  
  
 /**
   * Constructor
   * @param routeId The unique identifier for this bus route
   * @param firstBusStopId The id of the first stop on this route.
   */
   public BusRoute(String routeId, String firstBusStopId){
     
      //The first BusStop on the route points to itself and has zero travel times.
      super((T) new BusStop(firstBusStopId, 0, 0));
      this.routeId = routeId;
   
   }
  
   /**
   * A method to set (or change) the route id
   * @param routeId The unique identifier for this bus route
   */  
   public void setRouteId(String routeId){
      this.routeId = routeId;
   }
  
   /**
   * A method to set (or change) the route id
   * @return routeId The unique identifier for this bus route
   */  
   public String getRouteId(){
      return routeId;
   }

   /**
   * Return a pointer to the DLLNode containing the BusStop with the given id - or null if not found.
   * @param busStopID The id of the BusStop to locate
   * @return a reference to the DLLNode containing the BusStop with the given id or null if not found
   */
  
   private DLLNode<T> findNode(String busStopID){
   
   
      DLLNode<T> current = first;
     
      do{
      
         if((current.value.getId()).equals(busStopID)){
           
            return current;
         }
         current = current.next;
      
      }while(current != first);
           
      return null;
   
    
   }
  
   /** UNCOMMENT when findNode is written
   * Return a pointer to the BusStop with the given id - or null if not found.
   * @param busStopId The id of the BusStop to locate
   * @return a reference to the specified BusStop or null if not found
   */
   public BusStop findStop(String busStopId){
   
      DLLNode<T> node = findNode(busStopId);
      if(node == null){
         return null;
      } else{
         return (T)node.value;
      }
   }
  
   /**
   * A method to add a new BusStop immediately after (clockwise)
   *  the BusStop with the specified prevStopId
   * @param stopId The unique identifies for this bus Stop
   * @param secsToNextStop How many seconds to the next bus Stop going Clockwise
   * @param secsToPrevStop How many seconds to the next bus Stop going Anticlockwise
   * @param prevStopId The id of the stop Anticlockwise of where the new stop should be added.
   */
   public void addStop(String stopId, int secsToPrevStop, int secsToNextStop, String prevStopId){
   
      DLLNode<T> prev = findNode(prevStopId);
      if(prev==null){
         System.out.println("Can't be done");
      }else{
         BusStop stop = new BusStop(stopId, secsToPrevStop, secsToNextStop);
         insertNode(prev, (T)stop);
      
      }
   }

  
   /** A method to remove the BusStop with the specified id.
   * @param busStopId the id of the BusStop to remove
   */
   public void removeStop(String busStopId){
      if(((T)first.value).getId().equals(busStopId)){
         System.out.println("You cannot remove the hub!");
      }else{
         BusStop stop = findStop(busStopId);
         DLLNode<T> stopNode = findNode(busStopId);
      
      
         if(stop.getId().equals(busStopId)){
         
            suspendStop(busStopId);
            stopNode.next.prev = stopNode.prev;
            stopNode.prev.next = stopNode.next;
            size--;

         }
      
      }
   
   }
  
  
   /** UNCOMMENT when findNode is written
   * A method to suspend the BusStop with the specified id.
   * NOTE: This does NOT affect the travel times to adjacent stops.
   * @param busStopId the id of the BusStop to suspend
   */
   public void suspendStop(String busStopId){
      if(((T)first.value).getId().equals(busStopId)){
         System.out.println("You cannot suspend the hub!");
      }else{
         BusStop stop = findStop(busStopId);
         if(stop != null){ 
            stop.setInService(false);
         }
      }
   }
  
   /**  UNCOMMENT when findNode is written
   * A method to activate the BusStop with the specified id.
   * NOTE: This does NOT affect the travel times to adjacent stops.
   * @param busStopId the id of the BusStop to activate
   */
   public void activateStop(String busStopId){
      BusStop stop = findStop(busStopId);
      if(stop != null){ 
         stop.setInService(true);
      }
   }

   /** A method to calculate the time to travel between two BusStops (clockwise)
   * The distance is strictly from busStop1 to busStop2 even if that means
   * going via the Bus Hub.
   * @param busStop1 the id of the first BusStop
   * @param busStop2 the id of the second BusStop
   * @return int The number of seconds between two BusStops, or -1 if either of the stops does not exist.
   */

   public int secondsBetween2Stops(String busStop1Id, String busStop2Id){
   
      int timeBetweenStops = 0;
      
      BusStop stop1 = findStop(busStop1Id);
      BusStop stop2 = findStop(busStop2Id);
      
      DLLNode<T> stopNode1 = findNode(busStop1Id);
      DLLNode<T> stopNode2 = findNode(busStop2Id);
   
      if(stop1 == null || stop2 == null){
      
         timeBetweenStops = -1;
         return timeBetweenStops;
         
      }else{
      
         int stopTime = 0;
         int antiClockWise = 0;
      
         while(stopNode1 != stopNode2){

             assert stopNode1 != null;
             stopTime += stopNode1.value.getClockwiseSecs();

            stopNode1 = stopNode1.next;
         }
         timeBetweenStops = stopTime;
         return timeBetweenStops;
         
         
      }
   
   }

   public void listConnector() {
   }
  


}