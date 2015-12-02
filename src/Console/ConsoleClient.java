/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Network.TCPClient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ravi Desai
 */
public class ConsoleClient {
    
    public static void main(String[] args) {
        TCPClient client = new TCPClient();
        client.connect("localhost", 8080);
        
        try {
            InputStream serverIn = client.getInputStream();
            
            OutputStream out = new ByteArrayOutputStream();
            readInputStream(serverIn, out);
        } catch (IOException ex) {
            
        }
       
        
        
        
        
        
        
        
    }
    
    public static void readInputStream(InputStream in,OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        PrintStream printstream = new PrintStream(out);
        
        while((line = reader.readLine()) != null) {
            printstream.println(line);
            System.out.println(line);
        } 
    }       
}
