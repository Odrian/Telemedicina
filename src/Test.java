public class Test {
    public static void main(String[] args) {
        test();//start();
    }

    public static void start(){
        String word = "⋿✚⓬⤺ǝ♎❉♛♦♧✄▇Привет как дела?";
        System.out.println(word);
        word = Cryption.Cryption(word);
        System.out.println(word);
        word = Cryption.UnCryption(word);
        System.out.println(word);
    }

    public static void test() {
        String test = "";
        for (int i = 0; i < 65536; i++) test += Character.toString(i);
        System.out.println(Cryption.UnCryption(Cryption.Cryption(test)).equals(test));
    }
}
