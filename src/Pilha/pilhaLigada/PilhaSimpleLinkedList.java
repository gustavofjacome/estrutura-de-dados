package src.Pilha.pilhaLigada;

import src.Pilha.Exception.PilhaVaziaException;
import src.Pilha.Pilha;

public class PilhaSimpleLinkedList implements Pilha {

    public class Node {
        private Object data; // dado
        private Node next; // ponteiro para o proximo

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public PilhaSimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // tirei o metodo Isfull() da interface pq nao fazia sentido para essa classe

    @Override
    public void push(Object objetoRecebido) {
        Node novoObjeto = new Node();
        novoObjeto.setData(objetoRecebido);
        novoObjeto.setNext(this.head);
        this.head = novoObjeto;
        size++;
    }

    @Override
    public Object pop() throws PilhaVaziaException {

        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha Vazia");
        }

        Object toRemove = this.head.getData();
        this.head = this.head.getNext();
        size--;
        return toRemove;
    }

    @Override
    public Object top() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha Vazia");
        }
        return this.head.getData();
    }

    @Override
    public int size() {
        return size;
    }
}