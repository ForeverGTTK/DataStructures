package IgorClass.StandAloneTrees;


import IgorClass.Queue.Queue;

import java.util.ArrayList;

/**
 * this class represents a binary search tree
 *
 * @author Guy Tuval
  */

public class BST <T extends Comparable<T>>{
    //---------------------------------------- Statics  ---------------------------------------------//
    /**
     * the maximum number of children a binary node can have
     */
    public static final int NUMBER_OF_CHILDREN = 2;

    //---------------------------------------- Attributes ---------------------------------------------//
    /**
     * the information the node hold
     */
    protected T data;
    /**
     * the Parent of the current Node
      */
    protected BST parent;

    /**
     * the Left Child of the node
     */
    protected BST leftChild;

    /**
     * the Right child of the node
     */
    protected BST rightChild;

    /**
     * the hieght of the longest route to a leaf
     */
    protected  int height = 0;

//---------------------------------------- Constructor ---------------------------------------------//

    /**
     * Constructor
     *
     * sets parent & children to be null
     *
     * @param data data to set to the node
     */
    public BST (T data){
        this.data = data;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

//---------------------------------------- Getters & Setters ---------------------------------------------//

    /**
     * gets the parent Node
     * @return returns the parent node
     */
    public BST getParent() {
        return this.parent;
    }

    /**
     * gets the data of the node
     * @return returns the data of the node
     */
    public T getData() {
        return this.data;
    }

    /**
     * gets the left child of the node
     * @return returns left child
     */
    public BST getLeftChild() {
        return this.leftChild;
    }

    /**
     * gets the right child of the node
     * @return returns right child
     */
    public BST getRightChild() {
        return this.rightChild;
    }

    /**
     * sets the parent of a node
     *  REWRITES CURRENT PARENT !
     * @param toSet a node to set as a parent
     */
    protected void setParent(BST toSet) {
        this.parent = toSet;
    }

    /**
     * sets the rightChild of the node
     *  REWRITES CURRENT CHILD
     * @param toSet right child to set for current node
     */
    protected void setRight(BST toSet) {
        this.rightChild = toSet;
        toSet.setParent(this);
    }

    /**
     * sets the leftChild of the node
     *  REWRITES CURRENT CHILD
     * @param toSet left child to set for current node
     */
    protected void setleft (BST toSet){
        this.leftChild = toSet;
        toSet.setParent(this);
    }

    /**
     * sets the data of a current child
     * @param data data to set for the node
     */
    public void setData(T data) {
        this.data = data;
    }

    //---------------------------------------- Methods ---------------------------------------------//

    /**
     * inserts a node into the next null node in the tree
     *  if the node is larger or equal to current insert right
     *  if the node is smaller than current insert left
     * @param toInsert a node to insert to the tree
     */
    public void insert (BST toInsert){
        if (toInsert == null){
            return;
        }
        // if the node is smaller than current
        if (this.getData().compareTo((T) toInsert.getData()) == 1){
            if (this.getLeftChild() == null){
                this.setleft(toInsert);
            }else {
                this.leftChild.insert(toInsert);
            }
        }
        // if the node is equal or larger
        else {
            if (this.getRightChild() == null){
                this.setRight(toInsert);
            }else {
                this.rightChild.insert(toInsert);
            }
        }
    }

    /**
     * locates a node equals to 'toFind' data object using binary search tree conditions
     * if item not found in tree returns null
     * @param tofind object to search for in the tree
     * @return returns the first node that hold that data
     */
    public BST find (T tofind){
        if (this == null){
            System.out.println("item not found !");
            return null;
        }
        if (this.getData() == tofind){
            return this;
        }
        else if (this.getData().compareTo( tofind) == 1){
            return this.leftChild.find(tofind);
        }
        else {
            return this.rightChild.find(tofind);
        }

    }

    public void delete (T tofind){
        delete(this.find(tofind));
    }

    private boolean removeChild (BST toRemove){
        if (toRemove.getData() == this.leftChild.getData()){
          this.leftChild = null;
        }
        else if (toRemove.getData()== this.rightChild.getData()){
            this.rightChild = null;
        }else {
            return false;
        }
        this.insert(toRemove.getLeftChild());
        this.insert(toRemove.getRightChild());
        return true;
    }

    public BST delete (BST toDelete){
        if (toDelete.getParent() == null){
            if (toDelete.leftChild != null) {
                toDelete.leftChild.insert(toDelete.rightChild);
                this = toDelete.leftChild;
                return toDelete.leftChild;
            }else{
                this = toDelete.rightChild;
                return toDelete.rightChild;

            }
        }
        else if (!toDelete.getParent().removeChild(toDelete)){
            System.out.println("could not remove child");
            return null;
        }
            return this;
    }


    /**
     * updates the height of the current node
     *  the height of a node is the maximum height of its children + 1
     */
    public void updateHeight() {
        if (this.leftChild == null && this.rightChild == null) {
            this.height = 0;
        } else if (this.leftChild == null) {
            this.height = this.rightChild.height + 1;
        } else if (this.rightChild == null) {
            this.height = this.leftChild.height + 1;
        } else {
            this.height = Math.max(this.leftChild.height, this.rightChild.height) + 1;
        }
    }

    //---------------------------------------- traversal ---------------------------------------------//

    public ArrayList<T> postOrder(){

        ArrayList<T> postOrderedTree = new ArrayList<>();
        if (this.leftChild != null){
            postOrderedTree.addAll(this.leftChild.postOrder());
        }
        if (this.rightChild != null) {
            postOrderedTree.addAll(this.rightChild.postOrder());
        }
        postOrderedTree.add(this.getData());
        return postOrderedTree;
    }

    public ArrayList<T> inOrder(){

        ArrayList<T> inOrderedTree = new ArrayList<>();
        if (this.leftChild != null){
            inOrderedTree.addAll(this.leftChild.inOrder());
        }
        inOrderedTree.add(this.getData());
        if (this.rightChild != null) {
            inOrderedTree.addAll(this.rightChild.inOrder());
        }
        return inOrderedTree;
    }

    public ArrayList<T> preOrder(){

        ArrayList<T> preOrderedTree = new ArrayList<>();
        preOrderedTree.add(this.getData());
        if (this.leftChild != null){
            preOrderedTree.addAll(this.leftChild.preOrder());
        }
        if (this.rightChild != null) {
            preOrderedTree.addAll(this.rightChild.preOrder());
        }
        return preOrderedTree;
    }

    public ArrayList<T> levelOrder () {
        ArrayList<T> levelOrderedTree = new ArrayList<>();
        Queue queue = new Queue<BST>();
        queue.enqueue(this);
        while (!queue.isEmpty()){
            BST current = (BST) queue.dequeue();
            if (current.getLeftChild() != null){
            queue.enqueue(current.getLeftChild());
            }
            if (current.getRightChild()!= null) {
                queue.enqueue(current.getRightChild());
            }
            levelOrderedTree.add((T) current.getData());
        }
        return levelOrderedTree;
    }

    public boolean validateBST (){
        if (this == null){
            return true;}
        if (this.leftChild != null&& this.leftChild.validateBST()){
            if (this.getData().compareTo((T)this.getLeftChild().getData()) <= 0 ){
                System.out.println(this.getData() + " is not smaller than " + this.leftChild.getData());
                return false;
            }
        }
        if (this.rightChild != null && this.rightChild.validateBST()){
            if (this.getData().compareTo((T)this.getRightChild().getData())  > 0) {
                System.out.println(this.getData() + " is not bigger than " + this.rightChild.getData());
                return false;
            }
        }
        return true;
    }
}
