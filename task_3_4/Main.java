package task_3_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя первого пользователя");
        String name = in.nextLine();
        System.out.println("Введите возраст первого пользователя");
        int age = in.nextInt();
        in.nextLine();
        User user1 = new User(name, age);

        System.out.println("Введите имя второго пользователя");
        name = in.nextLine();
        System.out.println("Введите возраст второго пользователя");
        age = in.nextInt();
        User user2 = new User(name, age);

        if (user1.getAge() > user2.getAge())
            System.out.print(user2);
        else
            System.out.print(user1);

        in.close();
    }
}
