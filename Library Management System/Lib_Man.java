import java.util.ArrayList;
import java.util.Scanner;

public class Lib_Man extends File_Hand_Lib_Man {

    public static void main(String[] args) {
        File_Hand_Lib_Man obj = new File_Hand_Lib_Man();
        //obj.create();
        //obj.write_file();
        ArrayList<String> books;
        ArrayList<String> returned;

        books = obj.loadBooks();
        returned= obj.loadReturnedBooks();

        Scanner sc = new Scanner(System.in);

        while (true) {
            obj.saveBooks(books);
            obj.saveReturnedBooks(returned);


            System.out.println("\n------------------------------  Welcome to the library  ------------------------------");
            System.out.println("The amazing books we have in store for you are:\n");
            obj.displayBooks(books);

            System.out.println("\nPlease select your choice:");
            System.out.println("1. Issue a book");
            System.out.println("2. Return a book");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("The books available for issuing are:\n");
                obj.displayBooks(books);
                System.out.println("\nPlease enter the number of the book you want to be issued: ");
                int issue = sc.nextInt();

                if (issue >=1 & issue <= books.size()) {
                    String issuedBook = books.remove(issue - 1);
                    returned.add(issuedBook);
                    System.out.println("\nThe book issued is: " + issuedBook + "\n");
                } else {
                    System.out.println("Invalid book number.");
                }
            } else if (choice == 2) {
                System.out.println("\nAlready issued books are: ");
                obj.displayBooks(returned);
                System.out.println("\nEnter the number of the book you want to return: ");
                int rtn = sc.nextInt();

                if (rtn >= 1 && rtn <= returned.size()) {
                    String returnedBook = returned.remove(rtn - 1);
                    books.add(returnedBook);
                    System.out.println("The book returned is: " + returnedBook);
                } else {
                    System.out.println("Invalid book number.");
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}


   
