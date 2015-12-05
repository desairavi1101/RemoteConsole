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
public class XORCipher implements ICipher{
String key;
    @Override
    public String encrypt(String plainText) {
        String temp="" ;

		for(int i = 0 ; i < plainText.length() ; i++) {
			if(plainText.charAt(i) == key.charAt(i%key.length()))
				temp += "0";
			else
				temp += "1";
		}
		return temp;
    }

    @Override
    public String decrypt(String cipherText) {
        String temp = encrypt(cipherText);
		return temp;
    }
    
}
