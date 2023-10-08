package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] o1Split = o1.split("/", 2);
        String[] o2Split = o2.split("/", 2);
        result = o2Split[0].compareTo(o1Split[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}