package IgorClass.Queue;

import IgorClass.Node.Node;

import java.util.ArrayList;


/**
 * this class represents a Queue
 *
 * @author Guy Tuval
 *
 */
public class Queue <T> {
    //--------------------------------------  Attributes ----------------------------------------------------------//
    /**
     * the list of items to hold in the Queue
     */
    private ArrayList<T> queueList;
    /**
     * the tail of the queue
     */
    private int tail = 0;
    /**
     * the head of the queue
     */
    private int head = 0;
    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param queueList a list to intilaize the queue with
     */
    public Queue (T[] queueList){
        this();
        loadQueue(queueList);
    }

    /**
     * Constructor
     *
     * @param firstInline a item to push to the first queue
     */
    public Queue(T firstInline){
        this();
        this.enqueue(firstInline);
    }

    /**
     * Constructor
     *
     * empty Queue
     */
    public Queue (){
        this.queueList = new ArrayList<T>();
    }

    //-------------------------------------- Methods ----------------------------------------------------------//

    /**
     * Loads a Array into the queue
     *
     * @param listToInput an array to insert into the queue
     */
    public void loadQueue (T[] listToInput){
        for (int i=0;i<listToInput.length;i++){
            enqueue(listToInput[i]);
        }
    }

    /**
     * Enqueue an item to the queue
     *
     * @param data item to insert to the Queue
     */
    public void enqueue (T data) {
        this.queueList.add(data);
        head++;
    }

    /**
     * Gets the first item in the queue without popping
     *
     * @return
     */
    public T front (){
        return this.queueList.get(tail);

    }

    /**
     * gets the size of the list in the queue
     * @return the size of the queue
     */
    public int size (){
        int size = head-tail;
        return size;
    }

    /**
     * check if the queue is empty Returns true if empty False if not
     * @return
     */
    public boolean isEmpty(){
        if (tail == head){
            return true;
        }
        return false;
    }

    /**
     * checkis if the item is in the queue
     *
     * @param toFind
     * @return
     */
    public boolean find (T toFind){
        for (int i=tail; i <=head;i++){
            if (toFind == this.queueList.get(i)){
                return true;
            }
        }
        System.out.println("the value does not Exist in the queue");
        return false;

    }

    /**
     * Dequeue an item from the queue
     *
     * @return returns the items dequeued from the queue
     */
    public T dequeue (){
        T temp = queueList.get(tail);
        tail++;
        return temp;
    }

    /**
     * prints the queue details
     */
    public void printQueue(){
        System.out.print(
                        "The queue holds "+
                        size() +
                        " values and can hold up to: "+
                        this.queueList.size()+
                        " values\n\t["
        );
        for (int i=this.tail;i < this.head; i++ ){
            System.out.print(this.queueList.get(i)+ ", ");
        }
        System.out.println("]");
    }
}
