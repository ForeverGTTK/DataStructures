package IgorClass.stacks;

public class Stack2 {
    private int []stack;
    private int lastIn=0;

    public Stack2(int stackSize, int[]values){
    this(stackSize);
    this.loadStack(values);
    }

    public Stack2(int stackSize){
        this.stack= new int[stackSize];
    }


    private void loadStack (int[] values){
    for (int i=0; i<values.length;i++){
    this.push(values[i]);
    }
    }

    public void push(int value){
        this.stack[lastIn]= value;
        lastIn++;
    }

    public int top (){
        return this.stack[lastIn-1];
    }

    public int pop (){
        if (!this.isEmpty()) {
            int popping = this.stack[lastIn - 1];
            this.lastIn--;
            return popping;
        }
        return -1;
    }

    public int size (){
        return this.lastIn;
    }

    private boolean isEmpty (){
        if (this.lastIn>0){
            return false;
        }
        return true;
    }


    public void printStack() {
        System.out.print("[");
        for (int i=0;i<this.stack.length;i++){
            System.out.print(this.stack[i] +", " );
        }
        System.out.println("]");
    }
}
