package org.example.linkedList.firstLinkList;

public class LinkStack {
    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }
    public void push(long data){
        linkList.insertFirst(data);
    }
    public Link pop(){
        return linkList.deleteFirst();
    }
    public Link peek(){
        return linkList.getFirst();
    }
    public boolean isEmpty(){
        return linkList.isEmpty();
    }
    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        linkList.displayList();
    }
}
