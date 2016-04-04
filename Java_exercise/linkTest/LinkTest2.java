/**
 * Created by Zeng on 2016/4/3.
 */
public class LinkTest2 {

    public static void main(String[] agrs){
        Link n1 = new Link();
        n1.add("hello");
        n1.add("world");
        n1.add(",");
        n1.add("hehe");
        n1.print();
    }
}

class Node1{
    private String data;
    private Node1 next;
    public Node1(String data){
        this.data = data;
    }
    public void setNext(Node1 next){
        this.next = next;
    }
    public Node1  getNext(){
        return this.next;
    }
    public String getData(){
        return this.data;
    }
    public void addNode(Node1 newNode){
        if(this.next ==null){
            this.next = newNode;
        }else{
            this.next.addNode(newNode);
        }
    }
    public void printNode(){
        System.out.println(this.getData());
        if(this.next != null){
            this.next.printNode();
        }
    }
}

class Link{
    private Node1 root;

    public void add(String data){
        Node1 newNode = new Node1(data);
        if(this.root == null){
           this.root = newNode;
        }else {
           this.root.addNode(newNode);
        }
    }
    public void print(){
        if(this.root != null){
            this.root.printNode();
        }
    }
}
