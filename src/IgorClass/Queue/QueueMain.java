package IgorClass.Queue;

public class QueueMain {

    public static void main(String[] args) {
        int[]list =new int[]{1, 2, 3, 4, 5,9,14,111,5};
        Queue queue = new Queue(list,10);
        queue.enqueue(7);
        System.out.println(queue.dequeue() + queue.dequeue());
        System.out.print(queue.front()+"\t");
        System.out.println(queue.dequeue()+ queue.dequeue());
        System.out.println(queue.dequeue()+ queue.dequeue());
        queue.enqueue(12);
        queue.enqueue(555);
        queue.loadQueue(new int []{50,35,42,13});
        queue.printQueue();
    }
}
