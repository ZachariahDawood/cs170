package labs;

public class lab08 {
    /*
     * My approach to this problem was the one described in the final slide, where
     * the cell on the top left replaces the one on the top right, which replaces
     * the one on the bottom right, which replaces the one on the bottom left, which
     * replaces the one on the top left followed by the other corresponding squares
     * on the top, right, bottom, and left sides replacing each otherfor each
     * perimeter square within the matrix. Since we're accessing elements within an
     * array within another array, it seemed logical to set up the two for loops.
     * The first loop had its iteration variable i start at 0 and go to through the
     * number of rows and the second loop's variable j that corresponds with columns
     * starts at the same column number that the row currently is in (so that outer
     * perimeters that the loop has already iterated through aren't iterated through
     * again). The first loop ends at the number of rows and the second one ends at
     * the number of columns minus the numer of rows already iterated through
     * (matrix.length - 1 - i) (again, to prevent unnecessary swapping). After all
     * that setup is completed, the loops work through the core of the method using
     * the replacement stategy described above. First, the element at the top of the
     * current iteration (whether that's the top left element of the current
     * perimeter square or any other on the same row) is stored in a variable called
     * THolder. This element will always be at matrix[i][j] going from the top
     * active row and the leftmost column active. The reason why it's stored
     * externally is because the corresponding element on the left of the square
     * will overwrite it and if it replaces the corresponding element on the right
     * of the square too early, it will overwrite that. The corresponding element on
     * the left is matrix[matrix.length - 1 - j][i] where matrix.length - 1 - j is
     * the last active row and i can refer to the column of interest (in the case of
     * the element of the bottom left replacing the top left, we have the element at
     * (0,0) being replaced by (bottom,0). We'd have (0,1) replaced with (bottom -
     * 1, 0) and so on and so forth. This is what we'd expect). After that, the
     * element on the left will be replaced with the corresponding element on the
     * bottom of the square. The bottom element is matrix[matrix.length - 1 -
     * i][matrix.length - 1 - j] where it looks at the last active row
     * (matrix.length -1 - i) and the last active column (matrix.length - 1 - j). A
     * simple assignment is used to assign the element at the bottom to the element
     * on the left. After that, the element at the right replaces the element at the
     * bottom. The right element is right is matrix[j][matrix.length - 1 - i] (which
     * starts with j = 0 since it's done from the element on the top right to the
     * bottom right) and with the last active column (given by matrix.length - 1 -
     * xj). Finally, the element at the right is replaced with the element that was
     * on top, which was stored in the THolder variable. After one set of
     * corresponding elements is completed, j increments and goes to the next set of
     * corresponding elements until a row is completed. After that, the loop moves
     * onto an inner square by incrementing i in the first loop, which causes the j
     * of the second loop to only pay attention to columns that haven't been focused
     * on before by restricting j to being between the current i and matrix.length -
     * 1 - i.
     *
     * After the matrix runs through the rotateImage method, I created another
     * method arrayToString to better visualize it. This method is considerably more
     * simple. It takes a 2d int array and returns a String. It initializes a string
     * output and sets it to be empty. Like the other method, it uses two for loops
     * to record each element of the array. In the first loop, which goes from 0 to
     * the length of the array - 1, the output adds a { before going to the second
     * loop, which runs from j = 0 to j = matrix.length - 2, the output adds the
     * element of the matrix given by matrix[i][j] plus a comma and a space. After
     * the loop finishes, it adds the last element of the matrix (which would be the
     * element at matrix[i][matrix.length - 1] and closes it with a } and a
     * newline). The outer for loop does the same for the other rows of the matrix
     * until there are no more rows to run through.
     */
    public static void main(String[] args) {
        int[][] testCase1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotateImage(testCase1);
        System.out.println(arrayToString((testCase1)));

        int[][] testCase2 = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotateImage(testCase2);
        System.out.println(arrayToString(testCase2));

        int[][] testCase3 = new int[][] { { 1 } };
        rotateImage(testCase3);
        System.out.println(arrayToString(testCase3));

        int[][] testCase4 = new int[][] { { 1, 2 }, { 3, 4 } };
        rotateImage(testCase4);
        System.out.println(arrayToString(testCase4));
    }

   public static void rotateImage(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int THolder = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = THolder;
            }
        }
    } 
      
    
    // top is matrix[i][j] (held in THolder)
    // left is matrix[matrix.length - 1 - j][i]
    // right is matrix[j][matrix.length - 1 - i]
    // bottom is matrix[matrix.length - 1 - i][matrix.length - 1 - j]
    // left to top
    // bottom to left
    // right to bottom
    // top (from THolder) to right

    public static String arrayToString(int[][] a) {
        String output = "";
        for (int i = 0; i < a.length; i++) {
            output += "{";
            for (int j = 0; j < a[i].length - 1; j++) {
                output += a[i][j] + ", ";
            }
            output += a[i][a.length - 1] + "}" + "\n";
        }
        return output;
    }
}
