import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите дату в формате dd.MM.yyyy");
        String str1 = in.nextLine();
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
        Date parsingDate1;
        try {
            parsingDate1 = ft.parse(str1);
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
        GregorianCalendar date1 = new GregorianCalendar();

        date1.setTime(parsingDate1);
        date1.add(Calendar.DATE, 45);
        System.out.println("Дата после увеличения на 45 дней: " + ft.format(date1.getTime()));

        date1.setTime(parsingDate1);
        date1.set(date1.get(Calendar.YEAR), Calendar.JANUARY, 1);
        System.out.println("Дата после сдвига на начало года: " + ft.format(date1.getTime()));

        date1.setTime(parsingDate1);
        int count = 0, dayOfWeek;
        while (count < 10) {
            date1.add(Calendar.DATE, 1);
            dayOfWeek = date1.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek < 6)
                count++;
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + ft.format(date1.getTime()));

        System.out.println("Введите дату в формате dd.MM.yyyy");
        String str2 = in.nextLine();
        Date parsingDate2;
        try {
            parsingDate2 = ft.parse(str2);
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(parsingDate2);
        long difference = parsingDate1.getTime() - parsingDate2.getTime();
        int days = (int)(difference / (24 * 60 * 60 * 1000));
        int fullWeeks = days / 7;
        int partialWeekAdjustment = Math.min(
                6, date1.get(Calendar.DAY_OF_WEEK)) -  Math.min(6, date2.get(Calendar.DAY_OF_WEEK)
        );
        if (partialWeekAdjustment < 0)
            partialWeekAdjustment += 5;
        System.out.println(
                "Количество рабочих дней между введенными датами: " + (fullWeeks * 5 + partialWeekAdjustment)
        );

        in.close();
    }
}