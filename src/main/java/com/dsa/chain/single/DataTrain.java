package com.dsa.chain.single;

import java.util.Stack;

/**
 * @Description:单链表操作
 * @Param:
 * @return:
 * @Author: luozhiguo
 * @Date:2019/6/12
 **/
public class DataTrain {
    public DataNode getHead() {
        return head;
    }

    public void setHead(DataNode head) {
        this.head = head;
    }

    private DataNode head;

    public DataTrain(int size){
        head = new DataNode(1);
        DataNode cur = head;
        for(int i=2; i<=size; i++){
            DataNode next = new DataNode(i);
            cur.setNext(next);
            cur = next;
        }
    }
    public DataTrain(char[] chars){
        head = new DataNode(String.valueOf(chars[0]));
        DataNode cur = head;
        for(int i=1; i<chars.length; i++){
            DataNode next = new DataNode(String.valueOf(chars[i]));
            cur.setNext(next);
            cur = next;
        }
    }

    /**
     * @Description:打印链表
     * @Param:head 单链表表头元素
     * @return:void
     * @Author: luozhiguo
     * @Date:2019/6/12
     **/
    public void printTrain(DataNode head){
        StringBuilder buffer = new StringBuilder();
        buffer.append(head.getData());
        DataNode nextNode = head.getNext();
        while(nextNode != null){
            buffer.append("->");
            buffer.append(nextNode.getData());
            nextNode = nextNode.getNext();
        }
        System.out.println(buffer.toString());
    }
    /**
     * @Description: 单链表反转
     * @Param:head
     * @return:com.dsa.chain.single.DataNode
     * @Author: luozhiguo
     * @Date:2019/6/12
     **/
    public DataNode reversed(DataNode head){
        DataNode preNode = head;
        DataNode curNode = head.getNext();
        preNode.setNext(null);
        while(curNode != null){
            DataNode nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
        }
        head = preNode;
        return head;
    }
    /**
     * @Description: 通过快慢指针，查找中间值
     * @Param:dataNode 单链表表头
     * @return:boolean true:是回文,false:不是回文
     * @Author: luozhiguo
     * @Date:2019/6/12
     **/
    public boolean isParlindrome(DataNode dataNode){

        //快指针
        DataNode fastNode = dataNode;
        //慢指针
        DataNode lowNode = dataNode;
        while(fastNode != null && fastNode.getNext() != null){
            fastNode = fastNode.getNext().getNext();
            lowNode = lowNode.getNext();
        }
        fastNode = reversed(lowNode); //从中间位置获取之后 的节点，并且反转
        lowNode = dataNode;              //重置指针
        boolean isParlindrome = true;   //false 不是回文，true是回文
        while(fastNode != null){
            if(!lowNode.getData().equals(fastNode.getData())){
                isParlindrome = false;
                break;
            }
            lowNode = lowNode.getNext();
            fastNode = fastNode.getNext();
        }
        return isParlindrome;
    }

    public static void main(String[] args) {
        //构建单链表
        DataTrain dt = new DataTrain(10);
        //单链表打印
        dt.printTrain(dt.getHead());
        //反转的单链表
        DataNode reversedNode = dt.reversed(dt.getHead());
        //反转后的单链表打印
        dt.printTrain(reversedNode);
        //判断是否是回文字符
        DataTrain dt2 = new DataTrain("levvel".toCharArray());
        System.out.println("是否是回文："+dt2.isParlindrome(dt2.getHead()));

        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<10; i++){
            s.add(new Integer(i));
        }
        Integer val = null;
        while((val = s.pop()) != null){
            System.out.println(val);
        }
    }
}
