package labs;

public class lab06 {
    /*
     * I did the entirety of this lab by myself. Since palindromes read the same
     * both forward and backwards and we've spent extensive time in class discussing
     * how to reverse a string, a simple way to check if a string is a palindrome
     * would be to reverse it and use the String.equals() or String.compareTo()
     * method to check and see if the forward string and the backwards string were
     * equal. I used a for loop that started at the last character of the string and
     * added it to a strBackwards acculumator going from the last letter to the
     * first. That variable is compared to the original string in the if-else
     * statements. If they are equal, the method returns true. If not, the method
     * doesn't. If the strings are compared and turn out to be equal, the return
     * boolean is true. If not, it's false. 
     * 
     * The first reverseString method first takes the string and removes all
     * punctuation using the removePuntuation method described in the previous
     * paragraph. It then intializes an acculumator output and sets it to the empty
     * string. I then create a for loop that starts at 0 and runs to the number of
     * characters in the string of interest. Inside the block of the for loop, I
     * create another acculumator called localOutput that handles the output of the
     * individual words (as contrased with output, which handles the entire string).
     * I also set up a for loop that runs until it hits a space character (that is,
     * runs until the current word ends). Inside that while loop, localOutput has
     * the characters of the word added to it in reverse (using the strategy where
     * the prevous parts are added after the newest part (given by
     * strWithoutSpace.charAt(i))). After the acculumator is increased, i increments
     * by one and the process repeats until the character at i is a space, which
     * causes the while loop to terminate and add what was in localOutput (the
     * reversed word) plus a space to output and increments i (from the loop header)
     * to account for the space. If the string is finished, the if statement is
     * triggered. This statement activates when i is equal to the length of the
     * string since i increments each time a character is added to any localOutput
     * and when spaces are added to output at the end of the for loop block
     * statement. The statement causes the while loop to bread and add its
     * localOutput to the output, and it's necessary because most people aren't in
     * the habit of putting spaces at the end of their sentences. Another strategy
     * (that could potentially use less code) would be to add a space to the string
     * earlier in the method but that's a little confusing and doesn't lend itself
     * to readability as well. Plus the slides mentoined that a break was needed.
     * Output is then returned.
     * 
     * The reverseString_2 method is almost identical to the reverseString_1 method
     * so I won't go into the same level of detail. The only changes are that
     * localOutput is created by adding up characters in "forward" order instead of
     * backwards and, insted, the localOutputs get added to output backwards by
     * using output = localOutput + output. There's also a space added before each
     * addition for readability except in the case where i is equal to the string
     * length (ie the case when localoutput is the last word in the orignal
     * statement) where localOutput is just preadded to the output without the space
     * (this is done using if-else). Output is then returned.
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("tacocat"));
        System.out.println(isPalindrome("integral"));
        System.out.println(reverseString_1("I love CS 170, I love coding!"));
        System.out.println(reverseString_2("I love CS 170, I love coding!"));
        System.out.println("b".compareTo("a"));
    }

    public static boolean isPalindrome(String str) {
        String strBackwards = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            strBackwards += str.charAt(i);
        }
        if (str.compareTo(strBackwards) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String reverseString_1(String str) {
        String strNoPunct = removePunctuation(str);
        String output = "";
        for (int i = 0; i < strNoPunct.length(); i++) {
            String localOuput = "";
            while (strNoPunct.charAt(i) != ' ') {
                localOuput = strNoPunct.charAt(i) + localOuput;
                i++;
                if (i == strNoPunct.length()) {
                    break;
                }
            }
            output += localOuput + " ";
        }
        return output;
    }

    public static String reverseString_2(String str) {
        String strNoPunct = removePunctuation(str);
        String output = "";
        for (int i = 0; i < strNoPunct.length(); i++) {
            String localOuput = "";
            while (strNoPunct.charAt(i) != ' ') {
                localOuput += strNoPunct.charAt(i);
                i++;
                if (i == strNoPunct.length()) {
                    break;
                }
            }
            if (i != strNoPunct.length()) {
                output = " " + localOuput + output;
            } else {
                output = localOuput + output;
            }
        }
        return output;
    }

    public static String removePunctuation(String s) {
        return s.replaceAll("!", "").replaceAll(",", "").replaceAll("\'", "").replaceAll("\"", "").replaceAll(":", "")
                .replaceAll(";", "").replaceAll("/", "").replaceAll("’", "").replaceAll("”", "").replaceAll("<", "")
                .replaceAll(">", "").replaceAll("[.]", "").replaceAll("[?]", "").replaceAll("[{]", "")
                .replaceAll("[}]", "").replaceAll("[(]", "").replaceAll("[)]", "").replaceAll("\\[", "")
                .replaceAll("\\]", "");
    }
}
