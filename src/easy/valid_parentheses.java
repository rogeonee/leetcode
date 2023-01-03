package easy;

import java.util.Stack;

public class valid_parentheses {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "{[]}";
        String s5 = "({[)";

        System.out.println("Case 1:");
        System.out.println(isValid(s1));

        System.out.println("\nCase 2:");
        System.out.println(isValid(s2));

        System.out.println("\nCase 3:");
        System.out.println(isValid(s3));

        System.out.println("\nCase 4:");
        System.out.println(isValid(s4));

        System.out.println("\nCase 5:");
        System.out.println(isValid(s5));

    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;

        Stack<Character> aa = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(aa.isEmpty()) {
                aa.push(ch);
                continue;
            }

            if(ch == ')' && aa.peek() == '(')
                aa.pop();
            else if(ch == '}' && aa.peek() == '{')
                aa.pop();
            else if(ch == ']' && aa.peek() == '[')
                aa.pop();
            else
                aa.push(ch);
        }

        if(aa.empty())
            return true;
        else
            return false;
    }
    
}
