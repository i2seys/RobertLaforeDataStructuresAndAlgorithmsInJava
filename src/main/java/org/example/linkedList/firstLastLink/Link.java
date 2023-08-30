package org.example.linkedList.firstLastLink;

public class Link {
    private long value;
    private Link next;

    public Link(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Link{" +
                "value=" + value +
                '}';
    }
}
