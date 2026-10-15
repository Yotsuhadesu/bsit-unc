public class Varargs {
    public static void add(int x, int y) {
        System.out.println(x + y);
    }
    public static void add(int... nums) {   // varargs
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args) {
        // the method with the exact parameter count is executed
        add(1, 1);
    }
}
