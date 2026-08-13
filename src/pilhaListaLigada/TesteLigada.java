package src.pilhaListaLigada;

import src.Pilha;

public class TesteLigada {

    public static void main(String[] args) throws Exception {

        Pilha pilha = new PilhaSimpleLinkedList();

        System.out.println("Vazia: " + pilha.isEmpty());

        pilha.push("A");
        pilha.push("B");
        pilha.push("C");

        System.out.println("Tamanho: " + pilha.size());
        System.out.println("Topo: " + pilha.top());

        System.out.println("Pop: " + pilha.pop());
        System.out.println("Topo: " + pilha.top());

        System.out.println("Pop: " + pilha.pop());
        System.out.println("Topo: " + pilha.top());

        System.out.println("Pop: " + pilha.pop());

        System.out.println("Vazia: " + pilha.isEmpty());
        System.out.println("Tamanho: " + pilha.size());
    }
}