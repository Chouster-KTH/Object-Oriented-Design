/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

/**
 * This exception is thrown when the database cannot be called.
 */
public class DatabaseFailureException extends Exception
{
    
     /**
     * Creates a new instance of <code>DatabaseFailureException</code>.
     * @param error Cause of error.
     */
    public DatabaseFailureException(String error)
            {
                super("Database problem. ERROR: " + error + ".");
            }
}
