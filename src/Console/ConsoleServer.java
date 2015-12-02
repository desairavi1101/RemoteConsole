/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Network.TCPServer;

/**
 *
 * @author Ravi Desai
 */
public class ConsoleServer {
    
    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        ConsoleExecuter executer = new ConsoleExecuter();
        
    }
}
