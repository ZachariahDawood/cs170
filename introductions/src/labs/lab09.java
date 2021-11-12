package labs;

public class lab09 {
    /*
     * I completed this lab alone. Starting with the decimalToBinary method, I
     * determined that the base case would be when the the decimal number was the
     * lowest it could be without being negative, which was zero and the binary
     * equivalent of zero is zero. Past that, the else case handles the main
     * division and modulation of finding binary numbers. First, more significant
     * digits are calculated by calling the recursive decimalToBinary method with
     * d/2 until the base case was hit. Because the method is called before the
     * modulo calculation is done, the more significant bits associated with more
     * divided decimal numbers are placed before the less significant ones, which
     * are all calculated using d%2 as per the formula. Integer.parseInt is called
     * on the recursive return so that only the decimal number 0 would have a
     * leading zero.
     * 
     * The binaryToDecimal method involves more code but was easier to intuitively
     * parse for me. The binaryToDecimal method itself only contains two lines: a
     * line that initializse a variable count to -1 and a return statement that
     * returns the result of another method called b2DHelper. b2DHelper starts off
     * by incrementing count by one (the reason for which will become apparent
     * later) and then sets the bsae case of that occurs when the String b is "0",
     * which returns the integer zero. Now the else case does the main calculation.
     * If the string isn't "0", it takes the last number of the string (given by
     * Integer.parseInt(b.substring(b.length() - 1))) where b.length() -1 indicates
     * the last character of the string, substring() makes it a string of its own
     * and Integer.parseInt() converts it into an integer) and multiplies it by the
     * power of two corresponding to its significance (for the last significant bit,
     * it's multiplied by 1, for the second lest significant bit, it's multiplied by
     * two and so on). This is where both the variable count and the fact that there
     * are two methods involved come into play. Because you can't (or, at least, I
     * don't know how/couldn't think of a way to) set a variable in a method that
     * persists and increments between recursions, I set a variable in another
     * method that the b2DHelper method takes as a parameter. The reason why I
     * couldn't set it as a variable in the b2DHelper method was because if I
     * assigned count to a number (as I needed to do when initalizing), each
     * recursion would result in that count being reset instead of incremented.
     * However, by setting it in another method and then calling it as an argument,
     * it could be incremented by simply using count++ (and starting with -1 to
     * account for the first recursion that raises two to the power of zero).
     * Because of the count variable, each bit can be multiplied by 2 to a
     * different, larger power for an arbitrarily long binary number. After that is
     * calculated, the method calls itself but with the argument being the string
     * minus its least significant bit (accomplished by parsing it as an int and
     * integer dividing it by 10 and converting it back to a string by adding the
     * empty string) with the current value of count as the other argument to
     * account for adding subsequently more important bits. When the string
     * eventually becomes "0", the base case will be reached and the method can
     * return its integer, wihch returns to the decimalToBinary method, which can be
     * printed.
     */
    public static void main(String[] args) {
        System.out.println(decimalToBinary(255)); // 11111111
        System.out.println(decimalToBinary(12)); // 1100
        System.out.println(decimalToBinary(15)); // 1111
        System.out.println(decimalToBinary(0)); // 0
        System.out.println(binaryToDecimal("0")); // 0
        System.out.println(binaryToDecimal("1111")); // 15
        System.out.println(binaryToDecimal("1100")); // 12
        System.out.println(binaryToDecimal("11111111")); // 255
    }

    public static String decimalToBinary(int d) {
        if (d == 0) {
            return "0";
        } else {
            return "" + Integer.parseInt(decimalToBinary(d / 2)) + d % 2;
        }
    }

    public static int binaryToDecimal(String b) {
        int count = -1;
        return b2DHelper(b, count);
    }

    public static int b2DHelper(String b, int count) {
        count++;
        if (b.equals("0")) {
            return 0;
        } else {
            return (int) (Integer.parseInt(b.substring(b.length() - 1)) * Math.pow(2, count)
                    + b2DHelper((Integer.parseInt(b) / 10) + "", count));
        }
    }
}