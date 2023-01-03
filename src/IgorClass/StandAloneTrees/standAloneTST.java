package IgorClass.StandAloneTrees;

public class standAloneTST {

    public static void main(String[] args) {
        BST bst = new BST<Integer>(0);
        int [] list = {3,5,8,4,2,6,1,5,7};
        for (int i=0 ; i<list.length; i++){
            bst.insert(new BST<Integer>(list[i]));
        }
        System.out.println(bst.preOrder().toString());
        bst.delete(0);
        bst.delete(4);
        System.out.println("the tree is a bst: " + bst.validateBST());
        System.out.println(bst.inOrder().toString());


        System.out.println("done");
    }
}
