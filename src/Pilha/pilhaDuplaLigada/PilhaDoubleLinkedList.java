package src.Pilha.pilhaDuplaLigada;

import src.Pilha.Exception.PilhaVaziaException;
import src.Pilha.Pilha;

public class PilhaDoubleLinkedList implements Pilha {
    public class Node {
        Node prev;
        Object data;
        Node next;

        public Node(){
            this.prev = null;
            this.data = null;
            this.next = null;
        }
    }
        Node tail;
        Node head;
        int size;

        @Override
        public int size() {
            return size;
        }
        @Override
        public boolean isEmpty(){
            return size == 0 || this.head == null && this.tail == null;
        }
        @Override
        public Object top() throws PilhaVaziaException {
            Object last = null;

            if (isEmpty()) {
                throw new PilhaVaziaException("Pilha vazia");
            } else  {
                last = this.tail.data;
            }
            return last;
        }

        @Override
        public void push(Object o) {
            Node novoObjeto = new Node();
            novoObjeto.prev = this.tail;
            novoObjeto.data = o;
            novoObjeto.next = null;

            if (isEmpty()){
                this.head = novoObjeto;
            }
            this.tail = novoObjeto;

            size++;

        }
        @Override
        public Object pop() throws PilhaVaziaException {
            Object last = null;

            if (isEmpty()) {
                throw new PilhaVaziaException("Pilha vazia");
            }

            last = this.tail.data;

            if (this.head == this.tail) { // se so tem um elemento
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }

            size--;

            return last;
        }
}

