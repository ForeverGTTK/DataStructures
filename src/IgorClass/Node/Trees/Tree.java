package IgorClass.Node.Trees;

import IgorClass.Node.Node;

/**
 * this class represents a Tree
 *
 * @author Guy Tuval
 */
public abstract class Tree <T> extends Node {

    /**
     * list of decendent directions (left, mid or right)['/','|','\']
     */
    String[] signList;

    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data data to insert to the tree
     */
    public Tree (T data){
        this(data,null);
    }

    /**
     * Constructor
     *
     * @param data data to insert to the tree
     * @param root the parent of the node
     */
    public Tree(T data , Tree root){
        this(data,root,2);
    }

    /**
     * Constructor (without size defaults to binary tree (size==2) )
     * @param data data to insert to the tree
     * @param root the parent node of the tree
     * @param size (defines a tree that is not binary)
     */
    public Tree (T data , Tree root, int size){
        super((Comparable) data,root,size);
        this.signList = new String[this.size()];
    }


    protected void setChild(int index ,Node toSet) {
    super.setChild(index, toSet);
    for (int i=0; i< this.signList.length; i++){
        if (this.getChild(i)!= null){
            if (i == 0){
                this.signList[i] = "/ ";
            }
            else if (i == this.signList.length-1){
                this.signList[i] = " \\";
            }
            else {
                this.signList[i] = " | ";
            }
        }
    }
    }

        /**
         * breath first search
         */
    protected void BFS(){

    }

    /**
     * traversal
     */
    protected void DFS(){

    }

    /**
     *
     */
    protected void preOrder(){

    }

    /**
     *
     */
    protected void inOrder(){

    }

    /**
     *
     */
    protected void postOrder(){

    }

}
