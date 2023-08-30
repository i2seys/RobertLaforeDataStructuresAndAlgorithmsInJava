package org.example.linkedList;

import org.example.linkedList.firstLastLink.Link;

import java.sql.SQLOutput;

public class SortedLink {
    //
    private Link first;

    public SortedLink(){
    }
    public SortedLink(long[] array){
        for(int i = 0; i < array.length; i++){
            insert(array[i]);
        }
    }

    public boolean isEmpty(){
        return first == null;
    }
    public void insert(long data){
        if(isEmpty()){
            first = new Link(data);
        }
        else{
            //ищем куда вставить
            Link current = first;
            Link prev = null;
            while(current != null && current.getValue() < data){
                prev = current;
                current = current.getNext();
            }
            if(prev == null){
                //то наш элемент вставляется в самое начало
                Link l = new Link(data);
                l.setNext(first);
                first = l;
            }
            else if(current == null){
                //то мы в самом конце списка
                prev.setNext(new Link(data));
            }
            else{
                Link l = new Link(data);
                l.setNext(current);
                prev.setNext(l);
            }
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Empty list.");
            return;
        }
        System.out.print("Items: {");
        Link current = first;
        while(current != null){
            System.out.print(current + " ");
            current = current.getNext();
        }
        System.out.println("}");
    }

    public boolean remove(long data){
        Link current = first;
        Link prev = null;
        while(current != null && current.getValue() < data){
            prev = current;
            current = current.getNext();
        }

        if(current == null){
            System.out.println("Element not found.");
            return false;
        }
        //то в списке только 1 элемент, либо в current уже хранится наша ячейка
        if(prev == null && current.getValue() == data){
            first = first.getNext();
            return true;
        }
        else if(current.getValue() == data){
            prev.setNext(current.getNext());
            return true;
        }
        else{
            System.out.println("Element not found.");
            return false;
        }
    }
    public long poll(){
        long val = first.getValue();
        first = first.getNext();
        return val;
    }
    public long peek(){
        return first.getValue();
    }
}
