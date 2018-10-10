package OOPLabs.Lab2;

import java.util.Scanner;

public class lab2_3 {
    public static void main(String[] args){
        Book b1 = new Book();
        System.out.println("Name of the book is: " + b1.getBook_name()
                + " author of this book is " + b1.getAuthor_name()
                + " year that book was published is " + b1.getPublish_year());
        Book b2 = new Book(1976, "Memoriant", "Champlin");
        System.out.println("Name of the book is: " + b2.getBook_name()
                + " author of this book is " + b2.getAuthor_name()
                + " year that book was published is " + b2.getPublish_year());
    }
}


class Book {
    private String book_name;
    private String author_name;
    private int publish_year;
    Book(int y, String  b, String a) {
        y = publish_year;
        b = book_name;
        a = author_name;
    }
    Book() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name: ");
        book_name = sc.nextLine();
        System.out.print("\nEnter author name: ");
        author_name = sc.nextLine();
        System.out.print("\nEnter year of publication: ");
        publish_year = sc.nextInt();
    }

    int getPublish_year() {
        return publish_year;
    }
    String getBook_name() {
        return book_name;
    }
    String getAuthor_name() {
        return author_name;
    }
}
