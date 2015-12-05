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
public class DummyCipher implements ICipher{

    @Override
    public String encrypt(String plainText) {
       return "dummy";
    }

    @Override
    public String decrypt(String cipherText) {
       return "dummy";
    }
    
    
}
