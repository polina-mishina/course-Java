import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите 3 числа");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (a % 5 == 0 && b % 5 == 0 && c % 5 == 0)
            System.out.printf("a=%d, b=%d, c=%d", a, b, c);
        else if (a % 5 == 0 && b % 5 == 0)
            System.out.printf("a=%d, b=%d", a, b);
        else if (a % 5 == 0 && c % 5 == 0)
            System.out.printf("a=%d, c=%d", a, c);
        else if (b % 5 == 0 && c % 5 == 0)
            System.out.printf("b=%d, c=%d", b, c);
        else if (a % 5 == 0)
            System.out.printf("a=%d", a);
        else if (b % 5 == 0)
            System.out.printf("b=%d", b);
        else if (c % 5 == 0)
            System.out.printf("c=%d", c);
        else
            System.out.print("нет значений, кратных 5");

        System.out.printf("\nРезультат целочисленного деления a на b: %d", a / b);
        double d = a * 1.0 / b;
        System.out.printf("\nРезультат целочисленного деления a на b: %.12f", d);
        System.out.printf("\nРезультат деления a на b с округлением в большую сторону: %d", (int) Math.ceil(d));
        System.out.printf("\nРезультат деления a на b с округлением в меньшую сторону: %d", (int) Math.floor(d));
        System.out.printf("\nРезультат деления a на b с математическим округлением: %d", (int) Math.round(d));
        System.out.printf("\nОстаток от деления b на c: %d", b % c);
        System.out.printf("\nНаименьшее значение из a и b: %d", Math.min(a, b));
        System.out.printf("\nНаибольшее значение из b и c: %d", Math.max(b, c));

        in.close();
    }
}