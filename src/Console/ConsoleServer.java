/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Network.Cipher.Cipher;
import Network.Cipher.ICipher;
import Network.TCPServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Ravi Desai
 */
public class ConsoleServer {
    
    public static ICipher cipher;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int port; 
        ICipher ciper;
        String key ;
        String cipherType;
        
        System.out.println("Enter Port : ");
        port = Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter Cipher Type : ");
        cipherType = sc.nextLine();
        
        System.err.println("Enter Key : ");
        key = sc.nextLine();
        
        cipher = Cipher.getCipher(cipherType,key);
       
        TCPServer server = new TCPServer();
        server.createServer(port);
        System.out.println("Server is running on port : " + port);
        
        server.accept();
        
        /*Authenticate*/
        String message = "hello";
        
        //ConsoleExecuter executer = new ConsoleExecuter();
        //executer.initilize("dir");
        try {
            // InputStream processIn = executer.getErrorStream();
            OutputStream clientOut = server.getOutputStream();
            InputStream clientIn = server.getInputStream();
            PrintStream writer = new PrintStream(clientOut);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientIn));
            
            /*Authenticate*/
            while(true) {
                System.out.println("Enc : "+ cipher.encrypt(message));
                writer.println(cipher.encrypt(message));
                String receiveMessage = reader.readLine();
                if(receiveMessage.equals(message)) {
                    System.out.println("Authenticated");
                    break;
                } else {
                    System.err.println("Authentication Failed");
                }
            }
            
            /*Send OS Details */
            OSHelper.printOSDetails(clientOut);
            
            //readInputStream(processIn, clientOut);
            
            
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
    
    public static boolean authenticate() {
        
        
    
        return true;
    }
}
