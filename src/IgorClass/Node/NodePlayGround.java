package IgorClass.Node;

import IgorClass.Queue.Queue;

public class NodePlayGround {

    public static void main(String[] args) {
        Integer[]list =new Integer[]{1, 2, 3, 4, 5,9,14,111,5};
        LinkedList_node lLsRoot = new LinkedList_node<Integer>(list[0]);
        for (int i=1; i< list.length;i++) {
            lLsRoot.insert(new LinkedList_node<>(list[i]));
        }
       lLsRoot.printLIst();
        lLsRoot.insert(new LinkedList_node<>(7));
        lLsRoot.printLIst();

    }
}
