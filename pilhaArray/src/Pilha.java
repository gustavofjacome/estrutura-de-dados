public class Pilha {
    private int topo;
    private String[] pilha;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new String[capacidade];
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo+1 == pilha.length;
    }

    public void push(String elemento){
        this.pilha[++topo] = elemento;
    }

    public String pop(){
        String isRemove = this.pilha[topo];
        this.pilha[topo] = " ";
        return isRemove;
    }

    public String top(){
        return this.pilha[topo];
    }

}
