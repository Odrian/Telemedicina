public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void start(){
        String word = "⋿✚⓬⤺ǝ♎❉♛♦♧✄▇Привет как дела?";
        System.out.println(word);
        word = Cryption.cryption(word);
        System.out.println(word);
        word = Cryption.un_cryption(word);
        System.out.println(word);
    }

    public static void test() {

    }
}
