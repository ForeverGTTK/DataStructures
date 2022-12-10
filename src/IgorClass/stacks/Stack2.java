package IgorClass.stacks;

/**
 * this Class represents a Stack of Integers
 * the stack requires a size allocation to initialize
 *
 * @author Guy Tuval
 */
public class Stack2 {
    /****************** Attributes ******************/
    /**
     * the array that represents the stack.
     */
    private int []stack;
    /**
     *pointer to the first item in the stack
     */
    private int lastIn=0;
/****************** Constructors ******************/
    /**
     * Constructor
     *
     * @param stackSize The Max capacity of the stack.
     * @param values an Array of data in the stack
     */
    public Stack2(int stackSize, int[] values){
    this(stackSize);
    this.push(values);
    }

    /**
     * Constructor
     *
     * @param stackSize The Max capacity of the stack.
     */
    public Stack2(int stackSize){
        this.stack= new int[stackSize];
    }

    /****************** Methods ******************/

    /**
     * Load an Array of Integers into the Stack.
     *
     * @param values an Array of integers to insert into the stack.
     */
    public void push (int[] values){
    for (int i=0; i<values.length;i++){
    this.push(values[i]);
    }
    }

    /**
     * load a single Integer to the Stack
     *
     * @param value a Integer to insert to top of the stack
     */
    public void push(int value){
        this.stack[lastIn]= value;
        lastIn++;
    }

    /**
     * check what is in the top of the stack without popping from the stack.
     *
     * @return returns the first element of the stack
     */
    public int top (){
        return this.stack[lastIn-1];
    }

    /**
     * pops the first elemnt in the stack
     * if the list is empty returns -1
     * @return returns the popped element
     */
    public int pop (){
        if (!this.isEmpty()) {
            this.lastIn--;
            return this.stack[lastIn];
        }
        return -1;
    }

    /**
     * Gets the Size of the stack
     *
     * @return returns the Size of the stack
     */
    public int size (){
        return this.lastIn;
    }

    /**
     * if the stack has elements in it return false
     * if the stack dosent contain anything return true
     *
     * @return false if stack has elements , true otherwise
     */
    private boolean isEmpty (){
        if (this.lastIn>0){
            return false;
        }
        return true;
    }

    /**
     * Prints the stack elements
     */
    public void printStack() {
        System.out.print("[");
        for (int i=0;i<this.lastIn;i++){
            System.out.print(this.stack[i] +", " );
        }
        System.out.println("]");
    }
}
