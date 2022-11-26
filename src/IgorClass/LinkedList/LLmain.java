package IgorClass.LinkedList;

public class LLmain {
    public static void main(String[] args) {
        int[] data = new int[]{5,4,13,7,2,6,3,5,4};
        LinkedList head = new LinkedList(data[0]) , tempList= head;
        for (int i=1;i<data.length;i++ ){
            tempList.insert( new LinkedList(data[i]));
            tempList = tempList.getNext();
        }
        head.printList();
        head.delete_duplicate();
        head = head.reverse();
        head.printList();
    }
}
