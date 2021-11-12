
package labs;
public class problem05 {
    /*
     * The H fractal essentially repeatedly draws a shape similar to the letter H at
     * the four endposts (top right, bottom right, top left, bottom left). The
     * method starts drawing at the horizontal midpoint of the letter and, as a
     * result, the base case, which looks like a single line, actually starts from
     * halfway through its length, moves up half its specified length, moves down
     * its entire length using t.backward(length), and moves halfway up again. For
     * levels > 0, the method starts off by moving the turtle (from the method
     * parameter t) half the length specified in the method signature, then turns
     * the turtle 90 degrees to the left, then calls fractalH again with the same
     * turtle t, a length determined randomly to be a number between one-fourth and
     * two-thirds of the length of the current level, and a level equal to the
     * current level - 1. If the current level (from the parameters, refers to the
     * depth of recursion) is one, then the recursive call will cause the turtle to
     * draw the sides of the H as normal but, if it's greater than one, the sides
     * will recurisvely call more sides at perpendicular angles, creating the effect
     * of the shape being repeated. After the method is called recusively, the
     * turtle returns to the vertical position as the original line but facing
     * perpendiclar to it. It rotates 90 degrees to the left, draws the line of the
     * length specified forward and turns right 90 degrees to repeat the recursive
     * process that occurred on the left side of the fractal. After that, it's
     * rotated 90 degrees to the left to place it on the central line and made to
     * move length/2 so that it can either finish the method in the place it
     * started, allowing the recurson to occur predictably.
     *
     * As I mentioned briefly before, the recursive calls all take a random double
     * as an argument between 1/4 and 2/3 of the length of the previous length
     * (which was between 1/4 and 2/3 of the length previous to it unless that one's
     * the max length). This range minimizes overlap while still building randomness
     * into the geometry. To get this range, I multiplied Math.random()'s output by
     * 2/3 - 1/4 and then added 1/4 so that it's the minimum value.
     *
     * I did the colors using a method below the fractalH method. It takes the
     * current level as an argument and initalizes an integer array of length 3 with
     * elements 80 * level + 150, 20 * level + 200, and 50 * level. The degree to
     * which the level variable is manipulated is predictable and injective but
     * pretty arbitrary and occurs in large steps so that different levels can have
     * obviously distinct colors. After the array is initalized, a for loop runs to
     * check each element of the array. The for loop contains a while loop that
     * subtracts 255 from the value of each element until its value is under 255
     * (and is skipped entirely if the value is under 255). The array is then
     * returned. In the fractalH method, the turtle and its line are given a color
     * using t.color() where the elements of the array output of the method color
     * determine the value of red blue and green. The same color is applied after
     * each recursive call so that higher levels aren't colored over by the colors
     * of lower levels.
     */
    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.delay(1);
        fractalH(t, 400, 8);
        t.penup();
        t.left(90);
        t.forward(100);
        t.pendown();
        fractalH(t, 50, 3);
        t.penup();
        t.forward(100);
        t.right(90);
        t.pendown();
        fractalH(t, 75, 1);
    }

    public static void fractalH(Turtle t, double length, int level) {
        t.color(color(level)[0], color(level)[1], color(level)[2]);
        if (level == 0) {
            t.forward(length / 2);
            t.backward(length);
            t.forward(length / 2);
        } else {
            t.forward(length / 2);
            t.left(90);
            fractalH(t, length * (Math.random() * (2.0 / 3.0 - 0.25) + 0.25), level - 1);
            t.color(color(level)[0], color(level)[1], color(level)[2]);
            t.left(90);
            t.forward(length);
            t.right(90);
            fractalH(t, length * (Math.random() * (2.0 / 3.0 - 0.25) + 0.25), level - 1);
            t.color(color(level)[0], color(level)[1], color(level)[2]);
            t.right(90);
            t.forward(length / 2);
        }
    }

    public static int[] color(int level) {
        int[] colors = new int[] { 80 * level + 150, 20 * level + 200, 50 * level };
        for (int i = 0; i < 3; i++) {
            while (colors[i] > 255) {
                colors[i] -= 255;
            }
        }
        return colors;
    }

}