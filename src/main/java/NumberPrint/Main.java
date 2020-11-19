package NumberPrint;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Threads: ");
        int threads = sc.nextInt();
        System.out.print("Enter the maximum Numbers: ");
        final int max_number = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < max_number + 1; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        Numbers numbers = new Numbers();
        NumberThread[] numberThreads = new NumberThread[threads];
        for (int i = 0; i <threads; i++) {
            numberThreads[i] = new NumberThread(numbers);
            numberThreads[i].ThreadNumber(i+1);
            numberThreads[i].setMaxNumber(threads);
        }
        NumberThread.numberlist(list);
        Thread[] t = new Thread[threads];
        for (int i = 0; i <threads; i++) {
            t[i] = new Thread(numberThreads[i]);
            t[i].start();

        }
    }
}
