/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.StoreInformation;

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

    /**
     * Creates the external system creator.
     *
     * @param storeInformation Contains name and address of the store.
     */
    public ExternalSystemCreator()
    {
        inventorySystem = new InventorySystem();
        display = new Display();
        accounting = new AccountingSystem();
        printer = new Printer();

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
     * Get the value of the accounting system.
     *
     * @return The value of the accounting system.
     */
    public AccountingSystem getAccounting()
    {
        return accounting;
    }

}
