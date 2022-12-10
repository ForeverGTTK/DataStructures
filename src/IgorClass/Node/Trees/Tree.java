package IgorClass.Node.Trees;

import IgorClass.Node.Node;

/**
 * this class represents a Tree
 *
 * @author Guy Tuval
 */
public abstract class Tree <T> extends Node {

    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data data to insert to the tree
     */
    public Tree (T data){
        super(data);
    }

    /**
     * Constructor
     *
     * @param data data to insert to the tree
     * @param root the parent of the node
     */
    public Tree(T data , Tree root){
        super(data,root);
    }

    /**
     * Constructor (without size defaults to binary tree (size==2) )
     * @param data data to insert to the tree
     * @param root the parent node of the tree
     * @param size (defines a tree that is not binary)
     */
    public Tree (T data , Tree root, int size){
        super(data,root,size);
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
