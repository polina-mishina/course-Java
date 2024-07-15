import java.util.stream.LongStream;

public class Main {

    private static long getArithmeticProgressionSum (int a, int b) {
        return LongStream.range(a, b).sum();
    }

    public static void main(String[] args) {

        int a = 10_000_000, b = 1_000_000_000;
        System.out.println(getArithmeticProgressionSum(a, b));
    }
}
