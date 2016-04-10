package Object;

import sun.plugin.navig.motif.OJIPlugin;

/**
 * 利用Object修改可用链表.Object可以接收一切数据类型.包括数组和接口.
 * toString 在对象输出时调用，equals在对象比较时调用.
 * Created by zeng on 16-4-10.
 */
public class TestSix {
    public static void main(String[] args) {
        Link l = new Link();
        l.add("hehe");
        l.add("he");
        l.add("haha");
        l.add("haha");
        l.add("haha");
        l.add("haha");
        l.add("haha");
        l.add("haha");
        l.add("ha");
        Object[] data = l.toArrary();
        for(int i = 0; i <data.length; i++){
            String str = (String)data[i];  //向下转型.
            System.out.println(str);
        }
    }
}

class Link {
    private Node head;
    private Object[] ret;//Object类数组
    private int foot = 0;
    private int count = 0;

    public void add(Object data) {
        if (data == null) {
            return;
        }
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.head.addNode(newNode);
        }
        count++;
    }

    public Object[] toArrary() {
        if (this.head == null) {
            return null;
        }
        this.foot = 0;
        this.ret = new Object[this.count];
        this.head.toArrayNode();
        return this.ret;
    }

    private class Node {
        private Object data;
        private Node next; //引用关系.

        public Node(Object data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode() {
            Link.this.ret[Link.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();

            }
        }
    }
}
