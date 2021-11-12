package labs;

public class lab11 {
    /*
     * The first thing to do for this code was to find the regex that encompasses
     * [number][operator][number], and I settled on \d+[+-*^%/]\d+. \d+ was used
     * instead of \d or \d* because I wanted the method to account for more than one
     * digit as the first and second number and it had to be greater than 0 for the
     * expression to logically parse. The operators were defined in a character
     * class (with \- because - by itself caused errors). To deal with the \ in \d
     * and \- being not being considered, I added a second backslack to those in the
     * code implementation of the pattern. With that in mind, I set up an if-else
     * block to check if a given input e matched the pattern. If the match was
     * false, the method prints out an error message and returns 0. Otherwise, the
     * method groups the pattern into the first number \d+, the operator class, and
     * the last number. The firstNum variable is initalized by replacing the entire
     * string with the result of the first group, and then parsing it as an int. The
     * secondNum variabe does something similar, and the operator variable takes the
     * middle group. After those variables are set up, anther if-else if-else block
     * compares the operator variable with the 6 operators using .matches(). When
     * the operator variable and the match are equal, the program completes the
     * computation. (I had to use \\ to escape the +, *, and ^ since they have
     * meaning in regex). In the case of -, the operator is relegated to the else
     * statement.
     */
    public static void main(String[] args) {
        System.out.println("1+2" + " = " + evaluateExpression("1+2"));
        System.out.println("5*7" + " = " + evaluateExpression("5*7"));
        System.out.println("10-4" + " = " + evaluateExpression("10-4"));
        System.out.println("72/9" + " = " + evaluateExpression("72/9"));
        System.out.println("2^4" + " = " + evaluateExpression("2^4"));
        System.out.println("20%3" + " = " + evaluateExpression("20%3"));
        System.out.println("3&7" + " = " + evaluateExpression("3&7"));
    }

    public static int evaluateExpression(String e) {
        if (e.matches("\\d+[+\\-*/^%]\\d+") == false) {
            System.out.println("Error: invalid input expression");
            return 0;
        } else {
            int firstNum = Integer.parseInt(e.replaceAll("(\\d+)([+\\-*/^%])(\\d+)", "$1"));
            int secondNum = Integer.parseInt(e.replaceAll("(\\d+)([+\\-*/^%])(\\d+)", "$3"));
            String operator = e.replaceAll("(\\d+)([+\\-*/^%])(\\d+)", "$2");
            if (operator.matches("\\+")) {
                return firstNum + secondNum;
            } else if (operator.matches("\\*")) {
                return firstNum * secondNum;
            } else if (operator.matches("/")) {
                return firstNum / secondNum;
            } else if (operator.matches("\\^")) {
                return (int) Math.pow(firstNum, secondNum);
            } else if (operator.matches("%")) {
                return firstNum % secondNum;
            } else {
                return firstNum - secondNum;
            }
        }
    }
}
