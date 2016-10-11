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
        Node temp = head.next;
        head = temp;
        temp.prev=null;
        return null;
    }
    public Node spop(){ // 5 orang
        if(head != null){
            Node temp = head;// deklarasi node temporary,disimpan sementara dalam temp
            head = head.next;
            temp.next = null;
            return temp;
        } else {
            System.out.println("List Kosong.");
            return null;}
    }
    public void insert(Node newNode, Node position){ // 6 orang
        // TODO: insert newNode after position
        Node temp = position.next;
        position.setNext(newNode);
        newNode.setPrev(position.next.prev);
        temp.setPrev(newNode);
        newNode.setNext(temp);
    }
    public void delete(Node position){ // 6 orang
        // TODO: delete Node position from linked list
        Node ha = position.prev;
        Node pus = position.next;
        ha.setNext(pus);
        pus.setPrev(ha);
        position = null;
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
//BISMA Lebih Kece :V:
