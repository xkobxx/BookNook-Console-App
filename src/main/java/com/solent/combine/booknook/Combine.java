package com.solent.combine.booknook;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import java.util.Scanner;

/**
 *
 * @author David Mensah
 */
/**
 * Central coordination class for the BookNook application that integrates
 * functionalities from multiple group components. This class serves as the main
 * entry point and orchestrates the interaction between different group modules.
 *
 * The class manages: - Integration of services from Groups A, B, and C -
 * Unified menu system for accessing group-specific functionalities -
 * Centralized navigation and control flow - Consistent user interface
 * presentation
 *
 */
public class Combine {

    // Service instances for Group A functionality
    public static com.solent.booknook.ga.BookService ga_bookService = new com.solent.booknook.ga.BookService();
    public static com.solent.booknook.ga.ui.GuiController ga_gui = new com.solent.booknook.ga.ui.GuiController();

    // Service instances for Group B functionality
    public static com.solent.booknook.gb.BookService gb_bookService = new com.solent.booknook.gb.BookService();
    public static com.solent.booknook.gb.ui.GuiController gb_gui = new com.solent.booknook.gb.ui.GuiController();

    // Service instances for Group C functionality
    public static com.solent.booknook.gc.BookService gc_bookService = new com.solent.booknook.gc.BookService();
    public static com.solent.booknook.gc.ui.GuiController gc_gui = new com.solent.booknook.gc.ui.GuiController();

    /**
     * As the group leader, I member A created this display table with ASCII
     * Displays informational message about the combined group functionality.
     * Provides context about the integration approach and system architecture.
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
     * Member B created the start menu: Creates and displays the main menu
     * interface. Presents options for accessing different group functionalities
     * and system-wide operations.
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
     * As Group member C, I created this exit menu which: Displays formatted
     * exit message when user terminates the application.
     *
     * @param message The exit message to display
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
     * Initializes and displays Group A specific functionality interface.
     * Delegates control to Group A's GUI controller.
     */
    public void displayMenuGroupA() {
        ga_gui.appStart("Welcome to Booknook Group A Tasks");
    }

    /**
     * Group Member B Initializes and displays Group B specific functionality
     * interface. Delegates control to Group B's GUI controller.
     */
    public void displayMenuGroupB() {
        gb_gui.appStart("Welcome to Booknook Group B Tasks");
    }

    /**
     * Group Member C Initializes and displays Group C specific functionality
     * interface. Delegates control to Group C's GUI controller.
     */
    public void displayMenuGroupC() {
        gc_gui.appStart("Welcome to Booknook Group C Tasks");
    }

    /**
     * Main control loop for the application. Manages the primary menu system
     * and handles user input for navigation between different group
     * functionalities. Continues processing until user chooses to exit the
     * system.
     *
     * Implements input validation and error handling for menu selection.
     */
    public void processMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean action = true;

        while (action) {
            ga_gui.clearScreen();
            this.createStartMenu();
            int getKey = 0;
            String key = scanner.next();
            try {
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
                        this.exitMessage("Thank you for using BookNook Console App.");
                        System.exit(0);
                        action = false;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please Input numbers only");
            }
        }
    }
}
