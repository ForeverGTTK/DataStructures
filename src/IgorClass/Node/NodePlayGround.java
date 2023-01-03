package IgorClass.Node;

import IgorClass.Node.Trees.AVLtree;
import IgorClass.Node.Trees.BinarySearchTree;
import IgorClass.Node.Trees.LinkedList_node;

public class NodePlayGround {



    public static void main(String[] args) {
//        System.out.println("********************* Linked List ************************************");
//        Integer[] list = new Integer[]{2, 3, 1, 5, 4, 6, 14, 9 , 8 , 111, 10,12, 5};
//        LinkedList_node lLsRoot = new LinkedList_node<Integer>(list[0]);
//        for (int i = 1; i < list.length; i++) {
//            lLsRoot.insert(new LinkedList_node<>(list[i]));
//        }
//        lLsRoot.printLIst();
//        lLsRoot.insert(new LinkedList_node<>(7));
//        lLsRoot.printLIst();
//        System.out.println("");

        System.out.println("\n********************* Binary Tree************************************");


        AVLtree avl  = new AVLtree<Integer>(0);
        for (int i=1;i <=5; i++){
            avl.insert(new AVLtree<Integer>(i));
        }
        avl.printTree();
//        BinarySearchTree bstRoot = new BinarySearchTree<Integer>(7);
//        for (int i=0; i<list.length;i++){
//            bstRoot.insert(new BinarySearchTree<Integer>(list[i]));
//        }
//        bstRoot.find(5).printTree();
//        bstRoot.delete(bstRoot.find(5));
//        bstRoot.find(3).printTree();
//        bstRoot.printTree();

    }
}
