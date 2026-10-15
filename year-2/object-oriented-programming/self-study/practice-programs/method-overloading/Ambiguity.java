public class Ambiguity {
    // different parameter order, passed values needs promotion
    public static void add(int x, double y) {
        System.out.println(x + y);
    }
    public static void add(double x, int y) {
        System.out.println(x + y);
    }
    public static void main(String[] args) {
        add(5, 5);  // Compile-time Error: Java doesn't know which parameter to promote
    }
}
