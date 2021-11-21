package labs;

import java.util.Scanner;
import java.io.*;

public class lab12 {
    /*
     * For both the scanner and console methods of writing the password, I set up a
     * void method for the scanner method and implemented the code for the console
     * process in the main method b/c the console didn't like being called in its
     * own method. I set a boolean called passwordOK and set it equal to false, and
     * then I set up the console or scanner and have them take input from the user
     * and pass it to a variable password. However, before that can be done, I set
     * up a while loop that iterates as long as passwordOK is false (!passwordOK).
     * The terminal then prompts the user for an input and that's when password
     * attempts are entered. If a password matches a bunch of regex expressions that
     * test for the elements required by matching one instance of the required
     * charater to the string. This was easier to do than run through the 24
     * possiblities of using variations on .*[A-Z].*[a-z].*\d.*[!@#$&%].*. After the
     * charater regex, I use a regex to make sure that the password has 8-20
     * charaters by making sure it matches .{8,20}. If the password attempt matches
     * all that, passwordOK is changed to true, and the while loop breaks. In the
     * case of the scanner, the scanner is closed and in both cases, I set up a
     * filewriter and buffered writer that write the password to a file before
     * informing the user that the password works and exiting the program.
     * 
     * In terms of comparisons between scanners and consoles, the larger buffer of
     * the console seems more broadly useful for larger files but it's lack of
     * compatibility made it difficut to use. I tested the program on my computer in
     * powershell, the command line, and even a ubuntu virtual machine (via wsl)
     * before it finally worked on one of the computers in the lab (and, even, then
     * I had to move the console method from its own method into the main method).
     * The scanner, on the other hand, worked fine on all of them and in my IDE.
     * That's the biggest difference that I directly encountered but the scanner's
     * ability to use parsing tokenized primitives also seems broadly useful for
     * other applications. If given a choice betmeen the two, I am probably more
     * likely to use scanner.
     */
    public static void main(String[] args) throws IOException {
        Console c = System.console();
        boolean passwordOK = false;
        String password = "";
        while (!passwordOK) {
            System.out.println("Enter a correct password: ");
            password = c.readLine();
            if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*")
                    && password.matches(".*[!@#$%&].*") && password.matches(".{8,20}")) {
                passwordOK = true;
            }
        }
        FileWriter fw = new FileWriter("passwordHolderCons.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(password);
        bw.close();
        fw.close();
        System.out.println("Your password has been set successfully");
        passwordCheckerScanner();
    }

    public static void passwordCheckerScanner() throws IOException {
        Scanner s = new Scanner(System.in);
        boolean passwordOK = false;
        String password = "";
        while (!passwordOK) {
            System.out.println("Enter a correct password: ");
            password = s.nextLine();
            if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*")
                    && password.matches(".*[!@#$%&].*") && password.matches(".{8,20}")) {
                passwordOK = true;
            }
        }
        s.close();
        FileWriter fw = new FileWriter("passwordHolderScan.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(password);
        bw.close();
        fw.close();
        System.out.println("Your password has been set successfully");
    }
}
