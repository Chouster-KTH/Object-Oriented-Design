/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.model.StoreInformation;
import se.kth.iv1350.POS.utilities.Amount;

/**
 * This class is a placeholder for the view.
 */
public class View
{

    private final Controller contr;

    /**
     * Creates a new instance that will use the specified controller for all
     * system operations.
     *
     * @param contr The controller that is used for system operations.
     */
    public View(Controller contr)
    {
        this.contr = contr;
    }

    /**
     * Calls system operations and prints the result to <code>System.out</code>.
     *
     * @param storeInformation Contains name and address of the store.
     */
    public void sampleExecution(StoreInformation storeInformation)
    {
        contr.startNewSale(storeInformation);
        contr.scan("001023", new Amount(1));
        contr.scan("923845", new Amount(2));
        contr.scan("503405", new Amount(2));
        contr.scan("001023", new Amount(1));
        contr.endSale();
        contr.payment(new Amount(8500));
    }
}
