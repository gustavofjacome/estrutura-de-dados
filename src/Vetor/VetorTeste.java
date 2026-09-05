package src.Vetor;

public class VetorTeste {

    public static void main(String[] args) {
        System.out.println("=== Testando Implementação com Array ===");
        Vector vetorArray = new VectorArray();
        executarTestesBasicos(vetorArray);

        System.out.println("\n=== Testando Implementação com Lista Duplamente Encadeada ===");
        Vector vetorLinked = new VectorDoubleLinked();
        executarTestesBasicos(vetorLinked);
    }

    private static void executarTestesBasicos(Vector v) {
        System.out.println("1. Vetor está vazio? " + v.isEmpty());

        v.insertAtRank(0, "Elemento 1");
        v.insertAtRank(1, "Elemento 2");
        v.insertAtRank(2, "Elemento 3");

        System.out.println("2. Tamanho após 3 inserções: " + v.size());
        System.out.println("3. Elemento no rank 1: " + v.elemAtRank(1));

        v.replaceAtRank(1, "Elemento Modificado");
        System.out.println("4. Elemento no rank 1 após substituição: " + v.elemAtRank(1));

        Object removido = v.removeAtRank(0);
        System.out.println("5. Elemento removido do rank 0: " + removido);
        System.out.println("6. Novo elemento no rank 0: " + v.elemAtRank(0));
        System.out.println("7. Tamanho final: " + v.size());
    }
}