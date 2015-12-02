/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ravi Desai
 */
public class TCPServer {
    private ServerSocket server;
    private Socket socket;
    public void CreateServer(int port) throws IOException { 
        server = new ServerSocket(port);
        System.out.println("Server started on port: " + port);
        server.accept();
    }
    
}
