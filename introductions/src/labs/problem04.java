package labs;

public class problem04 {
    /*
     * I begin this problem by creating two helper methods circle and halfCircle.
     * Both of these use the formula that describes the relationship between the
     * side length of a polygon, the number of sides, and its radius where
     * sideLength = 2 * r * Math.sin(Math.PI / n) where radius is r and n is the
     * number of sides. I arbitrarily set n to 30 in the case of the circle method
     * and 40 in the case of the halfcircle method (because it divides evenly into
     * 4) and sidelength is calculated from the method's r argument. Both of these
     * use for loop that move the turtle forward by sidelength and then left by 360
     * / n from i = 0 to i = n - 1. After that, I move the turtle forward
     * sideLength/2 so that it is at the extreme lowest point of the circle. For the
     * halfCircle method, I have the turtle lift the pen up at i = 10 and put it
     * down again at i = 31 (one-fourth of the way through and three-fourth of the
     * way through) so that only half of the circle is visible. The mickeyFace
     * method heavily uses the circle methods. First, it draws a circle of radius r
     * specified in the argument. The turtle then moves up r and to the left by r /
     * 3 (because the circle needs to be scaled, all distances have to be related to
     * r) to draw the left eye and right (each of which have radius r/8 and are
     * drawn with the circle method) by 2r/3 to draw the right eye. The turtle moves
     * to the middle of the circle, moves down r/6 units to draw the nose (by using
     * a for loop to draw an equalaterial triangle of side length r/6). The turtle
     * ends at the top of the nose triangle and moves forward 3r/6 before drawing a
     * halfCircle for the mouth and it moves down 2r/6 to return to the lowest point
     * on the circle.
     *
     * The recursive method fractalMickeyMouse is pretty straightforward but just
     * has a lot of urtle movement that makes it look more complicated than it is.
     * The base case when level == 0 is that it draws the mickeyFace with radius
     * r.The recursive case draws a mickeyFace of radius r, then positions the
     * turtle so that another mickeyFace of radius r/2 would tangentially touch the
     * original at one point at the top-left. I determined that, from the base of
     * the first mickeyFace, 1.27 * r units back and 11 * r / 8 units up puts the
     * turtle in a good position to call fractalMickeyMouse again with the same
     * turtle, radius equal to r/2 and level equal to the current level minus one.
     * If the current level is one, only one ear will be drawn but, if the level is
     * more, left ears will continue to be drawn until the method hits zero. After
     * the fractalMickeyMouse is called for the left ear, the turtle is moved 2.2 *
     * r, which puts it in position to draw the right ear, also done by calling
     * fractalMickeyMouse. AFter that, the turtle returns to the base of the very
     * first face. From the main method, the turtle turns green and fills the rest
     * of the space with green.
     */
    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.delay(1);
        fractalMickeyMouse(t, 120, 6);
        t.forward(10);
        t.color("green");
        t.fill();
    }

    public static void fractalMickeyMouse(Turtle t, double r, int level) {
        if (level == 0) {
            mickeyFace(t, r);
        } else {
            mickeyFace(t, r);
            t.penup();
            t.backward(1.27 * r);
            t.left(90);
            t.forward(11 * r / 8);
            t.right(90);
            t.pendown();
            fractalMickeyMouse(t, r / 2, level - 1);
            t.penup();
            t.forward(2.2 * r);
            t.pendown();
            fractalMickeyMouse(t, r / 2, level - 1);
            t.penup();
            t.backward(r);
            t.right(90);
            t.forward(11 * r / 8);
            t.left(90);
        }
    }

    public static void mickeyFace(Turtle t, double r) {
        circle(t, r);
        t.penup();
        t.left(90);
        t.forward(r);
        t.right(90);
        t.backward(r / 3);
        t.left(90);
        t.pendown();
        circle(t, r / 8);
        t.penup();
        t.right(90);
        t.forward(2 * r / 3);
        t.right(90);
        t.pendown();
        circle(t, r / 8);
        t.penup();
        t.left(90);
        t.backward(r / 3);
        t.right(90);
        t.forward(r / 6);
        t.pendown();
        t.right(30);
        for (int i = 0; i < 3; i++) {
            t.forward(r / 6);
            t.left(120);
        }
        t.penup();
        t.left(30);
        t.forward(3 * r / 6);
        t.left(90);
        t.pendown();
        halfCircle(t, r / 4);
        t.penup();
        t.right(90);
        t.forward(2 * r / 6);
        t.left(90);
    }

    public static void circle(Turtle t, double r) {
        double sideLength = 2 * r * Math.sin(Math.PI / 30);
        for (int i = 0; i < 30; i++) {
            t.forward(sideLength);
            t.left(360.0 / 30);
        }
        t.forward(sideLength / 2);
    }

    public static void halfCircle(Turtle t, double r) {
        double sideLength = 2 * r * Math.sin(Math.PI / 40);
        for (int i = 0; i < 40; i++) {
            if (i == 10) {
                t.penup();
            } else if (i == 31) {
                t.pendown();
            }
            t.forward(sideLength);
            t.left(360.0 / 40);
        }
        t.forward(sideLength / 2);
    }
}