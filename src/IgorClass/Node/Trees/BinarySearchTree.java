package IgorClass.Node.Trees;

import java.lang.reflect.Type;

public class BinarySearchTree <T> extends BinaryTree {

    //-------------------------------------- Constructor----------------------------------------------------------//

    /**
     * Constructor
     *
     * @param data The data of the node
     * @param root The parent of the node
     */
    public BinarySearchTree (T data, BinaryTree root){
        super(data,root);

    }

    /**
     * Constructor
     *
     * @param data the data of the node
     */
    public BinarySearchTree(T data){
        this(data,null);
    }
    //-------------------------------------- Methods ----------------------------------------------------------//

    protected BinarySearchTree leftChild(){
        return (BinarySearchTree) this.next(LEFT_CHILD_INDEX);
    }

    protected BinarySearchTree rightChild(){
        return (BinarySearchTree) this.next(RIGHT_CHILD_INDEX);
    }

    public void insert (BinarySearchTree toInsert) {
        if (this.getData().compareTo(toInsert.getData()) == 1){
            if (!super.insert(toInsert, LEFT_CHILD_INDEX)){
                this.leftChild().insert(toInsert);
            }
        }
        else {
            if (!super.insert(toInsert, RIGHT_CHILD_INDEX)){
                this.rightChild().insert(toInsert);
            }
        }
    }

    public BinarySearchTree find (T toFind) {
        if (this.getData() == toFind){
            return this;
        }
        else if (this == null){
            System.out.println("item not found");
            return null;
        }
        else if (this.getData().compareTo(toFind)== 1){
            return this.leftChild().find(toFind);
        }else{
            return this.rightChild().find(toFind);
        }

    }

    public void findANDdelete(T toFindDelete){
        BinarySearchTree todelete = find(toFindDelete);
        delete(todelete);
    }

    public void delete (BinarySearchTree toDelete){
        if (toDelete == null){

        }
        BinarySearchTree thisParent = (BinarySearchTree) toDelete.getParent();
                            //find the index to the deleted item
        int indexToDelete = -1;
        for (int i=this.size()-1;i>=0;i--){
            if (thisParent.next(i) == null){
                continue;
            }
            if (thisParent.next(i)== toDelete){
                indexToDelete = i;
            }
        }
        thisParent.child[indexToDelete] = null;

        for (int i=thisParent.size();i >=0;i--){
            if (toDelete.next(i) == null){
                continue;
            }
                    thisParent.insert((BinarySearchTree) toDelete.next(i));
        }


    }


}
