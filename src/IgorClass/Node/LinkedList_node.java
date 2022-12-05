package IgorClass.Node;

/**
 * this Class represents a linked list implementing nodes
 *
 * @author Guy Tuval
 */
public class LinkedList_node <T extends Comparable<T>> extends Node {
    //-------------------------------------- Finals ----------------------------------------------------------//
    /**
     * default node child list size
     */
    private static final int DEFAULT_CHILD_SIZE =1;
    /**
     * the default adress of the next child in the list
     */
    private static final int NEXT_CHILD=0;
//-------------------------------------- Constructor ----------------------------------------------------------//
    /**
     * Constructor
     *
     * @param data The data of the node
     * @param parent The parent of the node
     */
    public LinkedList_node (T data, LinkedList_node parent){
        super(data,parent,DEFAULT_CHILD_SIZE);
    }

    /**
     * Constructor
     *
     * @param data the data of the node
     */
    public LinkedList_node(T data){
        this(data,null);
        }

    //-------------------------------------- Methods ----------------------------------------------------------//

    /**
     * insert a new node at the end of the list
     * @param toInsert a node to insert to the list
     */
    public void insert(LinkedList_node toInsert){
        if (this.next()== null){
            this.setChild(toInsert);
        }
        else {
            this.next().insert(toInsert);
        }
    }

    /**
     * Sets a child to a sepcific node
     * @param child a child to insert to the current node
     */
    public void setChild(Node child){
        super.setChild(NEXT_CHILD,child);
    }

    /**
     * Gets the next node of the list
     * @return returns the next element
     */
    public LinkedList_node next (){
        return (LinkedList_node) this.getChild(NEXT_CHILD);
    }

    /**
     * Prints the LInked list of the current head
     */
    public void printLIst(){
        LinkedList_node toPrint= this;
        System.out.print(
                "The list:\n\t (" +
                 toPrint.getData() +
                 ")"
        );
        while (toPrint.next()!= null){
            toPrint = toPrint.next();
            System.out.print(
                    "-->(" +
                    toPrint.getData() +
                    ")"
                    );

        }
    }
}
