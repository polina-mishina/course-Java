import java.util.Scanner;

public class Subtask_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку");
        String str1 = in.nextLine();
        final String REPLACEMENT = "вырезано цензурой";

        String str2 = str1.replace("кака", REPLACEMENT).replace("бяка", REPLACEMENT);
        System.out.print(str2);

        in.close();
    }
}
