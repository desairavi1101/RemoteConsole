/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ravi Desai
 */
public class ConsoleExecuter {
    private Process process;
    private IOThreadHandeler ioThread;
    private IOThreadHandeler errThread;
    private InputStream in;
    private InputStream err;
    private OutputStream out;
    
    public ConsoleExecuter() {
       
    }
    
    public void createProcess(String startCommand) {
        ProcessBuilder pb = new ProcessBuilder(startCommand);
        try {
            process = pb.start();
            in = process.getInputStream();
            out = process.getOutputStream();
            err = process.getErrorStream();
            ioThread = new IOThreadHandeler(in);
            errThread = new IOThreadHandeler(err);
            ioThread.start();
            errThread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void execute(String command) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            Scanner sc = new Scanner(new InputStreamReader(in));
             {
                writer.write(command);
                writer.newLine();
                writer.flush();
            }
            
            
   
        } catch (IOException ex) {
            ex.printStackTrace();   
        }
    }
    
    public void exit() {
        try {
            ioThread.stop();
            process.destroy();
            in.close();
            out.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        ConsoleExecuter console = new ConsoleExecuter();
        console.createProcess("cmd");
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.print("Enter Command : ");
            String cmd = sc.nextLine();
            console.execute(cmd);
        }  
       
    }
    
    
}
