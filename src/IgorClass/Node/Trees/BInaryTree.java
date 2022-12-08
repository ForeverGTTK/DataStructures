package IgorClass.Node.Trees;

import IgorClass.Node.Node;

public class BInaryTree <T extends Comparable<T>> extends Node {
    //-------------------------------------- Finals ----------------------------------------------------------//
    /**
     * default node child list size
     */
    private static final int DEFAULT_CHILD_SIZE =2;

    /**
     * Left child index
     */
    private static final int LEFT_CHILD_INDEX =0;
    private static final int RIGHT_CHILD_INDEX =1;
//-------------------------------------- Constructor ----------------------------------------------------------//
    /**
     * Constructor
     *
     * @param data The data of the node
     * @param root The parent of the node
     */
    public BInaryTree (T data, BInaryTree root){
        super(data,root,DEFAULT_CHILD_SIZE);
    }

    /**
     * Constructor
     *
     * @param data the data of the node
     */
    public BInaryTree(T data){
        this(data,null);
    }
//-------------------------------------- Constructor ----------------------------------------------------------//

    /**
     * insert a new node to the 'index' place of the child
     * @param toInsert a node to insert to the tree
     * @param index the index of the child to insert the node to
     */
    protected void insertLeft(BInaryTree toInsert,int index){
        switch (index){

            case LEFT_CHILD_INDEX :
                if (this.getChild(index)==null){
                    this.setChild(index,toInsert);
                    break;
                }

            case RIGHT_CHILD_INDEX:
                if (this.getChild(index)==null){
                    this.setChild(index,toInsert);
                    break;
                }
            default:
                if (index == LEFT_CHILD_INDEX || index == RIGHT_CHILD_INDEX) {
                    this.next(index).insertLeft(toInsert,index);
                }
        }
    }

    public void insert(BInaryTree toInsert, int index) {
        this.insertLeft(toInsert,index);
    }

    public BInaryTree next (int childIndex)
    {
    return  childIndex ==RIGHT_CHILD_INDEX||childIndex==LEFT_CHILD_INDEX ? (BInaryTree)this.getChild(childIndex): null;
    }



}
