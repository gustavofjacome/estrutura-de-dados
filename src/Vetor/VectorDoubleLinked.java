package src.Vetor;

public class VectorDoubleLinked implements Vector {
    private class Node {
        Node prev;
        Object data;
        Node next;

        public Node() {
            this.prev = null;
            this.data = null;
            this.next = null;
        }
    }

    private Node sentinelFirst;
    private Node sentinelLast;
    private int size;

    public VectorDoubleLinked() {
        sentinelFirst = new Node();
        sentinelLast = new Node();

        sentinelFirst.next = sentinelLast;
        sentinelLast.prev = sentinelFirst;
        size = 0;
    }

    // metodos auxiliares, estao privados

    private void checkRank(int r, boolean isInsercao) { // para evitar de existir dois metodos precisei unificar e passar um boolean como poarametro
        int limite;
        if (isInsercao) {
            limite = size;     // quando vou inserir eu posso ir até o tamanho maximo pois eu posso inserir apos o ultimo elemento
        } else {
            limite = size - 1; // agora quando vou buscar ou remover eu preciso ir até o ultimo valido
        }
        if (r < 0 || r > limite) {
            throw new IndexOutOfBoundsException("tentou acessar uma area de memoria que nao existe");
        }
    }

    private void adicionaEntre(Object o, Node anterior, Node proximo) { // adiciona entre dois node que eu ja conheço
        Node novoElemento = new Node();
        novoElemento.data = o;

        novoElemento.prev = anterior;
        novoElemento.next = proximo;

        anterior.next = novoElemento;
        proximo.prev = novoElemento;

        size++;
    }

    private Object removeNode(Node node) {
        Node anterior = node.prev;
        Node proximo = node.next;

        anterior.next = proximo;
        proximo.prev = anterior;

        size--;
        return node.data;
    }

    private Node encontraElementoPeloSentinelFirst(int posicao) {
        Node current = sentinelFirst.next;
        for (int i = 0; i < posicao; i++) {
            current = current.next;
        }
        return current;
    }

    private Node encontraElementoPeloSentinelLast(int posicao) {
        Node current = sentinelLast.prev;
        for (int i = size - 1; i > posicao; i--) {
            current = current.prev;
        }
        return current;
    }

    private Node encontraNodePeloRank(int r) {
        checkRank(r,false);

        if (r < size / 2) {
            return encontraElementoPeloSentinelFirst(r);
        } else {
            return encontraElementoPeloSentinelLast(r);
        }
    }


    // metodos do vetor
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // Lógica corrigida usando apenas o tamanho
    }

    @Override
    public void insertAtRank(int r, Object o) {
        checkRank(r,true);

        if (r == size) {
            adicionaEntre(o, sentinelLast.prev, sentinelLast);
        } else {
            Node current = encontraNodePeloRank(r);
            adicionaEntre(o, current.prev, current);
        }
    }

    @Override
    public Object removeAtRank(int r) {
        Node toRemove = encontraNodePeloRank(r);
        return removeNode(toRemove);
    }

    @Override
    public Object elemAtRank(int r) {
        Node elemento = encontraNodePeloRank(r);
        return elemento.data;
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Node current = encontraNodePeloRank(r);
        Object antigo = current.data;
        current.data = o;
        return antigo;
    }
}