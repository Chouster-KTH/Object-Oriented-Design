/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.startup;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.ExternalSystemCreator;
import se.kth.iv1350.POS.model.CashRegister;
import se.kth.iv1350.POS.model.StoreInformation;
import se.kth.iv1350.POS.utilities.Amount;
import se.kth.iv1350.POS.view.View;

/**
 * Contains the <code>main</code> method. Starts the entire application.
 */
public class Main

/**
 * This main method is used to start the application.
 *
 * @param args This application does not take any command line parameters.
 */
{

    public static void main(String[] args)
    {
        StoreInformation storeInformation = new StoreInformation("Exclusive Boutique", "Baker Street 221B");
        ExternalSystemCreator externalCreator = new ExternalSystemCreator();
        CashRegister cashRegister = new CashRegister(new Amount(10_000), externalCreator);
        Controller contr = new Controller(cashRegister, externalCreator);
        View view = new View(contr);
        view.sampleExecution(storeInformation);
        externalCreator.getErrorLog().showErrorLog();
    }

}
