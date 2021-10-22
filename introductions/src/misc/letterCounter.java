package misc;
public class letterCounter {
    public static void main(String[] args) {
        System.out.println(letterCount("abc-123-abc-ABC", "b"));
        System.out.println(letterCount("This is interesting!", "z"));
        System.out.println(letterCount("", "q"));
        System.out.println(digitCount(456234, 8));
        System.out.println(digitCount(456234, 5));
        System.out.println(digitCount(456234, 4));
        System.out.println(digitCount(-456234, 4));
        System.out.println(digitCount(0, 0));
        System.out.println(digitCount(1000000000, 0));
    }

    /*
     * This method sets an acculumator countedLetter that increments by one for each
     * time that the string c is found in the string s. This is accomplished by
     * having a for loop that runs from i = 0 to i = s.length() - 1 so that it can
     * check if each character of the word is or is not equal to the character c,
     * which is done by setting s.charAt(i) to check each letter against c.charAt(0)
     * (this is done because strings like c cannot be directly compared to s). If
     * this is true, the acculumator increments. If it isn't, it doesn't and goes to
     * the next letter in string s. After the loop is done running, the method
     * returns countedLetters.
     */
    public static int letterCount(String s, String c) {
        int countedLetters = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c.charAt(0)) {
                countedLetters++;
            }
        }
        return countedLetters;
    }

    /*
     * What I did for this was create an acculumator coutnedDigits that will be
     * updated each time a match is found. Secondly, I created another variable
     * positiveNumber that squares the number parameter and takes the square root of
     * it to get rid of any possible negative signs. Because the maximum value that
     * an integer can have in java is 10 digits, this method's for loop iterates 10
     * times. To generalize this method for doubles or other types with more digits
     * avaliable, it should be possible to give the loop a condition that's always
     * true since there's a return statement in the loop for which the conditions
     * will always eventually be met (more on that later). Inside the for loop, I
     * declare a new variable numberOfComparison, which takes the integer quotient
     * of positiveNumber and 10 and then muliplies that by ten. This is because the
     * integer division will remove the last digit of the number when it goes beyond
     * the decimal point and, when it's multiplied by 10, the former last digit
     * becomes a zero. Next, I subtract the digit from the argument from the
     * positive number and compare it to the numberOfComparison that has a 0 as its
     * last digit. If the last digit of the positiveNumber is equal to the digit
     * from the argument, then the final digit will be zero, and it'll be identical
     * to the numberOfComparison value, which will cause the if statement to add 1
     * to the countedDigits. If it isn't, nothing happens. After that,
     * positiveNumber is integer divided by 10 so that the analysis can be repeated
     * for a new last digit and, once the loop is done running, countedDigits is
     * returned. ALternatively, countedDigits will also return from the for looop
     * once positiveNumber is equal to 0. This prevents the loop from doing any
     * unnecessary iterations and better handles cases where the digit is 0 (since
     * it may otherwise keep adding to the countedDigits b/c 0/10 * 10 is always 0).
     */
    public static int digitCount(int number, int digit) {
        int countedDigits = 0;
        int positiveNumber = (int) Math.sqrt(Math.pow(number, 2));
        for (int i = 0; i < 10; i++) {
            int numberOfComparison = (int) (positiveNumber / 10) * 10;
            if ((positiveNumber - digit) == numberOfComparison) {
                countedDigits++;
            }
            positiveNumber = (int) (positiveNumber / 10);
            if (positiveNumber == 0) {
                return countedDigits;
            }
        }
        return countedDigits;
    }
}