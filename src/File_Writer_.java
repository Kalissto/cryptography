import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class File_Writer_ {
    protected static void writeUsingFileWriter(List<String> data) {

        System.out.println("Введите путь и имя файла куда сохранить результат");
        Scanner save = new Scanner(System.in);
        String saveFile = save.nextLine();
        File file = new File(saveFile);
        FileWriter fr;
        try {
            fr = new FileWriter(file, true);
            for (String datum : data) {
                fr.write(datum);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
