package IgorClass.Node;

/**
 *
 * this class represents a Node
 *
 * @author Guy Tuval
 */
public abstract class Node <T extends Comparable <T>> {
    //-------------------------------------- Attributes ----------------------------------------------------------//

    /**
     * Amount of children a node can hold
     */
    private int nodeSize;
    /**
     * The data the Node holds
     */
    private T data;
    /**
     * The list of Children the node has with size of 'nodeSize'
     */
    private Node[] child;
    /**
     * the parent node , if null then its the Root node
     */
    private Node parent;
    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data data of the node's data type
     */
    public Node (T data ){
        this(data,null);
    }

    /**
     * Constructor
     *
     * @param data data of the node's data type
     * @param parent the parent node
     */
    public Node (T data, Node parent){
       this(data,parent,2);
    }
    /**
     * Constructor
     *
     * @param data data of the node's data type
     * @param parent the parent node (defaults to null)
     * @param size the size of the node child list (defaults to 2)
     */
    public Node (T data,Node parent, int size){
        this.data=data;
        this.parent=parent;
        this.nodeSize= size;
        this.child = new Node[this.nodeSize];
    }
    //-------------------------------------- Methods ----------------------------------------------------------//

    /**
     * Gets the data item of the node
     * @return returns the data of the node
     */
    public T getData(){
        return this.data;
    }

    /**
     * Gets the parent node
     * @return returns the parent node
     */
    public Node getParent(){
        return this.parent;
    }

    /**
     * Sets the Parent of the node
     * REWRITES CURRENT PARENT IF EXISTS
     * @param parent a parent to set to Node
     */
    protected void setParent(Node parent){
        this.parent= parent;
    }

    /**
     * Gets the 'childIndex' child of the node
     * @param childIndex The index of the child in the node child list
     * @return returns the child in the 'childIndex' position
     */
    public Node getChild(int childIndex){
        return this.child[childIndex];
    }

    /**
     * Sets the chilld to the 'index' position of the node child list
     * REWRITES CURRENT CHILD IF EXISTS !!
     * @param index the postion to set in the list
     * @param child the child to set in the list
     */
    protected void setChild(int index ,Node child){
        this.child[index] = child;
        this.child[index].parent=this;
    }

    public abstract Node next();
}
