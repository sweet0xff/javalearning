package IO;

/**
 * Created by zeng on 16-4-9.
 */

public class LinkTest {

    public static void main(Book[] agrs){
        Link L =new Link();
        L.add(new Book("Java核心技术",122.22));
        L.add(new Book("MySQL技术内幕",100.22));
        L.add(new Book("web 开发实战",44.30));
        System.out.println("the number of books is" + L.size());
//        System.out.println(A.isEmpty());
//        A.add("hehe");
//        A.add("hello");
//        A.add("world");
//        A.add("java");
//        A.set(1,"NB");
//        System.out.println(A.isEmpty());
//        System.out.println(A.contains("hehe"));
//        System.out.println(A.get(1));
//        System.out.println(A.size());
//        A.remove("world");
//        System.out.println(A.size());
//        String [] s = A.toArrary();
//        for(int i = 0; i < s.length;i ++){
//            System.out.println(s[i]);
//        }
    }
}
class Book{
    private String title;
    private double prcie;
    public Book(String title,double prcie){
        this.title = title;
        this.prcie = prcie;
    }
    public String getInfo(){
        return "图书名称:" + this.title + ",价格：" +  this.prcie;
    }
    public boolean compare(Book  book){
        if (this == book){
            return true;
        }
        if(book == null){
            return false;
        }
        if (this.title.equals(book.title) && this.prcie ==book.prcie){
            return true;
        }
        return  false;
    }
}
class Link{
    private Node root;
    private int count = 0;
    private int foot = 0;
    private Book [] retArrary;  //返回的数组

    public void add(Book data){
        if(data == null){
            return ;
        }
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
        }else {
            this.root.addNode(newNode);
        }
        this.count ++;
    }
    public int size(){    //链表大小
        return count;
    }
    public boolean isEmpty(){    //判断链表是否空
        return this.count == 0;
    }
    public boolean contains(Book data){ //查询节点是否存在
        if(data == null || this.root == null){//判断查询的数据是否为空，或者是根节点是否为空
            return false;
        }else {
            return this.root.containsNode(data);
        }
    }

    public Book get(int index){
        if(index > count){
            return null;
        }
        this.foot = 0; //从前向后查
        return this.root.getNode(index);
    }
    public void set(int index, Book data){
        if(this.foot > index){ //如果要修改的位置大于链表的长度，直接return.
            return;
        }else {
            this.root.setNode(index,data);
        }
    }
    public Book [] toArrary(){
        if(this.root ==null){
            return null;
        }
        this.foot = 0;
        this.retArrary = new Book[this.count];
        this.root.toArraryNode();
        return this.retArrary;
    }
    public void remove(Book data){
        if(this.contains(data)){ //判断数据是否存在
            //
            if(data.compare(this.root.data)){
                this.root = this.root.next;
            }else {  //如果不是根元素
                this.root.next.removeNode(this.root,data);
            }
            this.count --;
        }
    }
    private class Node{
        private Book data;
        private Node next;  //引用关系
        public Node(Book data){
            this.data = data;
        }
        // 增加节点.
        public void addNode(Node newnode){
            if(this.next == null){
                this.next = newnode;
            }else {
                this.next.addNode(newnode);
            }
        }
        //query node.
        public boolean containsNode(Book data){
            if(data.compare(this.data)){
                return true;
            }else {  //继续向下查找.
                if(this.next !=null){ //判断后面还有没有Node
                    this.next.containsNode(data);
                }else {
                    return false;
                }
            }
            return false;
        };
        public Book getNode(int index){
            //使用当前foot的内容与index比较.
            //foot 自增.
            if(Link.this.foot ++ == index){
                return this.data;
            }else {  //继续向后查询.
                return this.next.getNode(index);
            }
        }
        public void setNode(int index,Book data){
            if(Link.this.foot ++ == index){
                this.data = data; //修改内容
            }else {
                this.next.setNode(index,data);
            }
        }
        public void removeNode(Node previous,Book data){
            if(data.compare(this.data)){
                previous.next  = this.next;
            }else {
                this.next.removeNode(this,data);
            }
        }
        //第一次调用(Link):this= Link.root;
        //第二次调用(Node):this= Link.root.next;
        public void toArraryNode(){
            Link.this.retArrary[Link.this.foot ++] = this.data;
            if(this.next != null){
                this.next.toArraryNode();
            }
        }
    }
}
