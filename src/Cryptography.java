import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cryptography {


    public static void main(String[] args) {
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Зашивровать");
            System.out.println("2 - расшифровать");
            System.out.println("3 - EXIT");

            Scanner sca0 = new Scanner(System.in);
            int vibor = sca0.nextInt();
            if (vibor == 1) {
                shifrovka();
            } else if (vibor == 2) {
                deshifrovka();
            } else if (vibor == 3) {
                System.exit(0);
            } else {
                System.out.println("Введите нужное число");
            }
        }
    }

    public static void shifrovka() {

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
        writeUsingFileWriter(data);
    }

    public static void deshifrovka() {
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
        for (String str : list) {
            char[] am = str.toCharArray();
            String stri = new String(am);
            String b = stri.toLowerCase();
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
        writeUsingFileWriter(data);
    }

    private static void writeUsingFileWriter(List<String> data) {

        System.out.println("Введите путь и имя файла куда сохранить результат");
        Scanner save = new Scanner(System.in);
        String saveFile = save.nextLine();
        File file = new File(saveFile);
        FileWriter fr;
        try {
            fr = new FileWriter(file, true);
            for (int i = 0; i < data.size(); i++) {
                fr.write(data.get(i));
            }
            // fr.write(data);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
