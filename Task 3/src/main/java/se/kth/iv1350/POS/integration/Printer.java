/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

/**
 *
 * Represents a printer that prints a receipt.
 */
public class Printer
{

    /**
     * Prints a string on the receipt, starting from the same line as the
     * previous printout.
     *
     * @param str The String to be printed on the receipt.
     */
    public void printString(String str)
    {
        System.out.print(str);
    }

    /**
     * Prints a string on the receipt, starting from a new line.
     *
     * @param str The String to be printed on the receipt.
     */
    public void printStringLn(String str)
    {
        System.out.println(str);
    }
}
