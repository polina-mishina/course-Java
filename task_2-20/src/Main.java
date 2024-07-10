public class Main {
    public static void main(String[] args) {

        int len = 20;
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = (int) Math.floor(Math.random() * 15) + 1;

        System.out.print("[");
        for (int i = 0; i < len - 1; i++)
            System.out.printf("%d, ", array[i]);
        System.out.printf("%d]", array[len-1]);

        int[] res = new int[15];
        for (int el : array)
            res[el-1]++;

        for (int i = 0; i < 15; i++)
            if (res[i] > 1 && res[i] < 5 )
                System.out.printf("\nЧисло '%d' встречается %d раза", i + 1, res[i]);
            else if (res[i] > 1)
                System.out.printf("\nЧисло '%d' встречается %d раз", i + 1, res[i]);

    }
}