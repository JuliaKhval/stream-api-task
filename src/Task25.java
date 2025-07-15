import java.util.stream.IntStream;

public class Task25 {
    public static void main(String[] args) {
        int n = 7;
        int fuctorial = IntStream.rangeClosed(1, n).reduce(1, (a,b)->a*b);
        System.out.println(fuctorial);
    }
}
