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
public class PolyCipher implements ICipher{
    
    private static char[][] V_tbl = new char[26][26];
    private String key;
    private static String alpha = "abcdefghijklmnopqrstuvwxyz";
    public PolyCipher(String key) {
        this.key = key;
        for (int i = 0; i < 26; i++) {
            System.out.println(alpha);

            V_tbl[i] = alpha.toCharArray();
            char ch = alpha.charAt(0);
            alpha = alpha.substring(1, alpha.length());

            alpha += ch;
        }
    }
       
    @Override
    public String encrypt(String plainText) {
        String temp = "";
        plainText = plainText.toLowerCase();
        for (int i = 0; i < plainText.length(); i++) {
            int a = (int) plainText.charAt(i) - 97;
            int b = (int) key.charAt(i % key.length()) - 97;

            temp += V_tbl[a][b];
        }
        return temp;
    }

    @Override
    public String decrypt(String cipherText) {
        String temp = "";
        cipherText = cipherText.toLowerCase();
        for (int i = 0; i < cipherText.length(); i++) {
            int a = (int) key.charAt(i % key.length()) - 97;
            char ch = cipherText.charAt(i);
            int b;
            for (b = 0; b < 26; b++) {

                if (V_tbl[a][b] == ch) {
                    break;
                }
            }

            char x = (char) ((char) b + 97);
            temp += x;

        }
        return temp;
    }
    
    public static void main(String[] args) {
        PolyCipher c = new PolyCipher("ravi");
        
        String msg = c.encrypt("hello");
        System.out.println(msg);
        
        System.out.println(c.decrypt(msg));
    }
    
}
