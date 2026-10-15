public class Order {
    // different parameter order
    public static void display(String name, int age) {
        System.out.printf("The name is %s, age is %d\n", name, age);
    }
    public static void display(int age, String name) {
        System.out.printf("Age is %d, the name is %s\n", age, name);
    }
    public static void main(String[] args) {
        display("Jean",19);
        display(18, "Lisa");
    }
}
