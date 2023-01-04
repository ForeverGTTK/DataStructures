package IgorClass.StandAloneTrees;

public class standAloneTST {

    public static void main(String[] args) {
        AVL avl = new AVL<Integer>(0);
        int [] list = {3,5,8,4,2,6,1,5,7};
        System.out.print("the input order:");
        for (int i=0 ; i<list.length; i++){
            avl.insert(list[i]);
            System.out.print(list[i]+", ");
        }
        avl.print_preOrder();
        avl.print_inOrder(avl.root.find(5));
        avl.print_postOrder();
        avl.print_levelOrder();
        avl.print_Tree();
        System.out.println("done");
    }
}
