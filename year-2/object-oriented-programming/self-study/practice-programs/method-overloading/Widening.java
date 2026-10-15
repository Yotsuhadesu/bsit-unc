public class Widening {
    // arguments will be promoted if there is no exact argument type found but there is a method similar name
    public static void show(int x) {    // remove this and the other method will be executed
        System.out.println(x + x);
    }
    public static void show(long x) {
        System.out.println(x * x);
    }
    public static void main(String[] args) {
        show(10);
    }
}
