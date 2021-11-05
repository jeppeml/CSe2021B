package dk.easv.assignment5;

import java.util.Scanner;

/**
 * Abstract class implementing the basic functionality of a console based
 * menu class. A menu can be created by sub-classing this class and implement
 * the abstract method doAction(option).
 * <p>
 * The constructor of the sub-class must invoke the super-class constructor by
 * the instruction
 * <p>
 * super(“some header”, “menuoption1", "menuoption2");
 * <p>
 * Note, that this instruction must be the first instruction of the sub-class
 * constructor.
 *
 * @author bhp
 */
public abstract class Menu {
    // value used to exit the menu.
    // the value can be changed by the sub-class constructor.
    protected int EXIT_OPTION = 0;

    // The menu header text
    private String header;

    // The list of menu options texts.
    private String[] menuItems;

    /**
     * Abstract method stating what should be done, when a
     * menu option is selected.
     * The method must be overridden by the sub-class.
     *
     * @param option the menu option that has been selected.
     */
    protected abstract void doAction(int option);


    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     *
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public Menu(String header, String... menuItems) {
        this.header = header;
        this.menuItems = menuItems;
    }

    /**
     * Executes the menu until the EXIT_OPTION has been selected.
     * This is an implementation of the Template Method design pattern.
     */
    public void run() {
        boolean done = false;
        while (!done) {
            showMenu();
            int option = getOption();
            doAction(option);
            if (option == EXIT_OPTION) {
                done = true;
            }
        }
    }

    /**
     * Returns a valid menu-option input from the keyboard.
     * The method continues prompting for an option value, until
     * a valid option has been input.
     *
     * @return A valid menu option.
     */
    private int getOption() {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            int intInput = Integer.parseInt(input);
            return intInput;
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number, please type in a number");
        }
        return 0;


    }

    /**
     * Prints out a console menu
     * with a header text and a list
     * of menu options. The menu
     * options will be assigned the numbers
     * from 1 to the number of
     * options in the menu.
     */
    private void showMenu() {
        System.out.println(createFancyHeader(header));
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ": " + menuItems[i]);
        }
        System.out.print(">");
    }

    private String createFancyHeader(String header) {
        String top = "_.--.__.-'\"\"`-.__.--.__.-'\"\"`-.__.--.__.-'\"\"`-.__.--.__.-'\"\"`-._";
        String end = "\"`--'\"\"`-.__.-'\"\"`--'\"\"`-.__.-'\"\"`--'\"\"`-.__.-'\"\"`--'\"\"`-.__.-'\"";
        String menuText = header;
        int spacing = top.length() / 2 - menuText.length() / 2;
        String space = "";
        for (int i = 0; i < spacing - 2; i++)
            space += " ";

        return top + "\n" + "|" + space + menuText + space + "|\n" + end;
    }

    /**
     * Waits until the 'enter' key is pressed.
     */
    protected void pause() {
        new Scanner(System.in).nextLine();
    }

    /**
     * Clears the screen by writing several empty lines.
     */
    protected void clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

}
