package IgorClass.Node.Trees;

public class AVLtree <T> extends BinarySearchTree {

    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data The data of the node
     * @param root The parent of the node
     */
    public AVLtree (T data, BinaryTree root){
        super(data,root);

    }

    /**
     * Constructor
     *
     * @param data the data of the node
     */
    public AVLtree(T data){
        this(data,null);
    }

    //-------------------------------------- Methods ----------------------------------------------------------//

    public AVLtree getParent(){
        super.getParent();
    }

    public void insert(AVLtree toInsert ){
        super.insert(toInsert);
        toInsert.updateHeight();
    }

    public void updateHeight(){
        if (this.getParent()== null){
            return;
        }
        int leftChildHeight =-1, rightChildHeight= -1;
        if (this.leftChild()!= null){
            leftChildHeight = this.leftChild().getNodeDgree();
        }
        if (this.rightChild()!= null){
            rightChildHeight = this.rightChild().getNodeDgree();
        }
        int hDif = leftChildHeight- rightChildHeight;
        if ( hDif >1){     // Left Heavy - rotate right
         this.rotateRight();
        }
        else if (hDif< -1){ // Right Heavy - rotate left
            this.rotateLeft();
        }
        AVLtree parent = (AVLtree) this.getParent();
        parent.updateHeight();
        // else the tree is balanced
    }

    public void rotateLeft(){ // right heavy
        if (this.leftChild().getNodeDgree()>this.rightChild().getNodeDgree()){
            this.left_left();
        }else{
            this.right_left();
        }

    }

    private void left_left(){
        AVLtree parent = (AVLtree) this.getParent();
        if (parent.getParent()!= null){
            if(parent.getParent().getChild(LEFT_CHILD_INDEX) == parent){
                parent.getParent().setChild(LEFT_CHILD_INDEX,this);
            }
            else {
                parent.getParent().setChild(RIGHT_CHILD_INDEX,this);
            }
        }
        parent.setChild(RIGHT_CHILD_INDEX, null);
        this.insert(parent);
    }

    private void right_left(){
        AVLtree node =(AVLtree) this.rightChild() , child = (AVLtree) node.rightChild();
        child.setChild(LEFT_CHILD_INDEX,node);



    }

    public void rotateRight(){ //left heavy
        if (this.leftChild().getNodeDgree()<this.rightChild().getNodeDgree()){
            this.right_right();
        }else{
            this.left_right();
        }
    }
    private void right_right(){

    }
    private void left_right(){

    }

}
