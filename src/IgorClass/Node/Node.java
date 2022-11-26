package IgorClass.Node;

public class Node <T extends Comparable <T>> {

    private int nodeSize;
    private T data;
    private Node[] child;
    private Node parent;

    public Node (T data ){
        this(data,null);
    }

    public Node (T data, Node parent){
       this(data,parent,2);
    }
    public Node (T data,Node parent, int size){
        this.data=data;
        this.parent=parent;
        this.nodeSize= size;
        this.child = new Node[this.nodeSize];
    }

    public T getData(){
        return this.data;
    }

    public Node getChild(int childIndex){
        return this.child[childIndex];
    }


}
