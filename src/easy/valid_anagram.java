package easy;

import java.util.Arrays;

public class valid_anagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "cat";
        String s3 = "ac";
        String t3 = "bb";

        System.out.println("Case 1: " + isAnagram(s1, t1) + "\n");
        System.out.println("Case 2: " + isAnagram(s2, t2) + "\n");
        System.out.println("Case 3: " + isAnagram(s3, t3) + "\n");
    }

    public static boolean isAnagram(String s, String t) {
        // if strings are unequal or null => not valid
        if(s == null || t == null)
            return false;
        
        if(s.length() != t.length())
            return false;

        String s_sorted = sortString(s);
        String t_sorted = sortString(t);
    
        // compare sorted strings, which have to be equal
        return s_sorted.equals(t_sorted);
    }

    private static String sortString(String s) {
        // convert string into array of chars and sort it
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        // return as string
        return new String(arr);
    }
}
