package IgorClass.stacks;

import java.util.ArrayList;

/**
 * this class represents a generic stack
 *
 * @author Guy Tuval
 */
public class Stack <T extends Comparable <T>> {
    //-------------------------------------- Attributes ----------------------------------------------------------//

    /**
     * list of data
     */
    private ArrayList<T> data ;
    /**
     * an indicator for the top item in the queue
     */
    private int nextItem =0;

    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data a list of data to insert to stack
     */
    public Stack (T[] data){
        this ();
        initData(data);
        }

    /**
     * Constructor
     *
     * @param data Item to insert into the stack
     */
    public Stack (T data){
        this.data.add(data);
    }

    /**
     * Constructor
     */
    public Stack (){
        this.data=new ArrayList<>();
    }

    //-------------------------------------- Methods ----------------------------------------------------------//


    /**
     * insert a list into the stack
     * @param data list of data to insert into the stack
     */
      private void initData(T[] data){
        for (int i=0;i<data.length;i++)
        push(data[i]);
    }

    /**
     * push an item to top of the stack
     *
     * @param data an item to insert to the stack
     */
    public void push(T data){
        this.data.add(data);
        nextItem++;
    }

    /**
     * pops an items from the top of the stack
     *
     * @return returns the item popped from the stack
     */
    public T pop (){
        this.nextItem -= 1;
        T toreturn =this.data.get(nextItem);
        this.data.remove(nextItem);
        return toreturn;
    }

    /**
     * Gets the size of the stack
     *
     * @return returns the size of the stack
     */
    public int size(){
        return this.data.size();
    }

    /**
     * Gets the top element in the stack without popping
     *
     * @return returns the next element in the stack
     */
    public T top(){
        return this.data.get(nextItem-1);
    }

    /**
     * If the Stack is Empty returns 'True' else return 'False'
     * @return
     */
    public boolean isEmpty (){
        if (data.isEmpty())
            return true;
        return false;
    }

    /**
     * Prints the stack
     */
    public void printStack()
    {
        System.out.print("the stack contains [");
        for (int i=0;i<this.nextItem;i++){
            System.out.print(data.get(i)+", ");
        }
        System.out.println("]");
    }

}
