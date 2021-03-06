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
        String[] cmd = OSHelper.getProcessCommand(command);
        pb = new ProcessBuilder(cmd);
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
    public int getExitCode() throws InterruptedException  {
        return process.waitFor();
    }
    
 
    
}
