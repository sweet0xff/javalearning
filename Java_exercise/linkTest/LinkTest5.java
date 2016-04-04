/**
 * Created by Zeng Ge on 2016/4/4.
 */

public class LinkTest5 {

    public static void main(Book[] agrs){
        Link5 L =new Link5();
        L.add5(new Book("Java核心技术",122.22));
        L.add5(new Book("MySQL技术内幕",100.22));
        L.add5(new Book("web 开发实战",44.30));
        System.out.println("the number of books is" + L.size());
//        System.out.println(A.isEmpty());
//        A.add4("hehe");
//        A.add4("hello");
//        A.add4("world");
//        A.add4("java");
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
class Link5{
    private Node5 root5;
    private int count = 0;
    private int foot = 0;
    private Book [] retArrary;  //返回的数组

    public void add5(Book data5){
        if(data5 == null){
            return ;
        }
        Node5 newNode5 = new Node5(data5);
        if(this.root5 ==null){
            this.root5 = newNode5;
        }else {
            this.root5.addNode5(newNode5);
        }
        this.count ++;
    }
    public int size(){    //链表大小
        return count;
    }
    public boolean isEmpty(){    //判断链表是否空
        return this.count == 0;
    }
    public boolean contains(Book data5){ //查询节点是否存在
        if(data5 == null || this.root5 == null){//判断查询的数据是否为空，或者是根节点是否为空
            return false;
        }else {
            return this.root5.containsNode(data5);
        }
    }

    public Book get(int index){
        if(index > count){
            return null;
        }
        this.foot = 0; //从前向后查
        return this.root5.getNode(index);
    }
    public void set(int index, Book data5){
        if(this.foot > index){ //如果要修改的位置大于链表的长度，直接return.
            return;
        }else {
            this.root5.setNode(index,data5);
        }
    }
    public Book [] toArrary(){
        if(this.root5 ==null){
            return null;
        }
        this.foot = 0;
        this.retArrary = new Book[this.count];
        this.root5.toArraryNode();
        return this.retArrary;
    }
    public void remove(Book data5){
        if(this.contains(data5)){ //判断数据是否存在
            //
            if(data5.compare(this.root5.data5)){
                this.root5 = this.root5.next5;
            }else {  //如果不是根元素
                this.root5.next5.removeNode(this.root5,data5);
            }
            this.count --;
        }
    }
    private class Node5{
        private Book data5;
        private Node5 next5;  //引用关系
        public Node5(Book data5){
            this.data5 = data5;
        }
        // 增加节点.
        public void addNode5(Node5 newnode5){
            if(this.next5 == null){
                this.next5 = newnode5;
            }else {
                this.next5.addNode5(newnode5);
            }
        }
        //query node.
        public boolean containsNode(Book data5){
            if(data5.compare(this.data5)){
                return true;
            }else {  //继续向下查找.
                if(this.next5 !=null){ //判断后面还有没有Node
                    this.next5.containsNode(data5);
                }else {
                    return false;
                }
            }
            return false;
        };
        public Book getNode(int index){
            //使用当前foot的内容与index比较.
            //foot 自增.
            if(Link5.this.foot ++ == index){
                return this.data5;
            }else {  //继续向后查询.
                return this.next5.getNode(index);
            }
        }
        public void setNode(int index,Book data5){
            if(Link5.this.foot ++ == index){
                this.data5 = data5; //修改内容
            }else {
                this.next5.setNode(index,data5);
            }
        }
        public void removeNode(Node5 previous,Book data5){
            if(data5.compare(this.data5)){
                previous.next5  = this.next5;
            }else {
                this.next5.removeNode(this,data5);
            }
        }
        //第一次调用(Link):this= Link.root;
        //第二次调用(Node):this= Link.root.next;
        public void toArraryNode(){
            Link5.this.retArrary[Link5.this.foot ++] = this.data5;
            if(this.next5 != null){
                this.next5.toArraryNode();
            }
        }
    }
}