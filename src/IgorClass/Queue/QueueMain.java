package IgorClass.Queue;

public class QueueMain {

    public static void main(String[] args) {
        Integer[]list =new Integer[]{1, 2, 3, 4, 5,9,14,111,5};
        Queue queue = new Queue<Integer>(list);
        queue.enqueue(7);
        queue.printQueue();
        System.out.print(queue.dequeue() +", "+ queue.dequeue()+", ");
        System.out.print(queue.front()+"<, ");
        System.out.println(queue.dequeue() + ", "+ queue.dequeue());
        System.out.println(queue.dequeue()+ ", "+ queue.dequeue());
        int [] list2= new int[]{35,42,13,12,555};
        for (int i=0;i<list2.length;i++){
            queue.enqueue(list2[i]);
        }
        queue.printQueue();
    }
}



//      (n+2)! = 0,1,2,3,......, n ,n+1 , n+2