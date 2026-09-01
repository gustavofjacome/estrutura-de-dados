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

    Object insertAtRank(){

    }

    boolean aumentarVetor(){
        int novaCapacidade = capacidade*2;
        Object[] novoVetor = new Object[novaCapacidade];

        copiarVetor(vetor, vetor.length, novoVetor);

        vetor = novoVetor;
        capacidade = novaCapacidade;

        return true;
    }

    boolean diminuirVetor(){

        if (vetor[capacidade/2] == null){
            int capacidadeReduzida = capacidade/2;
            Object[] novoVetor = new Object[capacidadeReduzida];

            copiarVetor(vetor, vetor.length, novoVetor);

            vetor = novoVetor;
            capacidade = capacidadeReduzida;

            return true;

        } else {
            return false;
        }



    }

    void copiarVetor(Object[] vetorOrigem, int vetorOrigemSize, Object[] vetorDestino){
        for (int i = 0; i < vetorOrigemSize; i++) {
            vetorOrigem[i] = vetorDestino[i];
        }
    }

}
