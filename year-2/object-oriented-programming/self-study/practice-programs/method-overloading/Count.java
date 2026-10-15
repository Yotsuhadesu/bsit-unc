public class Count {
    // different parameter count
    public static void area(double side) {
        System.out.println(Math.pow(side, 2));
    }
    public static void area(double length, double width) {
        System.out.println(length * width);
    }
    public static void main(String[] args) {
        area(3);
        area(2, 2);
    }
}
