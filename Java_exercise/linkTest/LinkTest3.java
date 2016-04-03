/**
 * 利用内部类实现的链表.
 * Created by james on 2016/4/3.
 */
public class LinkTest3 {

    public static void main(String[] agrs){
        Link3 all = new Link3();
        all.add3("hello");
        all.add3("world");
        all.add3("hehe");
    }
}
class Link3{
    private Node3 root3;
    public void add3(String data3){
        Node3 newNode3 = new Node3(data3);
        if (this.root3 == null){
            this.root3 = newNode3;
        }else {
            this.root3.addNode3(newNode3);
        };
    }

    private class Node3{
        private String data3;
        private Node3 next3;
        public Node3(String data3){
            this.data3 = data3;
        }

        public void addNode3(Node3 newNode3){
            if(this.next3 == null){
                this.next3 = newNode3;
            }else {
                this.next3.addNode3(newNode3);
            };
        }
    }

}
