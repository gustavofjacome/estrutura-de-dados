public class Testes {
    public static void main(String[] args) {
        Pilha prato = new Pilha(5);

        System.out.println(prato.isEmpty());
        System.out.println(prato.isFull());

        //=================

        prato.push("B");
        prato.push("R");
        prato.push("A");
        prato.push("S");
        prato.push("A");

        System.out.println(prato.isEmpty());
        System.out.println(prato.isFull());


        prato.pop(); // como agora tem exceção vai dar erro de cara
        prato.pop();
        prato.pop();
        prato.pop();
        prato.pop();

        System.out.println(prato.isEmpty());
        System.out.println(prato.isFull());


    }
}
