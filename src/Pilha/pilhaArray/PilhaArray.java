package src.Pilha.pilhaArray;

import src.Pilha.Pilha;
import src.Pilha.Exception.PilhaVaziaException;

public class PilhaArray<T> implements Pilha {
    private int capacity;
    private Object[] a;
    private int head;
    private int fc; // fator de crescimento quando encher vai ser usado para aumentar a capacidade

    public PilhaArray(int capacidade, int fatorCrescimento) {
        this.capacity = capacidade;
        head = -1;
        this.fc = fatorCrescimento;
        if (fatorCrescimento <= 0){
            fc = 0;
        }
        a = new Object[capacidade];
    }
    @Override
    public boolean isEmpty(){
        return this.head == -1; // -1 é o valor padrao do construtor la em cima se ele ta -1 é pq nao foi alterado, logo ta vazio
    }

    public boolean isFull(){
        return this.head+1 == a.length;
    }

    @Override
    public int size(){
        return this.head+1;
    }

    //adiciona elemento em cima
    @Override
    public void push(Object objeto) {
        if (increaseCapacity()){
            Object[] b = new Object[capacity];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            this.a = b;
        }
        this.a[++head] = objeto;
    }

    //retorna o de cima e remove
    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha Vazia");
        }
        Object isRemove = a[head];
        a[head] = null;
        head--;
        return isRemove;
    }

    //retorna o de cima sem remover
    public Object top() {
        if (isEmpty()) {
            throw new PilhaVaziaException("Pilha Vazia");
        }
        return this.a[head];
    }

    public boolean increaseCapacity() {
        if (isFull()){
            if (fc == 0) {
                capacity *= 2;
            } else {
                capacity += fc;
            }
            return true;
        }
        return false;
    }


}
