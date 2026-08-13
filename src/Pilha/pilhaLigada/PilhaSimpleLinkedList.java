package src.Pilha.pilhaLigada;

import src.Pilha.Exception.PilhaVaziaException;
import src.Pilha.Pilha;

public class PilhaSimpleLinkedList implements Pilha {

    public class Node {
        Object data; // dado
        Node next; // ponteiro para o proximo

        public Node() {
            this.data = null;
            this.next = null;
        }
    }

    Node head; // parte de baixo
    Node tail; // parte de cima
    int size;

    public PilhaSimpleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 || this.head == null && this.tail == null; // ta redundante mas deixei assim pq vai que eu esqueço de alterar o size de algum outro metodo que eu fizer depois, mas poderia ser so o size == 0 ou somente a comparação dos ponteiros
    }

    // tirei o metodo Isfull() da interface pq nao fazia sentido para essa classe

    @Override
    public void push(Object object) {
        Node novoObjeto = new Node();
        novoObjeto.data = object;

        if (this.head == null && this.tail == null) {
            this.head = novoObjeto;
            this.tail = novoObjeto;

        } else {
            Node current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = novoObjeto;
            this.tail = novoObjeto;
        }

        size++;
    }

    @Override
    public Object pop() throws PilhaVaziaException {

        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha Vazia");
        }

        Object valor = this.tail.data;

        if (this.head == this.tail) { // se so tem um elemento
            this.head = null;
            this.tail = null;
            size--;
            return valor;
        }

        Node current = this.head;

        while (current.next != this.tail) { // esse arrodeio todo porque nao tem prev e tem que chegar no anterior do ultimo
            current = current.next;
        }

        this.tail = current;
        this.tail.next = null;
        size--;

        return valor;
    }

    @Override
    public Object top() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha Vazia");
        }

        return this.tail.data;
    }

    @Override
    public int size() {
        return size;
    }
}