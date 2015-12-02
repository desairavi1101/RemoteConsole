/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Ravi Desai
 */
public class IOThreadHandeler extends Thread{
    private InputStream in;
    private StringBuffer sb;
        
    public IOThreadHandeler(InputStream in) {
        this.in = in;
        sb = new StringBuffer();
    }
    
    public void run() {
        try {
            Scanner sc = new Scanner(new InputStreamReader(in));
            while(true) {
                 {
                    while(sc.hasNext()) {
                        System.out.println();
                        System.out.print(sc.nextLine());
                    }
                }
            }
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String getOutput() {
        return sb.toString();
    }
}
