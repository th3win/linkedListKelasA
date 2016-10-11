package cobalinkedlist;

/**
 *
 * @author Pemrograman Dasar II Stiki, kelas A
 */

class Node{
    String data;
    Node prev;
    Node next;
    public Node(String new_data){
        this.data = new_data;
    }
    public void setNext(Node otherNode){
        this.next = otherNode;
        otherNode.prev = this;
    }
    public void setPrev(Node otherNode){
        this.prev = otherNode;
        otherNode.next = this;
    }
}

class LinkedList{
    Node head;
    Node tail;
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void push(Node newNode){ // 5 orang
        // TODO: write the code, add newNode
        if (head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public Node qpop(){ // 5 orang
        // TODO: write the code, pop node (queue), return it
        if(head == null){
            System.out.println("LinkedList Kosong");
            return null;
        }else if(head == tail){
            Node temp = head;
            head = null;
            tail = null;
            return temp;
        }else{
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            return temp;
        }
    }
    public Node spop(){ // 5 orang
        if(head == tail){
            Node temp = tail;
            tail = null;
            head = null;
            return temp;
        }else if(tail == null){
            System.out.println("LinkedList Kosong");
            return null;
        }else{
            Node temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            return temp;
        }
    }
    public void insert(Node newNode, Node position){ // 6 orang
        // TODO: insert newNode after position
        /*
        Node temp = position.next;
        position.setNext(newNode);
        newNode.setPrev(position.next.prev);
        temp.setPrev(newNode);
        newNode.setNext(temp);
        */
        Node baru = newNode;
        Node current = head;
        if(head != null){
            while(!current.data.equalsIgnoreCase(position.data)){
                current = current.next;
            }
            if(current.data.equals(tail.data)){ // Like push
                baru.setPrev(current);
                tail = baru;
            }else{
                baru.setNext(current.next);
                baru.setPrev(current);
            }
        }else{
            System.out.print("not allowed to insert newNode, use push instead");
        }
    }
    /*
    public void delete(Node position){ // 6 orang
        // TODO: delete Node position from linked list
        Node ha = position.prev;
        Node pus = position.next;
        ha.setNext(pus);
        pus.setPrev(ha);
        position = null;
    }
    */
    public void delete(Node position){ // 6 orang
        // TODO: delete Node position from linked list
        Node current = head;
        while(!current.data.equals(position.data) && !current.equals(tail)){
            current = current.next;
        }
        if(!current.data.equals(position.data) && current.equals(tail)){
            System.out.println("delete error, Node "+position.data+" not found");
        }else if(current.next != null && !current.equals(head) && !current.equals(tail)){
            Node temp = current;
            temp = temp.prev;
            temp.setNext(current.next);
            current = null;
        }else{
            if(current.equals(head)){
                head = head.next;
                head.setNext(head.next);
            }else if(current.equals(tail)){
                tail = tail.prev;
                tail.next = null;
                tail.setPrev(tail.prev);
            }else{
                System.out.print("delete error, Node "+position.data+" not found");
            }
        }
    }

    public void view(){
        Node current = head;
        while(current != null){            
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
public class CobaLinkedList {
    public static void main(String[] args) {
        LinkedList kruntelan = new LinkedList();
        kruntelan.push(new Node("A"));
        kruntelan.push(new Node("B"));
        kruntelan.view(); // muncul A B
        kruntelan.push(new Node("C"));
        kruntelan.qpop();
        kruntelan.view(); // muncul B C
        kruntelan.spop(); // muncul B
        kruntelan.spop(); // muncul ''
        Node x = new Node("X");
        Node y = new Node("Y");
        kruntelan.push(new Node("A"));
        kruntelan.push(x);
        kruntelan.push(new Node("B"));
        kruntelan.push(new Node("C"));
        kruntelan.insert(y, x);
        kruntelan.view(); // A X Y B C
        kruntelan.delete(x);
        kruntelan.view(); // A Y B C
    }
}
