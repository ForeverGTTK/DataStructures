package IgorClass.LinkedList;

public class LinkedList {

    private int data;
    private LinkedList next;

    public LinkedList (int data, LinkedList next){
        this.data=data;
        this.setNext(next);

    }
    public LinkedList (int data){
        this(data,null);
    }
    public LinkedList (){
        this(-1,null);
    }
    public LinkedList getNext(){
        return this.next;
    }
    private void setNext(LinkedList next) {
        this.next = next;
    }

    public boolean isEmpty(){
    if (this.data==-1){
        return true;
    }
        return false;
    }

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

    public LinkedList insert_first(LinkedList L){
    L.insert(this);
    return L;
    }

    public void insert(LinkedList L){
        this.setNext(L);
    }

    public LinkedList delete_first (){
        return this.next;
    }

    public void delete(LinkedList toDelete){
        LinkedList tempList = toDelete;
        while (tempList.getNext() != toDelete){
            tempList = tempList.getNext();
        }
        tempList.setNext(toDelete.getNext());
    }

    public void delete_after(){
        LinkedList toDelete = this.getNext();
        this.setNext(toDelete.getNext());
    }

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

