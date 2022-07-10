import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encrypt {
    public static void encrypt() {

        System.out.println("Введите полный путь к файлу который будете зашифровывать");
        Scanner sca1 = new Scanner(System.in);
        String put = sca1.nextLine();
        Path path = Path.of(put);
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите ключ для шифрования текста от 1-40");
        Scanner sca2 = new Scanner(System.in);
        int key = sca2.nextInt();
        char[] result;
        List<String> data = new ArrayList<>();
        assert list != null;
        for (String str : list) {
            char[] am = str.toCharArray();
            String stri = new String(am);
            String b = stri.toLowerCase();
            char[] strChars = b.toCharArray();
            result = new char[strChars.length];
            String alfa = "абвгдежзийклмнопрстуфхцчшщъыьэюя.,:-!? ";
            char[] chars = alfa.toCharArray();
            for (int i = 0; i < strChars.length; i++) {
                char strChar = strChars[i];
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    if (strChar == ch) {
                        result[i] = chars[(j + key) % chars.length];
                    }
                }
            }
            String s = new String(result);
            data.add(s);
        }
        File_Writer_.writeUsingFileWriter(data);
    }
}
