package IgorClass.Node;

/**
 *
 * this class represents a generic Node
 *
 * @author Guy Tuval
 */
public class Node <T extends Comparable<? super T>> {

    private static int total_Nodes_Created = 0;
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
    protected Node[] child;
    /**
     * the parent node , if null then its the Root node
     */
    protected Node parent;
    /**
     * the farthest route to a leaf
     */
    protected int nodeDgree;
    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data data of the node's data type
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Constructor
     *
     * @param data   data of the node's data type
     * @param parent the parent node
     */
    public Node(T data, Node parent) {
        this(data, parent, 2);
    }

    /**
     * Constructor
     *
     * @param data   data of the node's data type
     * @param parent the parent node (defaults to null)
     * @param size   the size of the node child list (defaults to 2)
     */
    public Node(T data, Node parent, int size) {
        this.data = data;
        this.parent = parent;
        this.nodeSize = size;
        this.child = new Node[this.nodeSize];
        this.nodeDgree = 0;
        total_Nodes_Created++;

    }
    //-------------------------------------- Methods ----------------------------------------------------------//

    /**
     * Gets the data item of the node
     *
     * @return returns the data of the node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Gets the parent node
     *
     * @return returns the parent node
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * Sets the Parent of the node
     * REWRITES CURRENT PARENT IF EXISTS
     *
     * @param parent a parent to set to Node
     */
    protected void setParent(Node parent) {
        this.parent = parent;

    }

    /**
     * Gets the 'childIndex' child of the node
     *
     * @param childIndex The index of the child in the node child list
     * @return returns the child in the 'childIndex' position
     */
    public Node getChild(int childIndex) {
        return this.child[childIndex];
    }

    /**
     * Gets the number of children of the node
     *
     * @return returns node Size
     */
    public int size() {
        return this.nodeSize;
    }

    /**
     * Sets the chilld to the 'index' position of the node child list
     * REWRITES CURRENT CHILD IF EXISTS !!
     *
     * @param index the postion to set in the list
     * @param toSet the child to set in the list
     */
    protected void setChild(int index, Node toSet) {
        toSet.parent = this;
        this.child[index] = toSet;
        updateHeight();
    }

    /**
     * get the dgree of the current node
     *
     * @return returns the dgree of the node
     */
    public int getNodeDgree() {
        if (this == null) {
            return -1;
        }
        return nodeDgree;
    }

    /**
     * updates the hight form current node down
     */
    protected void updateHeight() {
        if (this == null) {
            this.nodeDgree = -1;
            return;
        }
        Node currentMax = null;
        for (int i = 0; i < this.nodeSize; i++) {
            try {
                this.getChild(i).updateHeight();
                if (currentMax == null || this.getChild(i).getNodeDgree() > currentMax.nodeDgree) {
                    currentMax = this.getChild(i);
                }

            } catch (NullPointerException ex) {
                this.nodeDgree = 0;
                continue;
            }
        }
        try {
            this.nodeDgree = currentMax.getNodeDgree() + 1;
        } catch (NullPointerException ex) {
            this.nodeDgree = 0;
        }


    }
}