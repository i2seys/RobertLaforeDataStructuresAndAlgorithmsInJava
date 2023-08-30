package org.example.linkedList.firstLinkList;

public class LinkListIterator {
    private LinkList linkList;
    private Link current;
    private Link prev;

    public LinkListIterator(LinkList linkList) {
        this.linkList = linkList;
        current = linkList.getFirst();
        prev = null;
    }
    public void reset(){
        current = linkList.getFirst();
        prev = null;
    }
    public void nextLink(){
        prev = current;
        current = current.getNext();
    }
    public long getCurrent(){
        return current.getData();
    }
    public boolean atEnd(){
        return current.getNext() == null;
    }
    //insertAfter() — вставка нового элемента после итератора.
    public void insertAfter(long value){
        if(linkList.isEmpty()){
            linkList.insertFirst(value);
            current = linkList.getFirst();
        }
        else{
            Link next = current.getNext();
            Link newLink = new Link(value);
            current.setNext(newLink);
            newLink.setNext(next);
            nextLink();
        }
    }
    //insertBefore() — вставка нового элемента перед итератором.
    public void insertBefore(long value){
        if(prev == null){
            //если в начале списка или пустой
            linkList.insertFirst(value);
            reset();
        }
        else{
            Link l = new Link(value);
            l.setNext(prev.getNext());
            prev.setNext(l);
            current = l;
        }
    }

    public long deleteCurrent(){
        long value = current.getData();
        if(prev == null){
            // Если в начале списка
            linkList.insertFirst(current.getNext().getData());
            reset();
        }
        else {
            // Не в начале списка
            prev.setNext(current.getNext());
            if(atEnd())
                reset();
            else
                current = current.getNext();
        }
        return value;
    }
    public void display(){
        Link curr = current;
        reset();
        while(!atEnd()){
            System.out.print(current + " ");
            nextLink();
        }
        if(current != null){
            System.out.print(current);
        }
        System.out.println();
        current = curr;
    }
}
