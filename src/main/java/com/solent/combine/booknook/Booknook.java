package com.solent.combine.booknook;

/**
 *
 * @author David Mensah
 */
/**
 * Integrating all group tasks.
 *
 * -----------------------------------------------------------------------------
 * The Process:
 * -----------------------------------------------------------------------------
 * The simplest and most straightforward method we could think of is utilise all
 * three jars for Group A, Group B, and Group C, and add them as dependencies in
 * the main project.
 * -----------------------------------------------------------------------------
 * The Problem:
 * -----------------------------------------------------------------------------
 * One challenge we encountered during the import process of jars was the fact
 * that all jars were built with the same identity. This led to ambiguity when
 * attempting to import classes with the same name, such as “BookService” from
 * Group A and “BookService” from Group B. To address this issue, we
 * individually imported the entire package identity <com.solent.booknook.ga>
 * for each class.
 * -----------------------------------------------------------------------------
 *
 */
public class Booknook {

    static Combine gui = new Combine();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        gui.processMenu();
    }

}
