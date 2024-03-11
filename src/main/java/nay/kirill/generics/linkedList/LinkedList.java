package nay.kirill.generics.linkedList;

public class LinkedList<T> {
    LinkedListТNode start = null;
    LinkedListТNode end = null;

    public void add(T val){

        if(end == null) {
            LinkedListТNode newObj = new LinkedListТNode(val, null, null);
            end = newObj;
            start = newObj;
        }else{
            LinkedListТNode newObj = new LinkedListТNode(val, end, null);
            end.next = newObj;
            end = newObj;
        }
    }

    public void printAll(){

        LinkedListТNode myOb = start;

        while (myOb != null) {

            System.out.println(myOb.val);
            myOb = getNext(myOb);
        }
    }

    private LinkedListТNode getNext(LinkedListТNode obj){
        return obj.next;
    }

    public void addAll(LinkedList<? extends T> t){
        this.add((T) t.start.val);
    }
}

class LinkedListТNode<T> {
    T val;
    LinkedListТNode prev;
    LinkedListТNode next;

    public LinkedListТNode(T val, LinkedListТNode prev, LinkedListТNode next){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
