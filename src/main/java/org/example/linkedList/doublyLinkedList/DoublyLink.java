package org.example.linkedList.doublyLinkedList;

import java.net.DatagramPacket;

public class DoublyLink {
    private long value;
    private DoublyLink prev;
    private DoublyLink next;

    public DoublyLink(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public DoublyLink getPrev() {
        return prev;
    }

    public DoublyLink getNext() {
        return next;
    }

    public void setPrev(DoublyLink prev) {
        this.prev = prev;
    }

    public void setNext(DoublyLink next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }
}
