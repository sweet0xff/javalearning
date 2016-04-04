/**
 * 为链表增加了计数,判断是否为空,查询元素，查询索引,删除一个元素功能。
 * Created by Zeng Ge on 2016/4/4.
 */
public class LinkTest4 {

    public static void main(String[] agrs){
        Link4 A =new Link4();
        System.out.println(A.isEmpty());
        A.add4("hehe");
        A.add4("hello");
        A.add4("world");
        A.add4("java");
        A.set(1,"NB");
        System.out.println(A.isEmpty());
        System.out.println(A.contains("hehe"));
        System.out.println(A.get(1));
//        System.out.println(A.size());
//        A.remove("world");
//        System.out.println(A.size());
        String[] s = A.toArrary();
        for(int i = 0; i < s.length;i ++){
            System.out.println(s[i]);
        }
    }
}

class Link4{
    private Node4 root4;
    private int count = 0;
    private int foot = 0;
    private String [] retArrary;  //返回的数组

    public void add4(String data4){
        if(data4 == null){
            return ;
        }
        Node4 newNode4 = new Node4(data4);
        if(this.root4 ==null){
            this.root4 = newNode4;
        }else {
            this.root4.addNode4(newNode4);
        }
        this.count ++;
    }
    public int size(){    //链表大小
        return count;
    }
    public boolean isEmpty(){    //判断链表是否空
        return this.count == 0;
    }
    public boolean contains(String data4){ //查询节点是否存在
        if(data4 == null || this.root4 == null){//判断查询的数据是否为空，或者是根节点是否为空
            return false;
        }else {
            return this.root4.containsNode(data4);
        }
    }

    public String get(int index){
        if(index > count){
            return null;
        }
        this.foot = 0; //从前向后查
        return this.root4.getNode(index);
    }
    public void set(int index, String data4){
        if(this.foot > index){ //如果要修改的位置大于链表的长度，直接return.
            return;
        }else {
            this.root4.setNode(index,data4);
        }
    }
    public String [] toArrary(){
        if(this.root4 ==null){
            return null;
        }
        this.foot = 0;
        this.retArrary = new String[this.count];
        this.root4.toArraryNode();
        return this.retArrary;
    }
    public void remove(String data4){
        if(this.contains(data4)){ //判断数据是否存在
            //
            if(data4.equals(this.root4.data4)){
                this.root4 = this.root4.next4;
            }else {  //如果不是根元素
                this.root4.next4.removeNode(this.root4,data4);
            }
            this.count --;
        }
    }
    private class Node4{
        private String data4;
        private Node4 next4;  //引用关系
        public Node4(String data4){
            this.data4 = data4;
        }
        // 增加节点.
        public void addNode4(Node4 newnode4){
            if(this.next4 == null){
                this.next4 = newnode4;
            }else {
                this.next4.addNode4(newnode4);
            }
        }
        //query node.
        public boolean containsNode(String data4){
            if(data4.equals(this.data4)){
                return true;
            }else {  //继续向下查找.
                if(this.next4 !=null){ //判断后面还有没有Node
                    this.next4.containsNode(data4);
                }else {
                    return false;
                }
            }
            return false;
        };
        public String getNode(int index){
            //使用当前foot的内容与index比较.
            //foot 自增.
            if(Link4.this.foot ++ == index){
               return this.data4;
            }else {  //继续向后查询.
                return this.next4.getNode(index);
            }
        }
        public void setNode(int index,String data4){
            if(Link4.this.foot ++ == index){
                this.data4 = data4;  //修改内容
            }else {
                this.next4.setNode(index,data4);
            }
        }
        public void removeNode(Node4 previous,String data4){
            if(data4.equals(this.data4)){
                previous.next4  = this.next4;
            }else {
                this.next4.removeNode(this,data4);
            }
        }
        //第一次调用(Link):this= Link.root;
        //第二次调用(Node):this= Link.root.next;
        public void toArraryNode(){
            Link4.this.retArrary[Link4.this.foot ++] = this.data4;
            if(this.next4 != null){
                this.next4.toArraryNode();
            }
        }
    }
}
