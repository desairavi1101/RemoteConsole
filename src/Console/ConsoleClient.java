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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
        
        
        
        
    }
    
    public static String readInputStream(InputStream in) throws IOException {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }
    
        

}
