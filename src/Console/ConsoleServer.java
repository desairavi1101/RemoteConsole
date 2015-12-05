/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Network.Cipher.ICipher;
import Network.TCPServer;
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
public class ConsoleServer {
    
    public static void main(String[] args) {
        
        int port; 
        ICipher ciper;
        TCPServer server = new TCPServer();
        server.createServer(8080);
        server.accept();
        ConsoleExecuter executer = new ConsoleExecuter();
        executer.initilize("dir");
        try {
            executer.execute();
            InputStream processIn = executer.getErrorStream();
            OutputStream clientOut = server.getOutputStream();
            
            readInputStream(processIn, clientOut);
            
            
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
            System.out.println(line);
        } 
    }
}
