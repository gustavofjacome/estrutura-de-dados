package src.Fila.FilaLigada;

import src.Pilha.Exception.FilaVaziaException;
import src.Pilha.Pilha;
import src.Pilha.pilhaLigada.PilhaSimpleLinkedList;

public class FilaSimpleLinkedList {

    public class Node {
        private Object data;
        private Node next;

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
        private Node tail;
        private int size;

     public FilaSimpleLinkedList(){
         this.head = null;
         this.tail = null;
         this.size = 0;
     }

     public boolean isEmpty(){
         return this.size == 0;
     }

     public void push(Object objetoRecebido){
         if (isEmpty()) {
             this.head.setData(objetoRecebido);
         }

         Node novoObjeto = new Node();
         novoObjeto.setData(objetoRecebido);
         this.tail.next = novoObjeto;

         this.tail = novoObjeto;
         this.size++;
        }

     public Object pop() throws FilaVaziaException {
         if (isEmpty()) {
             throw new FilaVaziaException("Fila Vazia");
         }

         Object toRemove = this.head.getData();
         this.head = this.head.getNext();
         size--;
         return toRemove;
     }

     public Object top() throws  FilaVaziaException {
         if (isEmpty()) {
             throw new FilaVaziaException("Fila Vazia");
         }
         return this.head.getData();
     }

     public int size(){
         return this.size;
     }



}
