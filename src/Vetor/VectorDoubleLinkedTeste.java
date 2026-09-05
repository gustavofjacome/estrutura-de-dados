package src.Vetor;

public class VectorDoubleLinkedTeste {

    public static void main(String[] args) {
        System.out.println("Iniciando testes da classe VectorDoubleLinked...\n");

        testeListaVazia();
        testeInsercaoELeitura();
        testeInsercaoNoMeio();
        testeSubstituicao();
        testeRemocao();
        testeOtimizacaoDeBusca();
        testeExcecoes();

        System.out.println("\nTodos os testes finalizados!");
    }

    // --- MÉTODOS DE TESTE ---

    private static void testeListaVazia() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        imprimirResultado("Teste Lista Vazia (isEmpty)", v.isEmpty());
        imprimirResultado("Teste Lista Vazia (size == 0)", v.size() == 0);
    }



    private static void testeInsercaoELeitura() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        v.insertAtRank(0, "A");
        v.insertAtRank(1, "B");
        v.insertAtRank(2, "C");



        boolean sucesso = v.size() == 3 &&
                v.elemAtRank(0).equals("A") &&
                v.elemAtRank(2).equals("C");
        imprimirResultado("Teste Inserção no Fim e Leitura", sucesso);
    }

    private static void testeInsercaoNoMeio() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        v.insertAtRank(0, "Primeiro");
        v.insertAtRank(1, "Ultimo");
        v.insertAtRank(1, "Meio"); // Deve empurrar o "Ultimo" para o rank 2

        boolean sucesso = v.elemAtRank(0).equals("Primeiro") &&
                v.elemAtRank(1).equals("Meio") &&
                v.elemAtRank(2).equals("Ultimo") &&
                v.size() == 3;
        imprimirResultado("Teste Inserção no Meio", sucesso);
    }

    private static void testeSubstituicao() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        v.insertAtRank(0, "Maçã");
        Object antigo = v.replaceAtRank(0, "Banana");

        boolean sucesso = antigo.equals("Maçã") &&
                v.elemAtRank(0).equals("Banana") &&
                v.size() == 1;
        imprimirResultado("Teste Substituição (replaceAtRank)", sucesso);
    }

    private static void testeRemocao() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        v.insertAtRank(0, "X");
        v.insertAtRank(1, "Y");
        v.insertAtRank(2, "Z");

        Object removidoMeio = v.removeAtRank(1); // Remove "Y"

        boolean sucesso = removidoMeio.equals("Y") &&
                v.size() == 2 &&
                v.elemAtRank(1).equals("Z");
        imprimirResultado("Teste Remoção (removeAtRank)", sucesso);
    }

    private static void testeOtimizacaoDeBusca() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        // Inserindo 10 elementos
        for (int i = 0; i < 10; i++) {
            v.insertAtRank(i, "Elemento " + i);
        }

        // Se a busca pelo inicio e pelo fim estiverem corretas,
        // os índices abaixo devem retornar os dados exatos.
        boolean buscaInicio = v.elemAtRank(2).equals("Elemento 2"); // Usa sentinelFirst
        boolean buscaFim = v.elemAtRank(8).equals("Elemento 8");    // Usa sentinelLast

        imprimirResultado("Teste Otimização de Busca O(n/2)", buscaInicio && buscaFim);
    }

    private static void testeExcecoes() {
        VectorDoubleLinked v = new VectorDoubleLinked();
        boolean passouRankNegativo = false;
        boolean passouBuscaInvalida = false;
        boolean passouInsercaoInvalida = false;

        try {
            v.elemAtRank(-1);
        } catch (IndexOutOfBoundsException e) {
            passouRankNegativo = true;
        }

        try {
            v.elemAtRank(0); // Lista vazia, rank 0 não existe para leitura
        } catch (IndexOutOfBoundsException e) {
            passouBuscaInvalida = true;
        }

        try {
            v.insertAtRank(2, "Erro"); // Lista vazia, só pode inserir no 0
        } catch (IndexOutOfBoundsException e) {
            passouInsercaoInvalida = true;
        }

        imprimirResultado("Teste Exceções (Limites do Vetor)",
                passouRankNegativo && passouBuscaInvalida && passouInsercaoInvalida);
    }

    // --- FUNÇÃO AUXILIAR DE IMPRESSÃO ---

    private static void imprimirResultado(String nomeTeste, boolean passou) {
        if (passou) {
            System.out.println("[PASSOU] " + nomeTeste);
        } else {
            System.err.println("[FALHOU] " + nomeTeste);
        }


    }
}