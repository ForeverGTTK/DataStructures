package IgorClass.Queue;

import java.util.ArrayList;


/**
 * this class represents a Queue
 *
 * @author Guy Tuval
 *
 */
public class Queue <T extends Comparable<T>> {

    private ArrayList<T> queueList;
    private int tail = 0;
    private int head = 0;

    public Queue (T[] queueList){
        this.queueList = new ArrayList<T>();
        loadQueue(queueList);
    }

    public Queue (){
    this(null);
    }

    public void loadQueue (T[] listToInput){
        for (int i=0;i<listToInput.length;i++){
            enqueue(listToInput[i]);
        }
    }

    public void enqueue (T data) {
        this.queueList.add(data);
        head++;
    }

    public T front (){
        return this.queueList.get(tail);

    }

    public int size (){
        int size = head-tail;
        return size;
    }

    public boolean isEmpty(){
        if (tail == head){
            System.out.println("there is nothing in the Queue");
            return true;
        }
        return false;
    }

    public T dequeue (){
        T temp = queueList.get(tail);
        tail++;
        return temp;
    }

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
