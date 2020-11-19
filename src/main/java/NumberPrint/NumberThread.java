package NumberPrint;

import java.util.Collections;

public class NumberThread extends Numbers implements Runnable {
    Numbers numbers;
    boolean flag = true;
    private int thread_no;
    int i = 0;
    private int max_thread_no;

    public NumberThread(Numbers numbers) {
        this.numbers = numbers;
    }

    public void ThreadNumber(int i) {
        thread_no = i;
    }
    public void setMaxNumber(int i) { max_thread_no = i;}

    @Override
    public void run() {
        try {
            synchronized (numbers) {
                while (flag) {
                    while (numbers.current_turn != this.thread_no) {
                        numbers.wait();
                    }
                   String res = turn();
                    result.add(res);
                    if (flag) {
                        if (check()) {
                            flag = false;
                        }
                    }
                    Thread.sleep(100);
                    if (thread_no == max_thread_no)
                        numbers.current_turn = 1;
                    else
                        numbers.current_turn = thread_no + 1;
                    numbers.notifyAll();
                }
                printNumber();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void printNumber() throws InterruptedException {
        Collections.shuffle(result);
        for(String i : result)
        {
            System.out.println(i);
            Thread.sleep(100);
        }
    }

    private boolean check() {
        if (check_if_empty())
            return true;
        return false;

    }

    private String turn() {
        if(list.size() ==0)
            System.exit(0);
        int num = list.get(i);
        String res= "Thread" + thread_no + " - " + num;
//        System.out.println(res);
        list.remove(i);
        return res;
    }
}