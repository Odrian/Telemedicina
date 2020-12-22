public class Test {
    public static void main(String[] args) {
        sha512();
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

    public static void sha512(){
        System.out.println(Cryption.Sha512("words"));
        System.out.println("d6e88c0055d8d1feec9e09674d7411445b7a4150d17b88259133c23a570b347dccdaac049f39fa13ae51041355885b38344bc4630f8e225ded033ceac6c61486");
    }
}
