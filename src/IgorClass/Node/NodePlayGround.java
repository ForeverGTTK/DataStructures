package IgorClass.Node;

import IgorClass.Node.Trees.LinkedList_node;
import IgorClass.Node.Trees.BInaryTree;

public class NodePlayGround {


    public static void BFS(BInaryTree node){
        for (int i=0; i< node.size();i++){
            if (node.getChild(i)!= null)
                BFS((BInaryTree)node.getChild(i));
            System.out.print(node.getData()  );
        }
        System.out.println("\\\\");
    }


    public static void main(String[] args) {
        System.out.println("********************* Linked List ************************************");
        Integer[]list =new Integer[]{1, 2, 3, 4, 5,9,14,111,5};
        LinkedList_node lLsRoot = new LinkedList_node<Integer>(list[0]);
        for (int i=1; i< list.length;i++) {
            lLsRoot.insert(new LinkedList_node<>(list[i]));
        }
       lLsRoot.printLIst();
        lLsRoot.insert(new LinkedList_node<>(7));
        lLsRoot.printLIst();

        System.out.println("\n********************* Binary Tree************************************");

        BInaryTree bInaryTree = new BInaryTree<Integer>(7);
        for (int j=0,i=0; j<list.length;j++,i++){
        if (i<=1){
            bInaryTree.insert(new BInaryTree<>(list[j]),i);
        }
        else{
            i=0;
        }
    }
        BFS(bInaryTree);
    }

}
