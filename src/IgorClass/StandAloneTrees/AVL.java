package IgorClass.StandAloneTrees;

public class AVL <T extends Comparable <T>> {
    //---------------------------------------- Attributes ---------------------------------------------//

    BST root;

    //---------------------------------------- Constructor ---------------------------------------------//

    public AVL (T data){
        root = new BST<T>(data);

        }
    //---------------------------------------- Methods ---------------------------------------------//

    /**
     * Insert a node to the root
     * @param data data to insert to the node
     */
    public void insert(T data) {
        this.insert(new BST<T>(data));
    }
    public void insert( BST toInsert){
        root.insert(toInsert);
        this.checkBalance(root);
    }

    /**
     * delete a node from the root
     * @param toFind node to find in the root
     */
    public void delete (T toFind){
        this.delete(root.find(toFind));
    }
    public void delete (BST toDelte){
        if (root == toDelte) {
            root = root.delete(toDelte);
        }
        else {
            root.delete(toDelte);
        }
        this.checkBalance(root);
    }


    public void checkBalance(BST root) {

    if ( root.getLeftChild()==null && root.getRightChild() == null ){
        root.height = 0;
    }
    else if (root.getLeftChild()!= null && root.getRightChild() == null){
        checkBalance(root.leftChild);
        root.height= root.getLeftChild().height+1;
        if (root.getLeftChild().height > 1){
            rotateRight(root.leftChild);
        }
    }
    else if (root.getRightChild()!= null && root.getLeftChild() == null){
        checkBalance(root.getRightChild());
        root.height = root.getRightChild().height+1;
        if (root.getRightChild().height > 1){
            rotateLeft(root.getRightChild());
        }
    }
    else{
        root.height = Math.max(root.getLeftChild().height,root.getRightChild().height);
        if (root.getLeftChild().height - root.getRightChild().height >1){  //left heavy
            rotateRight(root);
        }
        else if (root.getLeftChild().height - root.getRightChild().height <-1){// right heavy
            rotateLeft(root);
        }
        //otherwise the rotation is not needed
    }

    }
    //---------------------------------------- Rotations ---------------------------------------------//

    public void rotateLeft(BST toRotate){
        System.out.println(" imagine you rotated "+ toRotate.getData()+ " to the left"+ toRotate.getParent().getData() +" was demoted to left");
    }

    public void rotateRight(BST toRotate){

        System.out.println(" imagine you rotated "+ toRotate.getData()+ " to the right"+ toRotate.getParent().getData() +" was demoted to rigt");
    }

    //---------------------------------------- printing - traversal ---------------------------------------------//

    public void print_preOrder(){
        print_preOrder(root);
    }
    public void print_preOrder(BST root){
        System.out.println( "Pre Order :" + root.preOrder().toString());
    }

    public void print_inOrder(){
        print_inOrder(root);
    }
    public void print_inOrder(BST root){
        System.out.println( "In Order :" + root.inOrder().toString());
    }

    public void print_postOrder(){
        print_postOrder(root);
    }
    public void print_postOrder(BST root){
        System.out.println( "Post Order :" + root.postOrder().toString());
    }


    public void print_levelOrder(){
        print_levelOrder(root);
    }
    public void print_levelOrder(BST root){
        System.out.println( "Level Order :" + root.levelOrder().toString());
    }

    public void print_Tree (){
        print_Tree(root);
    }
    public void print_Tree(BST root){
        root.print_BST();
    }

}
