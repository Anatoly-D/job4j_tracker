package ru.job4j.pojo;

public class Book {
    private String bookName;
    private int pagesQty;

    public Book(String bookName, int pagesQty) {
        this.bookName = bookName;
        this.pagesQty = pagesQty;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPagesQty() {
        return pagesQty;
    }

    public void setPagesQty(int pagesQty) {
        this.pagesQty = pagesQty;
    }
}
