package org.example.linkedList.firstLinkList;

public class LinkList {
    private Link first;
    public LinkList(){
        first = null;
    }
    public LinkList(Link first){
        this.first = first;
    }

    public Link getFirst() {
        return first;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(long value){
        Link newFirst = new Link(value);
        newFirst.setNext(first);
        first = newFirst;
    }
    public Link deleteFirst(){
        if(isEmpty()){
            System.out.println("List is empty.");
            return null;
        }
        Link temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList(){
        if(isEmpty()){
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Items: ");
        Link temp = first;
        while(temp != null){
            temp.displayLink();
            temp = temp.getNext();
        }
        System.out.println();
    }

    public Link find(int key){
        Link temp = first;
        while(temp != null && temp.getData() != key){
            temp = temp.getNext();
        }
        if(temp == null){
            System.out.println("Element not found.");
            return null;
        }
        else{
            return temp;
        }
    }
    public Link delete(int key){
        //1) найти элемент с ключом и элемент до него
        Link f = first;
        Link prev = first;
        while(f != null && f.getData() != key){
            prev = f;
            f = f.getNext();
        }
        if(f == null){
            System.out.println("Element not found.");
            return null;
        }

        if(f == first){
            first = first.getNext();
        }
        else{
            prev.setNext(f.getNext());
        }
        return f;
    }
}
