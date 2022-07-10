
import java.util.Scanner;

public class Cryptography {

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Зашивровать");
            System.out.println("2 - расшифровать");
            System.out.println("3 - EXIT");

            Scanner scanner = new Scanner(System.in);
            int vibor = scanner.nextInt();
            switch (vibor) {
                case (1) -> Encrypt.encrypt();
                case (2) -> Decipher.decipher();
                case (3) -> System.exit(0);
                default -> {
                    System.out.println("Введено не допустимое значение!");
                    Thread.sleep(1000);
                }
            }
            }
        }






}
