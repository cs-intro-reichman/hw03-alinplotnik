/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        String allLow = "";
        for(int i = 0; i < s.length(); i++){
            char chr = s.charAt(i);
            if ( chr >= 'A' && chr <= 'Z' ){
                chr = ((char)(chr + 32));
                allLow += chr;
            }
            else{
                allLow += chr;
            }
        }
        return allLow;
    }
}
