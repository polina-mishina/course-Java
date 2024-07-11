import java.text.*;
import java.util.*;

public class Subtask_4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String str1 = in.nextLine();
        SimpleDateFormat ft1 = new SimpleDateFormat ("dd.MM.yyyy");
        SimpleDateFormat ft2 = new SimpleDateFormat ("yyyy-MM-dd");
        Date parsingDate;
        try {
            parsingDate = ft1.parse(str1);
            System.out.print(ft2.format(parsingDate));
        }catch (ParseException e) {
            System.out.print("Нераспаршена с помощью " + ft1);
        }

        in.close();
    }
}
