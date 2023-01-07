package easy;

public class valid_palindrome {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "AbObA";
        String s4 = " ";

        System.out.println("Case 1: " + isPalindrome(s1) + "\n");
        System.out.println("Case 2: " + isPalindrome(s2) + "\n");
        System.out.println("Case 3: " + isPalindrome(s3) + "\n");
        System.out.println("Case 4: " + isPalindrome(s4) + "\n");
    }

    public static boolean isPalindrome(String s) {
        // replace non-alphanumerics and trim just in case
        s = s.toLowerCase().trim();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        // if empty string => valid
        if(s.length() == 0)
            return true;
        else {
            // run 2 pointers until they meet from each end of string, 
            //      if not equal at some point => not valid
            int k = 0;
            int j = s.length() - 1;
            
            while(k < j) {
                if(s.charAt(k) != s.charAt(j))
                    return false;
                k++;
                j--;
            }
        }

        return true;
    }

    public static boolean in3Lines(String s) {
        // convert String s to lowerCase with regex
        String tempString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Reverse the tempString 
        String rev = new StringBuffer(tempString).reverse().toString();
        
        // check tempString to rev String 
        return tempString.equals(rev);
    }
}