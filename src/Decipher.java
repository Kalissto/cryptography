import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decipher {
    public static void decipher() {
        String alfa = "абвгдежзийклмнопрстуфхцчшщъыьэюя.,:-!? ";
        char[] chars = alfa.toCharArray();
        System.out.println("Введите полный путь к файлу который нужно расшифровать");
        Scanner sca1 = new Scanner(System.in);
        String put = sca1.nextLine();
        Path path = Path.of(put);
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите ключ для расшифровки");
        Scanner sca2 = new Scanner(System.in);
        int key = sca2.nextInt();
        List<String> data = new ArrayList<>();
        assert list != null;
        for (String str : list) {
            char[] am = str.toCharArray();
            String string = new String(am);
            String b = string.toLowerCase();
            char[] strChars = b.toCharArray();
            char[] result = new char[strChars.length];
            int keyb = chars.length - key;
            for (int i = 0; i < strChars.length; i++) {
                char strChar = strChars[i];
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    if (strChar == ch) {
                        result[i] = chars[(j + keyb) % chars.length];
                    }
                }
            }
            String g = new String(result);
            data.add(g);
        }
        File_Writer_.writeUsingFileWriter(data);
    }
}
