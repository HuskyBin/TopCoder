/*
Problem Statement
    
Julius Caesar used a system of cryptography, now known as Caesar Cipher, which shifted each letter 2 places further through the alphabet (e.g. 'A' shifts to 'C', 'R' shifts to 'T', etc.). At the end of the alphabet we wrap around, that is 'Y' shifts to 'A'.
We can, of course, try shifting by any number. Given an encoded text and a number of places to shift, decode it.
For example, "TOPCODER" shifted by 2 places will be encoded as "VQREQFGT". In other words, if given (quotes for clarity) "VQREQFGT" and 2 as input, you will return "TOPCODER". See example 0 below.
Definition
    
Class:
CCipher
Method:
decode
Parameters:
String, int
Returns:
String
Method signature:
String decode(String cipherText, int shift)
(be sure your method is public)
*/
public class CCipher {
    public String decode(String cipherText, int shift) {
        if (cipherText == null || cipherText.length() == 0 || shift < 0) {
            return cipherText;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char curChar = cipherText.charAt(i);
            if ((char)(curChar - shift) >= 'A') {
                sb.append((char)(curChar - shift));
            }
            else {
                char newChar = (char)('Z' - (shift - ((int)(curChar - 'A')) - 1));
                sb.append(newChar);
            }
        }
        return sb.toString();
    }
}
