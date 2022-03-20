package com.company.linkedlist;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyQueue<T>{

    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }

        private QueueNode<T> firstNode;
        private QueueNode<T> lastNode;

        public void add(T item){
            QueueNode<T> t = new QueueNode<>(item);
            if(lastNode != null){
                lastNode.next = t;
            }
            lastNode = t;
            if(firstNode == null)
                firstNode = lastNode;
        }

        public T remove(){
            if(firstNode == null) throw new NoSuchElementException();
            T data = firstNode.data;
            firstNode = firstNode.next;
            if(firstNode == null)
                lastNode = null;
            return data;


        }

        public T peek(){
            if(firstNode == null) throw new NoSuchElementException();
            return firstNode.data;
        }

        public boolean isEmpty(){
            return firstNode == null;
        }

    }
}
