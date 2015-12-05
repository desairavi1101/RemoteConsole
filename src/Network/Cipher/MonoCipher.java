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
public class MonoCipher implements ICipher{
    public int key;
    
    public MonoCipher(String key) {
        this.key = Integer.parseInt(key);
    }
    
    @Override
    public String encrypt(String plainText) {
        return plainText;
    }
    
    @Override
    public String decrypt(String plainText) {
        return plainText;
    }
    
}
