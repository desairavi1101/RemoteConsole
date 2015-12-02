/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Network.TCPClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Ravi Desai
 */
public class ConsoleClient {
    
    public static void main(String[] args) {
        TCPClient client = new TCPClient();
        ConsoleExecuter executer = new ConsoleExecuter();
        executer.initilize("dir");
        try {
            executer.execute();
            InputStream is = executer.getInputStream();
            InputStream err = executer.getErrorStream();
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
        
        
        
        
    }
    
    public static void readInputStream(InputStream in,OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        PrintStream printstream = new PrintStream(out);
        
        while((line = reader.readLine()) != null) {
            printstream.println(line);
        }
        
        
    }
    
        

}
