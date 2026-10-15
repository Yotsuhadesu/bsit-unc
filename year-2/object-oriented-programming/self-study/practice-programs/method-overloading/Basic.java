public class Basic {
    // different parameter types
    public static void add(int x, int y) {
        System.out.println(x + y);
    }
    public static void add(double x, double y) {
        System.out.println(x + y);
    }
    public static void main(String[] args) {
        add(1, 1);
        add(1.0, 1.0);
    }
}
