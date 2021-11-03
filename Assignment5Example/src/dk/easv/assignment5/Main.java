package dk.easv.assignment5;

public class Main {

    public static void main(String[] args) {
        String[] items = {"Option1", "Option2", "Option3"};
        MainMenu mm = new MainMenu("Welcome", items);
        mm.run();

        //Test t = new Test();
        //t.runTests();
    }
}
