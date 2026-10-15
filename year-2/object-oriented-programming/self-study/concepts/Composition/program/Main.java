package program;
public class Main {
    public static void main(String[] args) {
        Coop coop = new Coop("Konoha", 1);
        Farm farm = new Farm();
        farm.addChicken("Naruto", coop);
        farm.addChicken("Sasuke", coop);
        farm.addChicken("Sakura", coop);
        farm.printAllChickens();
    }
}
