import java.util.Iterator;
public class Stabel<T> implements Liste<T>{
    protected int storrelse = 0;
    protected Node head;

    Stabel(T element){
        this.head = new Node(element);
        this.storrelse = 1;
    }
    Stabel(){
    }

    public int storrelse(){
        return storrelse;
    }

    public boolean erTom(){
        if (head == null){
            return true;
        }
        return false;
    }

    public void settInn(T element){
        Node temp = new Node(element);
        temp.next = this.head;
        this.head = temp;
        this.storrelse ++;
    }

    public T fjern(){
        if(this.erTom()){
            return null;
        }
        else {
            T temp = this.head.data;
            this.head = this.head.next;
            this.storrelse--;
            return temp;
        }
    }

    protected class Node{
        public Node next;
        public T data;
        Node(T element){
            data = element;
        }
    }

    public Iterator<T> iterator(){
        Iterator<T>  iterator = new LLIterator();
        return iterator;
    }

    protected class LLIterator implements Iterator<T>{
        LLIterator(){
            next = head;
        }

        protected Node next;

        public boolean hasNext(){
            if (next == null){
                return false;
            }
            return true;
        }

        public T next(){
            if (this.hasNext()){
                T temp = next.data;
                next = next.next;
                return temp;
            }
            return null;
        }

        public void remove(){
            fjern();
        }

    }

}
