package task_3_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        HashMap<Integer, List<User>> usersMap = new HashMap<>();
        String name;
        int age;

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = in.nextLine();
            System.out.println("Введите возраст пользователя " + (i + 1));
            age = in.nextInt();
            in.nextLine();
            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(new User(name, age));
            } else {
                ArrayList<User> usersList = new ArrayList<>();
                usersList.add(new User(name, age));
                usersMap.put(age, usersList);
            }
        }

        System.out.println("\nВведите требуемый возраст");
        age = in.nextInt();
        if(usersMap.containsKey(age)) {
            usersMap.get(age).sort(new Comparator<User>() {
                public int compare(User user1, User user2) {
                    return user1.getName().compareTo(user2.getName());
                }
            });
            for (User user : usersMap.get(age))
                System.out.println(user);
        }
        else
            System.out.printf("Пользователь с возрастом '%d' не найден", age);

        in.close();
    }
}
