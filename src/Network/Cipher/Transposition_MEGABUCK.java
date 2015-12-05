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
public class Transposition_MEGABUCK implements ICipher{
    
        String key;
	String ikey;
	int row,col;
        
    @Override
    public String encrypt(String plainText) {
        plainText = plainText.toUpperCase();
		while(plainText.length()%key.length() != 0)
			plainText += "@";

		col = key.length();
		row = plainText.length() / col;

		char ary[][] = new char[row][col];
		int k = 0;
		for(int i = 0 ; i < row ; i ++)
		{
			ary[i] = plainText.substring(k,k+key.length()).toCharArray();
			k += key.length();
		}
		/*for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < col ; j++)
				System.out.print(ary[i][j] + " ");

			System.out.println("\n");
		}*/


		String cipherText = "";
		for(int i = 0 ; i < key.length(); i++)
		{
			int index = ikey.indexOf(Integer.toString(i+1));
			for(int j = 0 ; j < row ; j++)
				cipherText += ary[j][index];
		}
		return cipherText;
    }

    @Override
    public String decrypt(String cipherText) {
       char ary[][] = new char[row][col];
		int k = 0;
		for(int i = 0 ; i < col ; i++)
		{
			int index = ikey.indexOf(Integer.toString(i+1));
			for(int j = 0 ; j < row ; j++)
			{
				ary[j][index] = cipherText.charAt(k++);
			}
		}
		String plainText="";
		for(int i = 0 ; i < row ; i++)
		{
			plainText += new String(ary[i]);
		}

		return plainText;
    }
    
}
