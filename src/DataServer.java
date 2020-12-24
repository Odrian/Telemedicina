import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class DataServer { // связь с сервером
    public static String login(String login, String psw) {
        String id = "";
        for (String[] lowData : FileScan.fileGet("data/UsersData.txt")) {
            if (login.equals(lowData[0])) {
                if (psw.equals(lowData[1])) id = lowData[2];
                break;
            }
        }
        return id;
    }

    public static String regist(String phone, String psw) {
        String id = "";
        boolean flag = true;
        for (String[] lowData : FileScan.fileGet("data/UsersData.txt")) {
            if (phone.equals(lowData[0])) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            FileScan.fileAdd("data/UsersData.txt", "\n" + phone + "✚" + psw);
            id = "Kate"; // Надо брать с сервера
        }
        return id;
    }

    public static List<String[]> getData (String id) {
        return FileScan.fileGet("data/Chats/" + id + ".txt");
    }

    public static List<String[]> getListMsg(String id) {
        return FileScan.fileGet("data/" + id + "/ChatList.txt");
    }

    public static void sendMsg(String ChatID, String msg, Object[] files) {
        FileScan.fileAdd("data/Chats/" + ChatID + ".txt", msg);
    }

    public static void getImage(String path){
        try (InputStream in = new URL("https://Telemedecina.com/download/file/").openStream()) {
            Path d = Path.of("");
            Files.copy(in, Path.of(""), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Ошибка при скачивании файла: " + path);
            e.printStackTrace();
        }
    }
}
