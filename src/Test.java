public class Test {
    public static void main(String[] args) {
        test();//start();
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
        String test = "";
        for (int i = 0; i < 65536; i++) test += Character.toString(i);
        System.out.println(Cryption.un_cryption(Cryption.cryption(test)).equals(test));
    }
}
