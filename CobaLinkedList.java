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
    }
    public Node qpop(){ // 5 orang
        Node data1 = null;
        if(head == tail){ 
            data1 = head;
            head  = null;
            tail  = null;
        }
    else { 
            data1      = head;
            head       = head.next;
            head.prev  = null;
            data1.next = null;
           }
        return data1;
    }
    
    public Node spop(){ // 5 orang
        // TODO: write the code, pop node (stack), return it
        return null;
    }
    public void insert(Node newNode, Node position){ // 6 orang
        // TODO: insert newNode after position
    }
    public void delete(Node position){ // 6 orang
        // TODO: delete Node position from linked list
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

