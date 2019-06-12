package com.dsa.chain.single;

public class DataNode {

    private String data;
    private DataNode next;

    public DataNode(String data){
        this.data = data;
    }
    public DataNode(int data){
         this.data = String.valueOf(data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }
}
