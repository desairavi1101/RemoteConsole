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
public class RSACipher implements ICipher{
    
    int n,z;
    int e,d;
    
    @Override
    public String encrypt(String plainText) {
        String cipherText = "";

		for(int i = 0 ; i < plainText.length(); i++)
		{
			int m = plainText.charAt(i) - 96;

			int c = (int)Math.pow(m,e)%n;


			cipherText += Integer.toString(c) ;

			System.out.println("m : " + m + " c : " + c);

			cipherText += "#";
		}

		return cipherText;
    }

    @Override
    public String decrypt(String cipherText) {
        String plainText = "";

		for(int i = 0 ; i < cipherText.length();)
		{
			int temp = cipherText.indexOf("#",i);
			int c = Integer.parseInt(cipherText.substring(i,temp));
			i = temp + 1;

			int m = (int)Math.pow(c,d) % n ;
			System.out.println("c : " + c + " m : " + m );

			char ch = (char)(m+96);
			plainText += ch;
		}
		return plainText;
    }
    
    
}
