package org.example.linkedList.doublyLinkedList;

import org.example.linkedList.firstLastLink.Link;

public class DoublyLinkedList {
    private DoublyLink first;
    private DoublyLink last;

    public DoublyLinkedList() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    //удаление по ключу
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty.");
        }
        DoublyLink l = first;
        System.out.print("Items forward: {");
        while (l != null) {
            System.out.print(l + " ");
            l = l.getNext();
        }
        System.out.println("}");
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty.");
        }
        DoublyLink l = last;
        System.out.print("Items backward: {");
        while (l != null) {
            System.out.print(l + " ");
            l = l.getPrev();
        }
        System.out.println("}");
    }

    public void insertFirst(long value) {
        DoublyLink link = new DoublyLink(value);
        if (isEmpty()) {
            first = link;
            last = link;
        } else {
            //вставляем перед first
            first.setPrev(link);
            link.setNext(first);
            first = link;
        }
    }

    public void insertLast(long value) {
        DoublyLink link = new DoublyLink(value);
        if (isEmpty()) {
            first = link;
            last = link;
        } else {
            link.setPrev(last);
            last.setNext(link);
            last = link;
        }
    }

    public boolean insertAfter(long key, long value) {
        DoublyLink left = first;
        while (left != null && left.getValue() != key) {
            left = left.getNext();
        }
        if (left == null) {
            System.out.println("Key not found.");
            return false;
        }
        //если попали сюда, то нашли ключ
        //вставляем новый линк после этого
        DoublyLink right = left.getNext();
        DoublyLink ins = new DoublyLink(value);
        left.setNext(ins);
        if (right != null) {
            right.setPrev(ins);
        }
        else{
            last = ins;
        }
        ins.setPrev(left);
        ins.setNext(right);
        return true;
    }

    public long deleteLast() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List is empty.");
        }
        long res = last.getValue();
        //проверка на содержание в списке только одного элемента
        if (last.getPrev() == null) {
            last = null;
            first = null;
            return res;
        }
        else {
            last = last.getPrev();
            last.setNext(null);
            return res;
        }
    }

    public long deleteFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List is empty.");
        }
        long res = first.getValue();

        //проверка на содержание в списке только одного элемента
        if(first.getNext() == null){
            last = null;
            first = null;
            return res;
        }
        else{
            first = first.getNext();
            first.setPrev(null);
            return res;
        }
    }
    public boolean delete(long key){
        DoublyLink link = first;
        while(link != null && link.getValue() != key){
            link = link.getNext();
        }

        if(link == null){
            System.out.println("Element not found.");
            return false;
        }

        DoublyLink left = link.getPrev();
        DoublyLink right = link.getNext();

        if(left != null){
            left.setNext(right);
        }
        else{
            //это значит, что элемент, который мы удаляем - первый
            first = right;
        }
        if(right != null){
            right.setPrev(left);
        }
        else{
            //это значит, что элемент, который мы удаляем - последний
            last = left;
        }

        return true;
    }
}