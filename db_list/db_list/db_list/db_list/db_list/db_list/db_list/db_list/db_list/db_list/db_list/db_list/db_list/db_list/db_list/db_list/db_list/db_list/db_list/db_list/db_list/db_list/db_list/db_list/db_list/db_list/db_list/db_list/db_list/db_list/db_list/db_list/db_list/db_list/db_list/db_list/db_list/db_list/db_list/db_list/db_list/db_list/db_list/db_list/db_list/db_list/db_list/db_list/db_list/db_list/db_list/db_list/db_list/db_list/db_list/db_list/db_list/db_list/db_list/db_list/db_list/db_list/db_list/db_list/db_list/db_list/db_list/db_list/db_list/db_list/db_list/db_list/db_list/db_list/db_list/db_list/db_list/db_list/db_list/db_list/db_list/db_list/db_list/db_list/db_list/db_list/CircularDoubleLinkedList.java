/** A class that can manage a circular doubly linked list of Student objects.
* @author Nick Meek and Karen Gray*/
public class CircularDoubleLinkedList<T>{
   
   /** The first node of this CircularDoubleLinkedList.*/
   protected DLLNode<T> first;
   /** The current size of this CircularDoubleLinkedList.*/
   protected int size;
  
   /** Initialises the first node which must then be made to point to itself!
   @param g the value being inserted into the very first node.*/
   public CircularDoubleLinkedList(T g){
     
      first = new DLLNode<T>(g, null, null);
      first.prev =first;
      first.next = first;
      size++;
   }

  
   /** Takes a reference to an existing node, positionNode,  and inserts a new node AFTER the positionNode.
      @param positionNode the node that will precede the new node when traversing the list clockwise."
      @param value the value wrapped/stored in the new node.
   */
  
   public void insertNode(DLLNode<T> positionNode, T value){
  
    
      DLLNode<T> current = first;
     
      if(positionNode == null){
     
         return;
     
      }
        
      DLLNode<T> newNode = new DLLNode<T>(value, positionNode.next, positionNode);
  
      positionNode.next.prev = newNode;
      positionNode.next = newNode;
      size++;
  
   }  
   /** Returns the number of nodes in this circular list.
      @return The number of items in this list.
   */
   public int size(){ 
      return size;
   }
  

  
    /** Iterates through the list of DLLNode objects, CLOCKWISE,  appending the value of
    * each one to a StringBuilder instance.
    @return a String representation of this CircularDoubleLinkedList
   */

   public String toString(){
   
      StringBuilder sb = new StringBuilder();
      DLLNode<T> current = first;
   
      sb.append(current.value + "\n");
      current = current.next;
   
   
   
      while(current!=first){
      
         sb.append(current.value + "\n");
         current = current.next;
       
      }
      return sb.toString();
   
   }
  
 
   /** Removes the given node from this list but NEVER the first one
   @param removeMe the node to be removed
   */
   public void removeNode(DLLNode<T> removeMe){
     
      if(removeMe == first || removeMe == null ){
         return;
      }
   
      removeMe.prev.next = removeMe.next;
      removeMe.next.prev = removeMe.prev;
      size--;    
   }
  
   /** A doubly linked node with references to its two adjacent nodes and to its value*/
   protected class DLLNode<T>{
      protected T value;
      protected DLLNode<T> next, prev;
   
      /** Constructs a doubly linked node containing references to its two adjacent nodes and to its value
      @param value the value wrapped/stored in this node.
      @param next the node adjacent to this node CLOCKWISE
      @param prev the node adjacent to this node ANTICLOCKWISE
      */
      protected DLLNode(T value, DLLNode<T> next, DLLNode<T> prev){
         this.value = value;
         this.next =  next;
         this.prev = prev;
      }
   }
  
}

/**      
      if(current == first){
         DLLNode<T> BusHub = positionNode;
      
         DLLNode<T> Port = positionNode.next;
      
         DLLNode<T> dogPark = new DLLNode<T>(value, positionNode.next, positionNode);
         Port.prev = dogPark;
         BusHub.next = dogPark;
      }
      
   
      while(current != first){
         if(positionNode.equals(current)){
         
         
            DLLNode<T> cemetrery = positionNode;
         
            DLLNode<T> Mail = positionNode.next;
                 
            DLLNode<T> cinema = new DLLNode<T>(value, positionNode.next, positionNode);
         
            Mail.prev = cinema;
            cemetrery.next = cinema;
            cinema = cemetrery;
         
         }
         current = current.next;
      
      }
      **/