/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.io.IOException;
import java.io.InputStream;


/**
 *
 * @author Ravi Desai
 */
public class ConsoleExecuter {
   
    private ProcessBuilder pb;
    public Process process;
    public ConsoleExecuter() {
        
    }
    
    public void initilize(String command) {
        if(System.getProperty("os.name").equals("Linux")){
            String[] cmd = {"/bin/bash", "-c", command};
            pb = new ProcessBuilder(cmd);
            
        }
        else{
            String[] cmd = {"cmd", "/c", command};
            pb = new ProcessBuilder(cmd);
        }
    }
    
    public void execute() throws IOException {
        process = pb.start();
    }
    
    public InputStream getInputStream() {
        return process.getInputStream();
    } 
    
    public InputStream getErrorStream() {
        return process.getInputStream();
    } 
    
    public void execute(String command) {
        
    }
    
}
