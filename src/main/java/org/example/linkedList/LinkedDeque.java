package org.example.linkedList;

import org.example.linkedList.firstLastLink.FirstLastList;

public class LinkedDeque {
    /*
    * empty — проверка на наличие элементов,
    pushBack (запись в конец) — операция вставки нового элемента в конец,
    popBack (снятие с конца) — операция удаления конечного элемента,
    pushFront (запись в начало) — операция вставки нового элемента в начало,
    popFront (снятие с начала) — операция удаления начального элемента.
    * */
    private final FirstLastList list;
    public LinkedDeque(){
        list = new FirstLastList();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void pushBack(long value){
        list.insertLast(value);
    }
    public long popBack(){
        return list.deleteLast();
    }
    public void pushFront(long value){
        list.insertFirst(value);
    }
    public long popFront(){
        return list.deleteFirst();
    }
    public void display(){
        list.displayList();
    }
}
