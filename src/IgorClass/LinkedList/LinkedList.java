package IgorClass.LinkedList;

/**
 * This class represents a Linked list that holds Integers
 *
 */
public class LinkedList {

    //*****************************>>>>Attributes<<<**************************************************
    /**
     * The data of the elments
     */
    private int data;
    /**
     * The next elements of the list
     */
    private LinkedList next;

    //*****************************>>>> Constructor <<<**************************************************/
    /**
     * Constructor
     *
      * @param data Integer to insert into the new elment
     * @param next  The next elements in the list
     */
    public LinkedList (int data, LinkedList next){
        this.data=data;
        this.setNext(next);

    }

    /**
     * Constructor
     *
     * @param data The data to insert into the list
     */
    public LinkedList (int data){
        this(data,null);
    }

    /**
     * Constructor
     * Creates an empty list.
     *
     */
    public LinkedList (){
        this(-1,null);
    }

    //*****************************>>>>Methods<<<**************************************************


    /**
     * Gets the next element in the list
     *
     * @return returns The next After the current one
     */
    public LinkedList getNext(){
        return this.next;
    }

    /**
     * Sets elemnt as next in LIst
     *
     * @param next An element to assign as next in list
     */
    private void setNext(LinkedList next) {
        this.next = next;
    }

    /**
     * Checks wether the list is empty or not
     * @return      if the element is -1 return true
     *              else return false
     */
    public boolean isEmpty(){
    if (this.data==-1 ){
        return true;
    }
        return false;
    }

    /**
     * Gets a certian elements that holds value 'k'
     * @param k value to search for
     * @return returns the element containing the received value
     *          if non found returns null.
     */
    public LinkedList find (int k){
        LinkedList tempList = this;
        while (tempList.next != null){
            if (this.data==k){
                return tempList;
            }
            tempList = tempList.getNext();
        }
        return null;
    }

    /**
     * Insert an elemnt as the head of the list
     *
     * @param L Element to insert as head of the list
     * @return  returns the new list to save as head
     */
    public LinkedList insert_first(LinkedList L){
    L.insert(this);
    return L;
    }

    /**
     * insert a new element ontop of the list
     *
     * @param L elemnt to insert to the end of the list
     */
    public void insert(LinkedList L){
        LinkedList current = this;
        while (current.next != null){
            current = current.next;
        }
        this.setNext(L);
    }

    /**
     * delete the head of the list
     *
     * @return return returns the second element as the new head
     */
    public LinkedList delete_first (){
        return this.next;
    }

    /**
     * delete an element from the list
     *
     * @param toDelete  an element to delete from the list
     */
    public void delete(LinkedList toDelete){
        LinkedList tempList = toDelete;
        while (tempList.getNext() != toDelete){
            tempList = tempList.getNext();
        }
        tempList.setNext(toDelete.getNext());
    }

    /**
     * delete the element next in the list
     *
     */
    public void delete_after(){
        LinkedList toDelete = this.getNext();
        this.setNext(toDelete.getNext());
    }

    /**
     * reverse the list
     *
     * @return returns a reversed list
     */
    public LinkedList reverse(){
        LinkedList head= this,next=head.getNext(),past = null;
        while (head.getNext()!= null){
            head.setNext(past);
            past=head;
            head= next;
            next = next.getNext();

        }
        head.setNext(past);
        return head;
    }

    /**
     * delete all duplicated elements from the list
     *
     */
    public void delete_duplicate(){
        LinkedList base = this, checked = base ,checkedTail;
        while (base.getNext()!= null) {
            while (checked.getNext() != null) {
                checkedTail = checked;
                checked = checked.getNext();
                if (base.data == checked.data) {
                checkedTail.delete_after();
                }
            }
            base= base.getNext();
            checked= base;
        }

    }

    /**
     * Prints the list
     */
    public void printList(){
        LinkedList tempList = this;
        System.out.print(tempList.data + "-->");
        do{
            tempList = tempList.getNext();
            System.out.print(tempList.data + "-->");
        }while(tempList.next != null);

        System.out.println("<null>");
    }

}

