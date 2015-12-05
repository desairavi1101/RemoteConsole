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
public class Cipher {
    public static ICipher getCipher(String cipherName,String key) {
        switch(cipherName.toLowerCase()) {
            case "caesar":
                return new CaesarCipher(key);
            case "poly":
                return new PolyCipher(key);
            case "rotation":
                return new RotationCipher(key);
            default:
                return new DummyCipher();
        }  
    }
}
