import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileScan { // Чтение-запись данных на устройтве
    public static List<String[]> fileGet(String path){
        List<String[]> UsersData = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null) {
                UsersData.add(line.split("✚"));
                line = br.readLine();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
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
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
