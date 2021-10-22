package labs;
public class lab04 {
/*
     * This code was worked on by Zachariah Dawood, Adrian Valencia Fernandez, and
     * Ashwin Ujure Zachariah wrote the methods for finding the areas of the shaded
     * regions and implemented them. The team worked collaboratively to find the
     * acculumation necessary to do the getEquation method and implement both the
     * numerical result and the string equation into one method
     */

    public static void main(String[] args) {
        System.out.println("Problem 1: Calculate the area of shaded area (two triangles)");
        int square_side = 4;

        // Here should should calculate the shaded area and store it to 'shaded_area_p1'
        double shaded_area_p1 = area_square(square_side) - 2 * area_triangle(square_side / 2, square_side);
        System.out.println("The shaded area of is " + shaded_area_p1);

        System.out.println("Problem 2: Calculate the area of shaded area (ring)");
        int radius_long = 4;
        int radius_short = 2;

        // Here should should calculate the shaded area and store it to 'shaded_area_p2'
        double shaded_area_p2 = area_circle(radius_long) - area_circle(radius_short);
        System.out.println("The shaded area of is " + shaded_area_p2);

        System.out.println("Problem 3: Calculate the area of shaded area (rectangle)");
        int radius = 2;
        int rectangle_length = 12;
        int rectangle_width = 8;

        // Here should should calculate the shaded area and store it to 'shaded_area_p3'
        double shaded_area_p3 = area_rectangle(rectangle_length, rectangle_width) - 4 * area_circle(radius);
        System.out.println("The shaded area of is " + shaded_area_p3);

        System.out.println("Problem 4: Display the equation and results");
        int n_1 = 6;
        int n_2 = 10;

        // Here should should store the equation to 's1' and 's2'

        String s1 = getEquation(n_1);
        String s2 = getEquation(n_2);

        System.out.println("Problem 4: The equation of n_1 is: " + s1);
        System.out.println("Problem 4: The equation of n_2 is: " + s2);
    }

    public static double area_circle(int radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double area_square(int side) {
        return Math.pow(1.0 * side, 2);
    }

    public static double area_triangle(int base, int height) {
        return (base * height) / 2.0;
    }

    public static double area_rectangle(int length, int width) {
        return length * width * 1.0;
    }

    public static String getEquation(int n) {
        String equation = "";
        double result = 0;
        for (int i = 1; i <= n; i++) {
            equation += "+ 1/2^" + i + " ";
        }
        for (int k = 1; k <= n; k++) {
            result += Math.pow(2, -k);
        }
        System.out.println("The final result of " + n + " is " + result);
        return equation;
    }
}