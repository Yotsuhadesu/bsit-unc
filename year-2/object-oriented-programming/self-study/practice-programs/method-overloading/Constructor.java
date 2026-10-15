public class Constructor {
    // overloaded constructors
    private String name;
    public Constructor() {
        System.out.println("No arg constructor.");
    }
    public Constructor(String name) {
        this.name = name;
    }
    public void greeting() {
        System.out.println("Hey " + name);
    }
}

class Main {
    public static void main(String[] args) {
        Constructor constructor1 = new Constructor();
        Constructor constructor2 = new Constructor("Hey");
        constructor1.greeting();
        constructor2.greeting();
    }
}