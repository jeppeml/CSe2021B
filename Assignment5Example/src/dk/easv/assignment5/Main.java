package dk.easv.assignment5;

public class Main {

    public static void main(String[] args) {
        PersonManager pm = new PersonManager();
        Test t = new Test();
        t.fillMockData(pm);
        t.printTests(pm);
        MainMenu mm = new MainMenu(pm);
        mm.run();
    }
}
