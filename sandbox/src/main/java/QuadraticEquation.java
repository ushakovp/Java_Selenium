public class QuadraticEquation {

    private final double a;
    private final double b;
    private final double c;
    private final int n;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        double d = b * b - 4 * a * c;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    n = -1;
                } else
                    n = 0;
            } else {
                n = 1;
            }
        } else {
            if (d > 0) {
                n = 2;
            } else if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }
        }
    }

    public int getN() {
        return n;
    }
}
