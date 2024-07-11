import java.util.Scanner;

public class Subtask_1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку");
        String str1 = in.nextLine();
        System.out.println("Введите подстроку");
        String str2 = in.nextLine();

        int len = str2.length();
        int index = 0, count = 0;

        while ((index = str1.indexOf(str2, index)) != -1) {
            count++;
            index += len;
        }

        System.out.printf("Подстрока '%s' встречается %d раза", str2, count);

        in.close();
    }
}