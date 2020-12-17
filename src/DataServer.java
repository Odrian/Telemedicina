import java.util.List;

public class DataServer { // связь с сервером

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
