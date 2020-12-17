import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileScan { // Чтение-запись данных на устройтве
    public static List<String[]> fileGet(String path){ // пустышка
        List<String[]> UsersData = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            int ch;
            String temp1 = "";
            while((ch = fr.read())!=-1){
                temp1 += String.valueOf((char) ch);
            }
            fr.close();
            String[] temp2 = temp1.split(",");
            for  (int i = 0; i < temp2.length; i++) {
                UsersData.add(temp2[i].split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return UsersData;
    }

    public static void fileAdd(String path, String text) {
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
