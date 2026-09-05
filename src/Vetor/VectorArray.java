package src.Vetor;

public class VectorArray implements Vector {
    private Object[] vetor;
    private int tamanho;
    private int capacidade;
    private final int capacidadeMinima;


    public int getTamanho() {
        return tamanho;
    }
    public int getCapacidade() {
        return capacidade;
    }

    public VectorArray() {
        this.capacidade = 8;
        this.capacidadeMinima = 8;
        this.vetor = new Object[capacidade];
    }
    public VectorArray(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero");
        }
        this.capacidade = capacidade;
        this.capacidadeMinima = capacidade;
        this.vetor = new Object[capacidade];
    }

    @Override
    public int size(){
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public Object elemAtRank(int rank) {
        validarRank(rank, false);
        return vetor[rank];
    }

    @Override
    public void insertAtRank(int r, Object objeto) {
        validarRank(r, true);

        if (tamanho == capacidade) {
            aumentarVetor();
        }

        deslocarParaDireitaAbreEspaco(r);

        vetor[r] = objeto;
        tamanho++;
    }

    @Override
    public Object replaceAtRank(int r, Object objeto) {
        validarRank(r, false);

        Object elementoSubstituido = vetor[r];
        vetor[r] = objeto;

        return elementoSubstituido;
    }

    @Override
    public Object removeAtRank(int r) {
        validarRank(r,false);

        Object itemRemovido = vetor[r];

        deslocarParaEsquerdaFechaEspaco(r);

        vetor[tamanho - 1] = null;
        tamanho--;

        diminuirVetor();

        return itemRemovido;
    }



    // metodos adicionais e estao privados
    private void aumentarVetor(){
        int novaCapacidade = capacidade*2;
        Object[] novoVetor = new Object[novaCapacidade];

        copiarVetor(novoVetor);

        vetor = novoVetor;
        capacidade = novaCapacidade;
    }

    private void diminuirVetor() {
        if (tamanho < capacidade / 2) {
            int novaCapacidade = capacidade / 2;

            if (novaCapacidade < capacidadeMinima) {
                novaCapacidade = capacidadeMinima;
            }

            Object[] novoVetor = new Object[novaCapacidade];

            copiarVetor(novoVetor);

            vetor = novoVetor;
            capacidade = novaCapacidade;
        }
    }

    private void copiarVetor(Object[] novoVetor){
        for (int i = 0; i < tamanho; i++) {
            novoVetor[i] = vetor[i];
        }
    }

    private void validarRank(int rank, boolean isInsercao) {
        if (isInsercao) {
            if (rank >= 0 && rank <= tamanho) {
                return;
            }
        } else {
            if (rank >= 0 && rank < tamanho) {
                return;
            }
        }

        throw new OutOfBoundsException("Tentou acessar uma posição invalida");
    }

    private void deslocarParaDireitaAbreEspaco(int rank) { // desloca para direita a partir do rank abrindo o espaço vetor[r]
        for (int i = tamanho - 1; i >= rank; i--) {
            vetor[i + 1] = vetor[i];
        }
    }

    private void deslocarParaEsquerdaFechaEspaco(int rank) { // desloca para esquerda para fechar o espaço aberto, é o inverso do metodo anterior
        for (int i = rank; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
    }

}
