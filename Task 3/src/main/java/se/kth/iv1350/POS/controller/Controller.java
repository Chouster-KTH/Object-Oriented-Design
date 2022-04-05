/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.ExternalSystemCreator;
import se.kth.iv1350.POS.model.CashRegister;
import se.kth.iv1350.POS.model.Receipt;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.StoreInformation;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * This is the only controller in this application. All calls to the model pass
 * through this class.
 */
public class Controller
{

    private Sale sale;
    private final ExternalSystemCreator externalCreator;
    private final CashRegister cashRegister;

    /**
     *
     * Creates a new instance of the controller.
     *
     * @param cashRegister Used to update the cash balance.
     * @param externalCreator Used to get classes that handle external systems.
     */
    public Controller(CashRegister cashRegister, ExternalSystemCreator externalCreator)
    {
        this.externalCreator = externalCreator;
        this.cashRegister = cashRegister;
    }

    /**
     * Initiates a new sale.
     *
     * @param storeInformation Contains name and address of the store.
     */
    public void startNewSale(StoreInformation storeInformation)
    {
        this.sale = new Sale(externalCreator, storeInformation);
        externalCreator.getDisplay().displayStartSale(sale);
    }

    /**
     * Calls the scan method in sale that is used to search for items.
     *
     * @param itemIdentifier The identifier entered to identify a unique item.
     * @param quantity Determines the quantity of the item that has been
     * scanned.
     */
    public void scan(String itemIdentifier, Amount quantity)
    {
        sale.scan(itemIdentifier, quantity);

    }

    /**
     * Ends a sale and displays the total price.
     */
    public void endSale()
    {
        sale.endSale();
    }

    /**
     * Represents an instance of a payment from a customer. When this method is
     * called, sale information is shown on the screen along with the amount of
     * change to be received by the customer. A receipt is then printed.
     * Accounting system and inventory system are also updated.
     *
     * @param paidAmount The amount of cash received from the customer.
     */
    public void payment(Amount paidAmount)
    {
        externalCreator.getDisplay().displayPayment(paidAmount);
        Amount change = sale.finalizePayment(paidAmount, cashRegister);
        Receipt receipt = new Receipt(externalCreator, sale, paidAmount, change);
    }

}
