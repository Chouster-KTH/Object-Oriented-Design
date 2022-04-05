/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Prints log messages to a file. The log file will be in the current directory
 * and will be called log.txt.
 */
public class FileLogger
{

    private PrintWriter logStream;

    /**
     * Creates a new instance and also creates a new log file. An existing log
     * file will be deleted.
     */
    public FileLogger()
    {
        try
        {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);

        } catch (IOException ioe)
        {
            System.out.println("CANNOT LOG.");
        }
    }

    /**
     * Prints a string to a log file.
     *
     * @param message The message to be printed to the log file.
     */
    public void log(String message)
    {
        logStream.println(message);
    }
}
