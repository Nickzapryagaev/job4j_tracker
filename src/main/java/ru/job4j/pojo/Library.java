package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Morning", 50);
        Book book2 = new Book("Day", 41);
        Book book3 = new Book("Evening", 63);
        Book book4 = new Book("Clean code", 126);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName());
                break;
            }
        }
    }
}
