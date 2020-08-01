package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book ball = new Book("Ball", 10);
        Book animalFarm = new Book("Animal Farm", 112);
        Book javaEckel = new Book("Thinking in Java", 1000);
        Book cleanCode = new Book("Clean Code", 464);

        Book[] books = new Book[4];

        books[0] = ball;
        books[1] = animalFarm;
        books[2] = javaEckel;
        books[3] = cleanCode;

        outputBooks(books);
        swapBooks(books, 0, 3);
        outputBooks(books);
        outputBooksFilter(books, "Clean Code");
    }

    private static void outputBooksFilter(Book[] books, String filter) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookName().equals(filter)) {
                System.out.println("The Book \"" + books[i].getBookName()
                        + "\" has " + books[i].getPagesQty() + " pages.");
            }
        }
        System.out.println();
    }

    private static void swapBooks(Book[] books, int left, int right) {
        Book temp = books[left];
        books[left] = books[right];
        books[right] = temp;
    }

    private static void outputBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println("The Book \"" + books[i].getBookName()
                    + "\" has " + books[i].getPagesQty() + " pages.");
        }
        System.out.println();
    }
}
