package labs;

public class lab05 {
    /*
     * For the fizzbuzz method, I just set up if else statements that would account
     * for the cases mentioned (starting with the number being a factor of both
     * three and five since if either of the other statements came before it, they
     * would run first). I determined multiples by taking the modulo of the number
     * with respect to 3 and with respect to five. If that is zero, it meant that it
     * was a multiple. To store the outputs, I set up a acculumation variable output
     * initially set to an empty string that either added the number, a fizz, or a
     * buzz depending on the relationship between the foor loop's variable i, 3, and
     * 5. The for loop itself iterated from the start integer to the end one by ones
     * and adds only one new term to the string at a time. Because the prompt
     * specifically used the word "print" instead of "return," I had the method
     * return void and print out the final string instead.
     * 
     * Both my findFactorsFor and findFactorsWhile methods operate the same way. I
     * initialize an empty string factorList, which will hold the factors. From
     * then, I set up the loop. In the while loop case, I have to initialize i = 1
     * before setting up the loop header, which will run up until i is equal to the
     * number x of interest. At the end of the loop, i increments by 1 (using i++)
     * either within the loop header (for the foor loop) or at the end of the loop
     * body (for the while loop). The loop itself takes the modulo of the number
     * with respect to i and, if that is equal to zero, it adds i to the factorList.
     * If that condition is not satisfied, it doesn't. After the loop, factorLoop is
     * printed (like before, it's printed and not returned because of the verbiage
     * of the prompt). A while loop offers more versatility in its construction, I
     * could put the i++ in the middle of the loop if so desired and not being
     * limited by the initialization, condition, incrementaion format in the header
     * makes setting up conditions that don't necessarily rely on a counting
     * variable like i more striaghtforward. A for loop, on the other hand, keeps
     * things tidier in that specific case or when the additional versatility is not
     * needed. Because my solution this time did nicely fit the for loop's modus
     * operandi, it was preferable to have the int i = 0, i <= x, and i++ terms all
     * in one place. 
     * Zachariah worked on the method construction while Adrian and
     * Ashwin formalized the discussion on for loops vs while loops
     */
    public static void main(String[] args) {
        fizzBuzz(1, 16);
        fizzBuzz(90, 100);
        findFactorsFor(10);
        findFactorsFor(42);
        findFactorsWhile(10);
        findFactorsWhile(42);
    }

    public static void fizzBuzz(int start, int end) {
        String output = "";
        for (int i = start; i <= end; i++) {
            if (((i % 3) == 0) && ((i % 5) == 0)) {
                output += " FizzBuzz ";
            } else if ((i % 3) == 0) {
                output += " Fizz ";
            } else if ((i % 5) == 0) {
                output += " Buzz ";
            } else {
                output += i + " ";
            }
        }
        System.out.println(output);
    }

    public static void findFactorsFor(int x) {
        String factorList = "";
        for (int i = 1; i <= x; i++) {
            if ((x % i) == 0) {
                factorList += i + " ";
            }
        }
        System.out.println(factorList);
    }

    public static void findFactorsWhile(int x) {
        String factorList = "";
        int i = 1;
        while (x >= i) {
            if ((x % i) == 0) {
                factorList += i + " ";
            }
            i++;
        }
        System.out.println(factorList);
    }
}
