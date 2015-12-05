/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Cipher;

/**
 *
 * @author lokesh
 */
public class RotationCipher implements ICipher{
    
    int key;

    public RotationCipher(String key) {
        this.key = Integer.parseInt(key);
        
    }
    
    @Override
    public String encrypt(String plainText) {
        String temp = plainText;

        for (int i = 0; i < key; i++) {
            char ch = temp.charAt(temp.length()-1);

            temp = temp.substring(0, temp.length() - 1);

            temp = ch+temp;

        }
        return temp;
    }

    @Override
    public String decrypt(String cipherText) {
        String temp = cipherText;

        for (int i = 0; i < key; i++) {
            char ch = temp.charAt(0);
            temp = temp.substring(1, temp.length());
            temp += ch;
        }
        return temp;
    }
    
    
}
