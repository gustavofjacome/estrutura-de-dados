package src.Vetor;

public class Vector {
    private Object[] vetor;
    private int tamanho;
    private int capacidade;

    public Object[] getVetor() {
        return vetor;
    }
    public void setVetor(Object[] vetor) {
        this.vetor = vetor;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public Vector() {
        this.capacidade = 8;
    }
    public Vector(int capacidade) {
        this.capacidade = capacidade;
    }
    int size(){
        return tamanho;
    }

    boolean isEmpty() {
        return tamanho == 0;
    }

    Object elemAtRank(int rank){
        if (rank >= 0 && rank <= tamanho){
            return vetor[rank];
        } else {
            throw new OutOfBoundsException("Você tentou acessar uma área que não existe");
        }
    }

    void insertAtRank(int r, Object objeto){
        for (int i = this.tamanho-1; i >= r; i--) {
            vetor[i+1] = vetor[i];
        }
        vetor[r] = objeto;
    }

    Object replaceAtRank(int r, Object objeto){
        Object elementoSubstituido;
        elementoSubstituido = vetor[r];
        vetor[r] = objeto;
        return elementoSubstituido;
    }

    Object removeAtRank(int r, Object objeto){
        Object itemRemovido;
        itemRemovido = vetor[r];
        for (int i = r; i < vetor.length; i++) {
            vetor[r] = vetor[r+1];
        }
        return itemRemovido;
    }

    boolean aumentarVetor(){
        int novaCapacidade = capacidade*2;
        Object[] novoVetor = new Object[novaCapacidade];

        copiarVetor(novoVetor);

        vetor = novoVetor;
        capacidade = novaCapacidade;

        return true;
    }

    boolean diminuirVetor(){
        if (tamanho < capacidade/2){ 
            int capacidadeReduzida = capacidade/2; // pega a capacidade atual e divide pela metade
            Object[] novoVetor = new Object[capacidadeReduzida];

            copiarVetor(novoVetor); //copia do antigo para o novo
            
            // att valores
            vetor = novoVetor;
            capacidade = capacidadeReduzida;

            return true;
        } else {
            return false;
        }
    }

    void copiarVetor(Object[] novoVetor){
        for (int i = 0; i < tamanho; i++) {
            novoVetor[i] = vetor[i];
        }
    }

}
