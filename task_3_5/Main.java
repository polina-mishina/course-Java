package task_3_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        String name;
        int age;

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = in.nextLine();
            System.out.println("Введите возраст пользователя "+ (i + 1));
            age = in.nextInt();
            in.nextLine();
            users.add(new User(name, age));
        }
        Collections.sort(users, new Comparator<User>() {
            public int compare(User user1, User user2) {
                return user1.getAge().compareTo(user2.getAge());
            }
        });

        for(User user : users)
            System.out.print("\n"+ user.toString());

        in.close();
    }
}
