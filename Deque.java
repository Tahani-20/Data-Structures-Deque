
public interface Deque <E> {

   // Add an element to the front and rear
   void addFirst(E element); //add to the front

   void addLast(E element); //add to the rear

   // remove and return
   E removeFirst();// return front and remove it

   E removeLast();// return rear and remove it

   //return without removing
   E first(); // return front

   E last(); // return rear


   boolean isEmpty();  // check if the deque is empty

   boolean isFull();// check if the deque is Full

   int size(); // return the size

}