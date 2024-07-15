package task_4_4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner{

    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        learner.learn();
        SimpleDateFormat ft = new SimpleDateFormat("Текущее время: HH:mm:ss");
        Date date = new Date();
        System.out.println(ft.format(date));
    }
}
