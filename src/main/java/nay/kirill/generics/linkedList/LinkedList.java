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
        //Просто добавим один самый первый элемент из переданного списка
        this.add((T) t.start.val); //почему тут нужно делать приведение типов ? без этого ошибка,
        // а в финальном решении все работает без приведения типов, описание класса и данного метода одинаковые
        // и в моем решении и в финальном решении
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
