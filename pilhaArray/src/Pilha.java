public class Pilha<T> {
    private int topo;
    private T[] pilha;
    private int size;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = (T[]) new Object[capacidade];
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.topo == -1; // -1 é o valor padrao do construtor la em cima se ele ta -1 é pq nao foi alterado, logo ta vazio
    }

    public boolean isFull(){
        return this.topo+1 == pilha.length;
    }

    //adiciona elemento em cima
    public void push(T elemento) throws Exception {
        if (isFull()){
            throw new Exception(new PilhaCheiaException("Pilha Cheia"));
        }
        this.pilha[++topo] = elemento;
        size++;
    }

    //retorna o de cima e remove
    public T pop() throws Exception {
        if (isEmpty()){
            throw new Exception(new PilhaVaziaException("Pilha Vazia"));
        }
        T isRemove = this.pilha[topo];
        this.pilha[topo] = null;
        topo--;
        size--;
        return isRemove;
    }


    //retorna o de cima sem remover
    public T top() throws Exception {
        if (isEmpty()){
            throw new Exception(new PilhaVaziaException("Pilha Vazia"));
        }
        return this.pilha[topo];
    }

    public int size(){
        return size;
    }

}
