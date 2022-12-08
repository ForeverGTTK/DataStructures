package IgorClass.stacks;


public class Stack  {
    private int data[] ;
    private int stackStart=0;
    private int nextItem =0;

    public Stack (int[] data,int stackSize){
        this (stackSize);
        initData(data);
        }

    public Stack (int stackSize){
        this.data=new int[stackSize];
    }


      private void initData(int[] data){
        for (int i=0;i<data.length;i++)
        push(data[i]);
    }

    public void push(int data){
        this.data[nextItem] = data;
        nextItem++;
    }

    public int pop (){
        this.nextItem -= 1;
        return this.data[nextItem+1];
    }

    public int size(){
        return this.data.length;
    }

    public int top(){
        return this.data[nextItem];
    }

    public boolean isEmpty (){
        if (nextItem==stackStart)
            return true;
        return false;
    }

    public void printStack()
    {
        System.out.print("the stack contains [");
        for (int i=0;i<this.nextItem;i++){
            System.out.print(data[i]+", ");
        }
        System.out.println("]");
    }

}
