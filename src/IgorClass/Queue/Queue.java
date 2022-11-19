package IgorClass.Queue;

public class Queue {

    private int queueList[];
    private int tail = 0;
    private int head = 0;

    public Queue (int[] QueueList, int size){
        this(size);
        loadQueue(QueueList);
    }

    public Queue (int size){
        this.queueList = new int [size];
    }

    public void loadQueue (int[] listToInput){
        for (int i=0;i<listToInput.length;i++){
            enqueue(listToInput[i]);
        }
    }

    public void enqueue (int data) {
        this.queueList[head]=data;
        if (head < queueList.length-1)
        head++;
        else {
            if (tail>0)
            {
                head=0;
            }
            System.out.println("no Space");
        }

    }

    public int front (){
        return this.queueList[tail];

    }

    public int size (){
        int size = head-tail;
        if (size <0)
            return tail-head;
        return size;
    }

    public boolean isEmpty(){
        if (tail == head){
            System.out.println("there is nothing in the Queue");
            return true;
        }
        return false;
    }

    public int dequeue (){
        int temp = queueList[tail];
        if (!isEmpty() && tail < queueList.length){
        tail++;
        }else if (tail == queueList.length){
            tail =0;
        }
        else if (isEmpty()){
            System.out.println("nothing to Dequeue");
            return -1;
        }
        return temp;
    }

    public void printQueue(){
        System.out.print(
                        "The queue holds "+
                        size() +
                        "values and can hold up to: "+
                        this.queueList.length+
                        " values\n\t["
        );
        for (int i=this.tail;i != head; i++ ){
            System.out.print(queueList[i]+ ", ");
            if (i == queueList.length-1)
                i = -1;
        }
        System.out.println("]");
    }
}
