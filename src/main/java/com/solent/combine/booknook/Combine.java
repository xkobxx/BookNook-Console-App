package com.solent.combine.booknook;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import java.util.Scanner;

/**
 *
 * @author David Mensah
 */
public class Combine {

    /**
     *
     */
    public static com.solent.booknook.ga.BookService ga_bookService = new com.solent.booknook.ga.BookService();

    /**
     *
     */
    public static com.solent.booknook.ga.ui.GuiController ga_gui = new com.solent.booknook.ga.ui.GuiController();

    /**
     *
     */
    public static com.solent.booknook.gb.BookService gb_bookService = new com.solent.booknook.gb.BookService();

    /**
     *
     */
    public static com.solent.booknook.gb.ui.GuiController gb_gui = new com.solent.booknook.gb.ui.GuiController();

    /**
     *
     */
    public static com.solent.booknook.gc.BookService gc_bookService = new com.solent.booknook.gc.BookService();

    /**
     *
     */
    public static com.solent.booknook.gc.ui.GuiController gc_gui = new com.solent.booknook.gc.ui.GuiController();

    /**
     * Display simple information message when user is at main screen.
     */
    public static void displayInformation() {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(" Running groups combine work.");
        asciiTable.addRow(" We simplified the process by adding Individual Groups jar files.");
        asciiTable.addRow(" We only need to modify group work a few times.");
        asciiTable.addRule();
        asciiTable.setTextAlignment(TextAlignment.JUSTIFIED_LEFT);
        String render = asciiTable.render(60);
        System.out.println(render);
    }

    /**
     * Creates main menu.
     */
    public static void createStartMenu() {
        Combine.displayInformation();
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("  Select Group Tasks");
        asciiTable.addRule();
        asciiTable.addRow("[1]        Group Member A Tasks");
        asciiTable.addRow("[2]        Group Member B Tasks");
        asciiTable.addRow("[3]        Group Member C Tasks");
        asciiTable.addRow("[4]        Exit");
        asciiTable.addRule();
        asciiTable.addRow("  Select from the options [1... 4]");
        asciiTable.addRule();
        asciiTable.setTextAlignment(TextAlignment.JUSTIFIED_LEFT);
        String render = asciiTable.render(60);
        System.out.println(render);
    }

    /**
     *
     * @param message
     */
    public void exitMessage(String message) {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(message);
        asciiTable.addRule();
        asciiTable.setTextAlignment(TextAlignment.JUSTIFIED_LEFT);
        String render = asciiTable.render(50);
        System.out.println(render);
    }

    /**
     * Shows Group A Tasks.
     */
    public void displayMenuGroupA() {
        ga_gui.appStart("Welcome to Booknook Group A Tasks");
    }

    /**
     * Shows Group B Tasks.
     */
    public void displayMenuGroupB() {
        gb_gui.appStart("Welcome to Booknook Group B Tasks");
    }

    /**
     * Shows Group C Tasks.
     */
    public void displayMenuGroupC() {
        gc_gui.appStart("Welcome to Booknook Group C Tasks");

    }

    /**
     * Start Console Menu and Loop through it until user choose to exit the
     * system.
     */
    public void processMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean action = true;
        //String getKey="";

        while (action) {
            ga_gui.clearScreen();
            this.createStartMenu();
            int getKey = 0;
            String key = scanner.next();
            try {
                //getKey = (key.toUpperCase());
                getKey = Integer.parseInt(key);
                switch (getKey) {
                    case 1:
                        this.displayMenuGroupA();
                        break;
                    case 2:
                        this.displayMenuGroupB();
                        break;
                    case 3:
                        this.displayMenuGroupC();
                        break;
                    case 4:
                        this.exitMessage("Thank you for using BookNook.");
                        System.exit(0);
                        action = false;
                    default:

                        break;
                }

            } catch (Exception e) {
                System.out.println("Please Enter numbers only");
            }
        }

    }

}
