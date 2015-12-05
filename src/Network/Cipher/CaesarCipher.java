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
public class CaesarCipher implements ICipher {
    public int key;
    private static String alpha = "abcdefghijklmnopqrstuvwxyz";
    
    @Override
    public String encrypt(String plainText) {
        String temp = "";
        plainText = plainText.toLowerCase();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            temp += alpha.charAt(((int) ch - 97 + key) % 26);
        }

        return temp;
    }
    
    @Override
    public String decrypt(String cipherText) {
        String temp = "";
        cipherText = cipherText.toLowerCase();

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
			int index = ((int) ch - 97 - key + 26) % 26;
        	temp += alpha.charAt(index);
        }
        return temp;
    }
    
}
