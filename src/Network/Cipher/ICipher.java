/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Cipher;

/**
 *
 * @author Ravi Desai
 */
public interface ICipher {
    
    public String encrypt(String dataword);
    public String decrypt(String dataword);
}
