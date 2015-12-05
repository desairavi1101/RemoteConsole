/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Ravi Desai
 */
enum OS{
  OS_WINDOWS,
  OS_LINUX,
  OS_MAC
}
public class OSHelper {
    
    public static OS detect() {
        String os = System.getProperty("os.name");
        if(os.equals("Linux")) {
            return OS.OS_LINUX;
        }
        else {
            return OS.OS_WINDOWS;
        }
        
    }
    
    public static String[] getProcessCommand(String command) {
        
        String[] cmd;
        switch(detect()){
            case OS_LINUX:
                cmd = new String[]{"/bin/bash","-c",command};
                break;
            case OS_WINDOWS:
                cmd = new String[]{"cmd","/c",command};
                break;
            default:
                cmd = new String[]{"cmd","/c",command};
        }
        return cmd;
    }
    
    public static void printOSDetails(OutputStream out) {
        PrintStream writer = new PrintStream(out);
        
        writer.println("Operating System : " + System.getProperty("os.name"));
        writer.println("Version          : " + System.getProperty("os.version"));
    }
}
