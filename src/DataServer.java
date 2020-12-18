import java.util.List;

public class DataServer { // связь с сервером
    public static String login(String login, String psw) {
        String id = "";
        for (String[] lowData : FileScan.fileGet("data/UsersData.txt")) {
            if (login.equals(lowData[0])) {
                if (psw.equals(lowData[1])) id = "adrian"; // Надо брать с сервера
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
            id = "adrian"; // Надо брать с сервера
        }
        return id;
    }

    public static List<String[]> getData (String id) {
        return FileScan.fileGet("data/Chats/" + id + "_.txt");
    }

    public static List<String[]> getListMsg(String id) {
        return FileScan.fileGet("data/Chats/" + id + ".txt");
    }

    public static void sendMsg(String id, String msg, Object[] files) {
        FileScan.fileAdd("data/Chats/" + id + "_.txt", msg);
    }
}
