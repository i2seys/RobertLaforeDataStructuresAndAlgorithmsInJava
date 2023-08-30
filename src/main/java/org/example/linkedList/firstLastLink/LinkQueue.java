package org.example.linkedList.firstLastLink;

public class LinkQueue {
    private final FirstLastList order;

    public LinkQueue() {
        order = new FirstLastList();
    }
    public boolean isEmpty(){
        return order.isEmpty();
    }
    public void insert(long dd){
        order.insertLast(dd);
    }
    public long remove(){
        return order.deleteFirst();
    }
    public long front(){
        return order.getLast();
    }
    public void display(){
        order.displayList();
    }
}
