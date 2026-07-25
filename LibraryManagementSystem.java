/*import javax.swing.*;
import java.awt.Graphics;

public class java_programs extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello, World!", 150, 150);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("First Applet");
        frame.add(new java_programs());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}*/


import java.util.Scanner;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static String books[] = new String[100];
    static boolean issued[] = new boolean[100];
    static String issuedTo[] = new String[100];

    static int totalBooks = 0;

    public static void main(String[] args) {

        int choice;

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    System.out.println("\nThank You...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }

        }

    }

    static void addBook() {

        System.out.print("\nEnter Book Name : ");

        books[totalBooks] = sc.nextLine();

        issued[totalBooks] = false;

        issuedTo[totalBooks] = "";

        totalBooks++;

        System.out.println("Book Added Successfully.");

    }

    static void displayBooks() {

        if (totalBooks == 0) {

            System.out.println("\nNo Books Available.");

            return;

        }

        System.out.println("\n-------- BOOK LIST --------");

        for (int i = 0; i < totalBooks; i++) {

            System.out.print((i + 1) + ". " + books[i]);

            if (issued[i])

                System.out.println("  --> Issued to " + issuedTo[i]);

            else

                System.out.println("  --> Available");

        }

    }

        static void searchBook() {

        if (totalBooks == 0) {

            System.out.println("\nNo Books Available.");

            return;

        }

        System.out.print("\nEnter Book Name to Search : ");

        String search = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < totalBooks; i++) {

            if (books[i].equalsIgnoreCase(search)) {

                found = true;

                System.out.println("\nBook Found");

                System.out.println("Book Name : " + books[i]);

                if (issued[i])

                    System.out.println("Status : Issued to " + issuedTo[i]);

                else

                    System.out.println("Status : Available");

                break;

            }

        }

        if (!found)

            System.out.println("Book Not Found.");

    }

    static void issueBook() {

        if (totalBooks == 0) {

            System.out.println("\nNo Books Available.");

            return;

        }

        System.out.print("\nEnter Book Name to Issue : ");

        String name = sc.nextLine();

        for (int i = 0; i < totalBooks; i++) {

            if (books[i].equalsIgnoreCase(name)) {

                if (issued[i]) {

                    System.out.println("Book is Already Issued.");

                    return;

                }

                System.out.print("Enter Student Name : ");

                issuedTo[i] = sc.nextLine();

                issued[i] = true;

                System.out.println("Book Issued Successfully.");

                return;

            }

        }

        System.out.println("Book Not Found.");

    }

    static void returnBook() {

        if (totalBooks == 0) {

            System.out.println("\nNo Books Available.");

            return;

        }

        System.out.print("\nEnter Book Name to Return : ");

        String name = sc.nextLine();

        for (int i = 0; i < totalBooks; i++) {

            if (books[i].equalsIgnoreCase(name)) {

                if (!issued[i]) {

                    System.out.println("This Book is Already Available.");

                    return;

                }

                issued[i] = false;

                issuedTo[i] = "";

                System.out.println("Book Returned Successfully.");

                return;

            }

        }

        System.out.println("Book Not Found.");

    }

}