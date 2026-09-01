package src.Fila.FilaLigada;



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

    public FilaSimpleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(Object objetoRecebido) {
        Node novoNode = new Node();
        novoNode.setData(objetoRecebido);

        if (isEmpty()) {
            this.head = novoNode;
            this.tail = novoNode;
        } else {
            this.tail.setNext(novoNode);
            this.tail = novoNode;
        }
        this.size++;
    }

    public Object pop() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("Fila Vazia");
        }
        Object toRemove = this.head.getData();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        size--;
        return toRemove;
    }

    public Object top() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("Fila Vazia");
        }
        return this.head.getData();
    }

    public int size() {
        return this.size;
    }
}