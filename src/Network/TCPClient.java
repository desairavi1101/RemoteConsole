/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Ravi Desai
 */
public class TCPClient {
    
    private Socket socket;
    
    public TCPClient() {
        
    }
    
    public TCPClient(String host,int port) {
        connect(host, port);
    }
    
    public void connect(String host,int port) {
        try {
            socket = new Socket(host, port);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }
    
    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    } 
    public void disconnect() {
        try {
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
