package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book varAndPeace = new Book("Var and peace", 3000);
        Book gameOfThrones = new Book("Game of thrones", 1000);
        Book cleanCode = new Book("Clean code", 500);
        Book lookingForAlaska = new Book("Looking for Alaska", 400);
        Book tmp = new Book("tmp", 0);
        Book[] books = new Book[4];
        books[0] = varAndPeace;
        books[1] = gameOfThrones;
        books[2] = cleanCode;
        books[3] = lookingForAlaska;
        for (Book book : books) {
            System.out.println(book.getName() + ", " + book.getPages() + " стр.");
        }
        System.out.println(System.lineSeparator());
        tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book book : books) {
            System.out.println(book.getName() + ", " + book.getPages() + " стр.");
        }
        System.out.println(System.lineSeparator());
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + ", " + book.getPages() + " стр.");
            }
        }
    }
}
