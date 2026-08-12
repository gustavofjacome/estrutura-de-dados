public class Testes {

    public static void main(String[] args) throws Exception {

        Pilha<String> prato = new Pilha<>(5);

        System.out.println(prato.isEmpty());
        System.out.println(prato.isFull());

        // =================

        prato.push("B");
        prato.push("R");
        prato.push("A");
        prato.push("S");
        prato.push("A");

        System.out.println(prato.isEmpty());
        System.out.println(prato.isFull());

        // =================

        System.out.println(prato.pop());
        System.out.println(prato.pop());
        System.out.println(prato.pop());
        System.out.println(prato.pop());
        System.out.println(prato.pop());

        // =================

        System.out.println(prato.isEmpty());
        System.out.println(prato.isFull());
    }
}