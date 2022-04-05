/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;

/**
 * Represents a log that contains information about errors that occur in the program.
 *
 */
public class ErrorLog
{

    private final HashMap<LocalDateTime, String> errorLog;

    /**
     * Creates a new instance of an error log.
     */
    public ErrorLog()
    {
        this.errorLog = new HashMap<>();

    }

    /**
     * Add a message to the error log.
     * @param message The message to be added.
     */
    public void addToLog(String message)
    {
        LocalDateTime timeOfError;
        timeOfError = LocalDateTime.now();
        errorLog.put(timeOfError, message);
    }

    /**
     * Notifies developers of errors.
     */
    public void showErrorLog()
    {
        System.out.println("-----------------------------------------------");
        System.out.println("Notifying developers");

        Set<LocalDateTime> keySet = errorLog.keySet();
        for (LocalDateTime dateTime : keySet)
        {
            String msg = errorLog.get(dateTime);
            System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " " + msg);

        }

    }

}
