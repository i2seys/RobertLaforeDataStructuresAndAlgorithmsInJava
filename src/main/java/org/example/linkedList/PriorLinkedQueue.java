package org.example.linkedList;


//Реализуйте приоритетную очередь на базе сортированного связанного
//списка. Операция извлечения из приоритетной очереди должна извлекать элемент
//с наименьшим ключом.

import org.example.linkedList.firstLastLink.Link;
import java.util.Queue;

public class PriorLinkedQueue{
    private final SortedLink sortedLink;
    //add() - Inserts the specified element into the queue. ...
    //offer() - Inserts the specified element into the queue. ...
    //element() - Returns the head of the queue. ...
    //peek() - Returns the head of the queue. ...
    //remove() - Returns and removes the head of the queue. ...
    //poll() - Returns and removes the head of the queue.
    public PriorLinkedQueue(){
        sortedLink = new SortedLink();
    }


    public boolean isEmpty() {
        return sortedLink.isEmpty();
    }

    public void add(long o) {
        //вставка элемента
        sortedLink.insert(o);
    }

    /**
     * Возврат числа с наименьшим приоритетом без удаления
     */
    public long peek() {
        return sortedLink.peek();
    }

    /**
     * Возврат числа с наименьшим приоритетом с удалением
     */
    public long poll() {
        return sortedLink.poll();
    }
    public boolean remove(long key){
        return sortedLink.remove(key);
    }
    public void display(){
        sortedLink.display();
    }
}
