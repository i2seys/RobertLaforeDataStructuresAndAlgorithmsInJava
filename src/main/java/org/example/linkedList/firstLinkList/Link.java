package org.example.linkedList.firstLinkList;

public class Link {
    private long data;
    private Link next;

    public Link(long data) {
        this.data = data;
    }

    public long getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public void setData(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{data=" + data + '}';
    }
    public void displayLink(){
        System.out.print(this);
    }
}
