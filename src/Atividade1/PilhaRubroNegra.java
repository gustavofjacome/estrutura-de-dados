package src.Atividade1;

import src.Pilha.Exception.PilhaVaziaException;

public class PilhaRubroNegra {
    private Object[] array;
    private int rubroHead;
    private int negraHead;

    public PilhaRubroNegra(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade inicial deve ser maior que zero");
        }
        this.array = new Object[capacidade];
        this.negraHead = -1;
        this.rubroHead = capacidade;
    }
    // getter dos head
    public int getRubroHead() {
        return rubroHead;
    }

    public int getNegraHead() {
        return negraHead;
    }

    //pilha negra que cresce da esquerda para a direita [0 1 2 3 4 5] ------>

    public void pushNegro(Object objeto) {
        verificarAumentoCapacidade();
        this.array[++negraHead] = objeto;
    }

    public Object negroPop() {
        if (negroVazio()) {
            throw new PilhaVaziaException("A Pilha Negra está vazia.");
        }
        Object toRemove = array[negraHead];
        array[negraHead] = null; //nao precisa mas eu gosto de fazer isso
        this.negraHead--;
        verificarReducaoCapacidade();
        return toRemove;
    }

    public Object topNegro() {
        if (negroVazio()) {
            throw new PilhaVaziaException("A Pilha Negra está vazia.");
        }
        return array[negraHead];
    }

    public boolean negroVazio() {
        return this.negraHead == -1;
    }

    public int sizeNegro() {
        return this.negraHead + 1;
    }

    //pilha rubra cresce da direita para esquerda <------- [6 7 8 9]

    public void pushRubro(Object objeto) {
        verificarAumentoCapacidade();
        this.array[--rubroHead] = objeto;
    }

    public Object rubroPop() {
        if (rubroVazio()) {
            throw new PilhaVaziaException("A Pilha Rubra está vazia.");
        }
        Object toRemove = array[rubroHead];
        array[rubroHead] = null;
        this.rubroHead++;
        verificarReducaoCapacidade();
        return toRemove;
    }

    public Object topRubro() {
        if (rubroVazio()) {
            throw new PilhaVaziaException("A Pilha Rubra está vazia.");
        }
        return array[rubroHead];
    }

    public boolean rubroVazio() {
        return this.rubroHead == array.length;
    }

    public int sizeRubro() {
        return array.length - this.rubroHead;
    }

    // tamanhos e redimensionamento do array

    public int sizeTotal() {
        return sizeNegro() + sizeRubro();
    }

    public void verificarAumentoCapacidade() {
        if (this.negraHead + 1 == this.rubroHead) {
            redimensionar(array.length * 2);
        }
    }

    public void verificarReducaoCapacidade() {
        if (sizeTotal() > 0 && sizeTotal() <= array.length / 3) {
            redimensionar(array.length / 2);
        }
    }

    public void redimensionar(int novaCapacidade) {
        Object[] novoArray = new Object[novaCapacidade];

        for (int i = 0; i <= this.negraHead; i++) {
            novoArray[i] = this.array[i];
        }

        int novoRubroHead = novaCapacidade;
        for (int i = array.length - 1; i >= this.rubroHead; i--) {
            novoArray[--novoRubroHead] = this.array[i];
        }

        this.array = novoArray;
        this.rubroHead = novoRubroHead;
    }
}