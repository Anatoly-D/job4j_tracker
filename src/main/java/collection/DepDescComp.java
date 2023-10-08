package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] o1Split = o1.split("/", 2);
        String[] o2Split = o2.split("/", 2);
        result = o2Split[0].compareTo(o1Split[0]);
        if (result == 0) {
            if (o1Split.length > 1 && o2Split.length > 1) {
                result = o1Split[1].compareTo(o2Split[1]);
            } else {
                result = o1Split.length - o2Split.length;
            }
        }
        return result;
    }
}