package org.example.linkedList.firstLastLink;



public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(long dd){
        Link newLink = new Link(dd); // Создание нового элемента
        if( isEmpty() ) // Если список пуст,
            last = newLink; // newLink <-- last
        newLink.setNext(first); // newLink --> старое значение first
        first = newLink;
    }

    public void insertLast(long dd){
        if(isEmpty()){
            insertFirst(dd);
        }
        else{
            Link newLast = new Link(dd);
            last.setNext(newLast);
            last = last.getNext();
        }
    }
    public long deleteFirst(){
        if(isEmpty()){
            System.out.println("List is empty.");
            throw new ArrayIndexOutOfBoundsException("List is empty.");
        }
        else if(first.getNext() == null){
            //если 1 элемент
            long res = first.getValue();
            first = null;
            last = null;
            return res;
        }
        else{
            long res = first.getValue();
            first = first.getNext();
            return res;
        }
    }
    public void displayList(){
        if(isEmpty()){
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List: ");
        Link next = first;
        while(next != null){
            System.out.print(next + " | ");
            next = next.getNext();
        }
        System.out.println();
    }

    public long getLast(){
        return last.getValue();
    }

    public long deleteLast(){
        if(isEmpty()){
            System.out.println("List is empty.");
            throw new ArrayIndexOutOfBoundsException("List is empty.");
        }
        Link current = first;
        if(current == last){
            long val = current.getValue();
            first = null;
            last = null;
            return val;
        }
        else{
            while(current.getNext() != last){
                current = current.getNext();
            }
            long val = current.getNext().getValue();
            current.setNext(null);
            return val;
        }
    }
}
