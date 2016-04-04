/**
 * 实现了一个简单的链表操作.
 * Created by Zeng on 2016/4/3.
 */
public class LinkTest {

    public static void main(String[] agrs){
        Node n1 = new Node("node1");
        Node n2 = new Node("node2");
        Node n3 = new Node("node3");

        n1.setNext(n2);
        n2.setNext(n3);

        Node currentNode = n1;
        while(currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}

class Node{
    private String data;
    private Node next;
    public Node(String date){
        this.data= date;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return this.next;
    }
    public String getData(){
        return this.data;
    }
}
