import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cryption {
    public static String cryption(String text){ // Шифровальшик
        text = expand(text);
        text = Crypt(text, true);
        return text;
    }

    public static String un_cryption(String text){ // Разшивровщик
        text = Crypt(text, false);
        text = expand(text);
        return text;
    }

    private static String expand(String text){ // Переворот слова
        StringBuilder ret = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) ret.append(text.charAt(i));
        return ret.toString();
    }

    private static String Crypt(String text, boolean crypt){ // Шифрование по ключу
        String key = "正长弖䍵怙偼鱾蒤찙퇼ꐩꛣጯ먪?差ꅩ✔厞ļ";
        int keyNum = 0;
        StringBuilder ret = new StringBuilder();
        for (int ch : text.toCharArray()) {
            int d;
            if (crypt) {
                d = ch + key.charAt(keyNum);
                if (d > 65535) d -= 65536;
            } else {
                d = ch - key.charAt(keyNum);
                if (d < 0) d += 65536;
            }
            ret.append((char) d);
            keyNum = (keyNum + 1) % key.length();
        }
        return ret.toString();
    }

    public static String Sha512(String psw){ // Генератор Sha512 хешей
        psw = "salt" + psw;
        String Hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(psw.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            Hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Ошибка при генерацие хеша Sha512");
            e.printStackTrace();
        }
        return Hash;
    }
}
