package NumberPrint;

import java.util.ArrayList;

public class Numbers {
    int current_turn = 1;
    static ArrayList<Integer> list;
    static ArrayList<String> result = new ArrayList<>();

    public static void numberlist(ArrayList<Integer> numbers)
    {
        list = numbers;
    }

    boolean check_if_empty()
    {
        if(list.isEmpty())
            return true;
        return false;
    }
}
