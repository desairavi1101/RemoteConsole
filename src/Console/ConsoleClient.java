/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import static Console.ConsoleServer.cipher;
import static Console.ConsoleServer.sc;
import Network.Cipher.Cipher;
import Network.Cipher.ICipher;
import Network.TCPClient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
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
public class ConsoleClient {
    
    public static void main(String[] args) {
        
        String host;
        int port; 
        ICipher ciper;
        String key ;
        String cipherType;
        
        System.out.println("Enter Host : ");
        host = sc.nextLine();
        
        System.out.println("Enter Port : ");
        port = Integer.parseInt(sc.nextLine());
        
        System.out.println("Enter Cipher Type : ");
        cipherType = sc.nextLine();
        
        System.err.println("Enter Key : ");
        key = sc.nextLine();
        
        cipher = Cipher.getCipher(cipherType,key);
        
        Scanner sc = new Scanner(System.in);
        TCPClient client = new TCPClient();
        client.connect(host,port);
        
        try {
            InputStream serverIn = client.getInputStream();
            OutputStream serverOut = client.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(serverIn));
            PrintStream writer = new PrintStream(serverOut);
            
            /*Authenticate*/
            while (true) {
                String message = reader.readLine();
                System.out.println("Message : " + message);
                String plain = cipher.decrypt(message);
                System.out.println("Decrypt : " + plain);
                writer.println(plain);
                if(plain.equals("hello")) {
                    System.out.println("Authenticated");
                    break;
                } else {
                    System.out.println("Authentication Failed");
                    System.out.println("Enter Cipher Type : ");
                    cipherType = sc.nextLine();

                    System.err.println("Enter Key : ");
                    key = sc.nextLine();
                }
            }
            
            OutputStream out = new ByteArrayOutputStream();
            // readInputStream(serverIn, out);
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
