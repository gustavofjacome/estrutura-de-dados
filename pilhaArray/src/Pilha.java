public class Pilha {
    private int topo;
    private String[] pilha;
    private int size;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new String[capacidade];
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.topo == -1; // -1 é o valor padrao do construtor la em cima se ele ta -1 é pq nao foi alterado, logo ta vazio
    }

    public boolean isFull(){
        return this.topo+1 == pilha.length;
    }

    //adiciona elemento em cima
    public void push(String elemento){
        this.pilha[++topo] = elemento;
        size++;
    }

    //retorna o de cima e remove
    public String pop(){
        String isRemove = this.pilha[topo];
        this.pilha[topo] = " ";
        size--;
        return isRemove;
    }


    //retorna o de cima sem remover
    public String top(){
        return this.pilha[topo];
    }


    public int size(){
        return size;
    }

}
