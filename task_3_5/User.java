package task_3_5;

public class User {

    private String name;
    private Integer age;

    public User() {
        name = "";
        age = 0;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return name + ", возраст " + age + " лет";
    }

}
