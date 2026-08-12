public class Testes {

    public static void main(String[] args) {

        PilhaArray<String> prato = new PilhaArray<>(5, 2);

        System.out.println(prato.isEmpty());

        prato.push("B");
        prato.push("R");
        prato.push("A");
        prato.push("S");
        prato.push("A");

        System.out.println(prato.isFull());

        System.out.println(prato.pop());
        System.out.println(prato.pop());
        System.out.println(prato.pop());
        System.out.println(prato.pop());
        System.out.println(prato.pop());

        System.out.println(prato.isEmpty());
    }
}
