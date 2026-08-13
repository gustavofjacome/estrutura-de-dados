package src.Pilha;

import src.Pilha.Exception.PilhaVaziaException;

public interface Pilha {
    public int size();
    public boolean isEmpty();
    public Object top() throws PilhaVaziaException;
    public void push(Object o);
    public Object pop() throws PilhaVaziaException;
}
