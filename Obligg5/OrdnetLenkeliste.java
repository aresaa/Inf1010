public class OrdnetLenkeliste<T extends Comparable<T>> extends Stabel<T>{

    OrdnetLenkeliste(){
        
    }

    OrdnetLenkeliste(T element){
        this.head = new Node(element);
        this.storrelse++;
    }

    @Override
    public void settInn(T element){
        if (this.head == null){
            this.head = new Node(element);
            this.storrelse++;
        }
        else{
            Node temp = this.head;
            boolean first = true;
            for(Node n = this.head; element.compareTo(n.data)>0; n = n.next){
                temp = n;
                first = false;
                if (n.next == null){
                    break;
                }
            }
            Node insert = new Node(element);
            if (first){
                insert.next = this.head;
                this.head = insert;
            }
            else {
                if (temp.next!=null){
                    insert.next = temp.next;
                }
                temp.next=insert;
            }
            this.storrelse++;
        }
    }
}
