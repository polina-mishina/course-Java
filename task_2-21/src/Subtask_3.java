import java.util.Scanner;

public class Subtask_3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String str1 = in.nextLine();

        String[] dateParts = str1.split("\\.");
        String str2 = String.join("-", dateParts[2], dateParts[1], dateParts[0]);
        System.out.print(str2);

        in.close();
    }
}
