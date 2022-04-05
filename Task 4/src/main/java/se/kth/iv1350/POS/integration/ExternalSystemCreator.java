/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

/**
 *
 * This class is used to initiate all external systems that are needed for this
 * application.
 */
public class ExternalSystemCreator
{

    private final InventorySystem inventorySystem;
    private final Display display;
    private final AccountingSystem accounting;
    private final Printer printer;
    private final ErrorLog errorLog;

    /**
     * Creates the external system creator.
     *
     */
    public ExternalSystemCreator()
    {
        inventorySystem = new InventorySystem();
        display = new Display();
        accounting = new AccountingSystem();
        printer = new Printer();
        errorLog = new ErrorLog();

    }

    /**
     * Get the value of the inventory system.
     *
     * @return The value of the inventory system.
     */
    public InventorySystem getInventorySystem()
    {
        return inventorySystem;
    }

    /**
     * Get the value of the display.
     *
     * @return The value of the display.
     */
    public Display getDisplay()
    {
        return display;
    }

    /**
     * Get the value of the printer.
     *
     * @return The value of the printer.
     */
    public Printer getPrinter()
    {
        return printer;
    }
    
    /**
     * Get the error log.
     * @return The value of the error log.
     */
    public ErrorLog getErrorLog()
    {
        return errorLog;
    }

    /**
     * Get the value of the accounting system.
     *
     * @return The value of the accounting system.
     */
    public AccountingSystem getAccounting()
    {
        return accounting;
    }

}
