package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("The element wasn't found, try another one.");
    }

    public static void main(String[] args) {
        String[] parStr = {"first", "second", "third"};
        int resultIndex;
        try {
            resultIndex = indexOf(parStr, "q");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}