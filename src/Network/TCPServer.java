/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ravi Desai
 */

public class TCPServer {
    private ServerSocket server;
    private Socket socket;
    
    public TCPServer() {
       
    }
    
    public TCPServer(int port) {
        createServer(port);
    }
    
    public void createServer(int port) { 
        try {
            server = new ServerSocket(port);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void accept() {
        try {
            socket = server.accept();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }
    
    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }    
    
    public void disconnect(){
        try {
            socket.close();
            server.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } 
}
