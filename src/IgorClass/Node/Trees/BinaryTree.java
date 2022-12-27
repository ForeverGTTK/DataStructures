package IgorClass.Node.Trees;

import IgorClass.Node.Node;
import IgorClass.Queue.Queue;

/**
 *This Class represents a Binary tree
 *
 * @author  Guy Tuval
 */
public class BinaryTree<T> extends Tree {
    //-------------------------------------- Finals ----------------------------------------------------------//
    /**
     * default node child list size
     */
    protected static final int DEFAULT_CHILD_SIZE =2;

    /**
     * Left child index
     */
    protected static final int LEFT_CHILD_INDEX =0;
    /**
     * Right child index
     */
    protected static final int RIGHT_CHILD_INDEX =1;
//-------------------------------------- Constructor ----------------------------------------------------------//
    /**
     * Constructor
     *
     * @param data The data of the node
     * @param root The parent of the node
     */
    protected BinaryTree(T data, BinaryTree root){
        super(data,root,DEFAULT_CHILD_SIZE);
    }

    /**
     * Constructor
     *
     * @param data the data of the node
     */
    protected BinaryTree(T data){
        this(data,null);
    }


//-------------------------------------- Constructor ----------------------------------------------------------//

    /**
     * insert a node to the 'Left' child place of the node
     * @param toInsert a node to insert to the tree
     */
    protected boolean insertLeft(BinaryTree toInsert){
        if (this.leftChild() == null){
            this.setChild(LEFT_CHILD_INDEX,toInsert);
            return true;
        }
        return false;
    }
    /**
     * insert a node to the 'Right' child place of the node
     * @param toInsert a node to insert to the tree
     */
    protected boolean insertRight(BinaryTree toInsert){
        if (this.rightChild()== null){
            this.setChild(RIGHT_CHILD_INDEX, toInsert);
            return true;
        }
        return false;
    }

    protected BinaryTree leftChild(){
        return this.next(LEFT_CHILD_INDEX);
    }

    protected BinaryTree rightChild(){
        return this.next(RIGHT_CHILD_INDEX);
    }
    /**
     * insert a node to the 'Index' child place of the node
     * @param toInsert a node to insert to the tree
     * @param index index to insert child to
     */
    public boolean insert(BinaryTree toInsert, int index) {
        if (index == LEFT_CHILD_INDEX ){
            if ( !this.insertLeft(toInsert)){
             return false;
            }
        }
        else if ( index == RIGHT_CHILD_INDEX ) {
            if (!this.insertRight(toInsert)){
                return false;
            }
        }
        else if (index!=LEFT_CHILD_INDEX && index != RIGHT_CHILD_INDEX){
            System.out.println("index does not exsist , nothing happened");
            return false;
        }
        else {
           return false;
        }
        return true;
    }

//    public void delete (BinaryTree toDelete){
//        BinaryTree thisParent = (BinaryTree)toDelete.getParent();
//        BinaryTree newChild;
//        int toDeleteIndex=-1;
//        for (int i=0;i<thisParent.size();i++){
//            if (toDelete == thisParent.getChild(i)){
//                toDeleteIndex = i;
//                break;
//            }
//        }
//        for (int i=this.size()-1;i>=0;i--) {
//            newChild = toDelete.next(i);
//            if (newChild!= null){
//                thisParent.insert(newChild,toDeleteIndex);
//                for (int j=0; j<this.size();j++)
//                    if (toDelete.next(j)!= null)
//                    if (!newChild.insert(toDelete.next(j),i)){
//                        newChild.next(i).insert(toDelete.next(j),i);
//                    }
//            }
//        }
//
//    }

    /**
     * Gets the node in the 'childIndex' location of the child list
     *
     * @param childIndex The index of the child you want to inport
     * @return returns the child in the index location
     */
    protected BinaryTree next (int childIndex)
    {
    return  childIndex ==RIGHT_CHILD_INDEX||childIndex==LEFT_CHILD_INDEX ? (BinaryTree)this.getChild(childIndex): null;
    }

    /**
     * prints a binary tree in the console
     */
    public void printTree () {
        this.updateHeight();
        Queue<BinaryTree> queue = new Queue(this);
        Queue<String> signs = new Queue<>();
        BinaryTree current;
        int currntLevel=this.nodeDgree+1;
        do{
            int qSize = queue.size();
            for (int i=0; i<qSize;i++){
                System.out.print(writeSpaces(currntLevel));
                current = queue.dequeue();
                try {
                    queue.enqueue(current.next(LEFT_CHILD_INDEX));
                }catch (NullPointerException ex){
                    queue.enqueue(null);
                }
                signs.enqueue("/");
                try {
                    queue.enqueue(current.next(RIGHT_CHILD_INDEX));
                }catch (NullPointerException ex){
                    queue.enqueue(null);
                }
                signs.enqueue("\\");
                if (current==null){
                    System.out.print(
                            writeSpaces(powerOf(currntLevel)-3) +
                            "<_>"+                                              // null data
                            writeSpaces(powerOf(currntLevel)-3)
                    );
                }else{
                    System.out.print(
                        writeSpaces(powerOf(currntLevel)-3) +
                                "("+current.getData()+")"+                     //number data
                                writeSpaces(powerOf(currntLevel)-3)
                    );
                }

            }
            currntLevel--;
            System.out.println("");
            if(currntLevel>0) {
                while (!signs.isEmpty()) {
                    System.out.print(
                            writeSpaces( 2*powerOf(currntLevel)) +// [2*(2^n)]+1 | n=degree-1
                                    signs.dequeue() +                                   // print the left node sign '/'
                                    writeSpaces(2*(currntLevel-1)+2) +            // prints space between nodes (2*dgree + 1)
                                    signs.dequeue() +                                    //  prints the right node sign '\'
                                    writeSpaces( powerOf(currntLevel))
                    );
                }
                System.out.println("");
            }
        }while (currntLevel > 0);
    }


    /**
     * get a 'spaceNum' of spaces
     *
     * @param spacenum number of spaces to return
     * @return returns a string of spaces with 'spacenum' Amount
     */
    private String writeSpaces(int spacenum){
    String space = " ";
    for (int i=0;i<spacenum;i++){
        space += " ";
    }
    return space;
    }

    /**
     * add a power of 2
     * @param powerOf what power of 2 to increase
     * @return returns 2 to the power of 'powerOf'
     */
    private int powerOf (int powerOf){
        int num= 1;
        for (int i=0;i<powerOf;i++){
            num *= DEFAULT_CHILD_SIZE;
        }
        return num;
    }

}
