package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";
    public static final String PASSWORD = "bhaisahab";
    public static final int LIST_BOOK_CATALOG = 1;
    public static final int CHECK_OUT_BOOK = 2;
    public static final int CHECK_LIBRARY_NUMBER = 3;
    public static final int SHOW_ALL_MOVIES = 4;
    public static final int LOGIN = 5;
    public static final int LOGOUT = 9;

    public static void main(String[] args) throws IOException {
        while (true) {
            showBeginningScreen();
            BufferedReader reader = getInputReader();
            int optionNumber = 0;
            optionNumber = getOptionNumber(reader, optionNumber);

            if (optionNumber == LIST_BOOK_CATALOG) {
                listBookCatalog();
            } else if (optionNumber == CHECK_OUT_BOOK) {
                checkOutBook(reader);
            } else if (optionNumber == CHECK_LIBRARY_NUMBER) {
                checkLibraryNumber();
            } else if (optionNumber == SHOW_ALL_MOVIES) {
                movieListing();
            } else if (optionNumber == LOGIN) {
                clearLogin();
                login(reader);
            } else if (optionNumber == LOGOUT) {
                exit();
                break;
            } else {
                notifyInputNumberWrong();
            }
    notifyInputNumberWrong();
        }
    }

    private static BufferedReader getInputReader() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        return new BufferedReader(inputStream);
    }

    private static int getOptionNumber(BufferedReader reader, int inputNumber) {
        try {
            inputNumber = getNextInt(reader, inputNumber);
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");
        }
        return inputNumber;
    }

    private static int getNextInt(BufferedReader reader, int inputIntNumber) throws IOException {
        String value = reader.readLine();
        inputIntNumber = Integer.parseInt(value);
        return inputIntNumber;
    }

    private static void notifyInputNumberWrong() {
        System.out.println("\n");
        System.out.println("Enter a valid integer!!");
    }

    private static void exit() {
        System.out.println("Quitting...");
        return;
    }

    private static void login(BufferedReader reader) throws IOException {
        System.out.println("Enter your library number");
        String libraryNumber = reader.readLine();
        if (isValidLibraryNumber(libraryNumber)) {
            System.out.println("Enter your Password: ");
            String password = reader.readLine();
            if (isValidPassword(password)) {
                loggedIn = true;
                savedLibraryNumber = libraryNumber;
            }
        }
    }

    private static void movieListing() {
        System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
        System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
        System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
        System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
        System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(createMovie("Inception", "Frank Darabont", "10"));
        System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
    }



    private static void checkLibraryNumber() {
        if (loggedIn()) {
            System.out.println("\n");
            System.out.println("Your library number is " + savedLibraryNumber);
        } else {

            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
        }
    }

    private static void checkOutBook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int bookNumber = 0;
        try {
            bookNumber = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");
        }
        selectBook(bookNumber);
    }

    private static void selectBook(int bookNmuber) {
        if (bookNmuber >= 1 && bookNmuber <= 4) {
            showCheckOutBookSuccessfully();
        } else {
            notifyCheckOutBookFailure();
        }
    }

    private static void notifyCheckOutBookFailure() {
        System.out.println("\n");
        System.out.println("Sorry we don't have that book yet.");
    }

    private static void showCheckOutBookSuccessfully() {
        System.out.println("\n");
        System.out.println(" Thank You! Enjoy the book.");
    }

    private static void listBookCatalog() {
        System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
        System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
        System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
        System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
    }

    private static void showBeginningScreen() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private static boolean isValidPassword(String password) {
        if (PASSWORD.equals(password)) {
            return true;
        } else {
            System.out.println("wrong password, try again");
            return false;
        }
    }

    private static boolean isValidLibraryNumber(String libraryNumber) {
        if (libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d")) {
            return true;
        } else {
            System.out.println("wrong library number, try again");
            return false;
        }
    }

    private static boolean loggedIn() {
        return loggedIn;
    }


    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

