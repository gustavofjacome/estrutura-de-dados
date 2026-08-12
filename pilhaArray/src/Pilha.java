public interface Pilha {
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public Object top() throws PilhaVaziaException;
    public void push(Object o);
    public Object pop() throws PilhaVaziaException;
}
