public class Pilha {
    private int topo;
    private String[] pilha;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new String[capacidade];
    }
    //TODO: push(), pop, peek, top , is empty, is full, size;

    public boolean isEmpty(){
        return this.topo == -1;
    }


    public void push(String elemento){
        this.pilha[++topo] = elemento;
    }

}
