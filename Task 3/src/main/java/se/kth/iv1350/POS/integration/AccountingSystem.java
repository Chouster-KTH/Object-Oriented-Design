/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.time.LocalDateTime;
import java.util.HashMap;
import se.kth.iv1350.POS.model.Sale;

/**
 *
 * Represents an external accounting system.
 */
public class AccountingSystem
{

    private final HashMap<LocalDateTime, Sale> accountingSystem;

    /**
     * Creates a new instance of a fake accounting system.
     */
    public AccountingSystem()
    {
        this.accountingSystem = new HashMap<>();
    }

    /**
     * Updates external accounting system with the last sale.
     *
     * @param sale The sale that was just finalized.
     */
    public void updateAccountingSystem(Sale sale)
    {
        LocalDateTime saleTime = LocalDateTime.now();
        accountingSystem.put(saleTime, sale);
    }

}
