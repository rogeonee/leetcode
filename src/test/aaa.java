package test;

public class aaa {

    public static void main(String[] args) {
        System.out.println("imba!");
    }
}

class Solution {

    // Task 1
    public String solution(String S, int K) {
        // Implement your solution here
        String[] arr = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int pos = 0;

        for(String a : arr) {
            if(S.equals(a))
                break;
            pos++;
        }

        int tg = (K % 7 + pos) % 7;

        return arr[tg];
    }

    // Task 3
    public int solution(String S) {
        // Implement your solution here
        int b = 0;
        int a = 0;
        int n = 0;
        int count = 0;
    
        // count amount of chars needed
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'B')
                b++;
            else if(S.charAt(i) == 'A')
                a++;
            else if(S.charAt(i) == 'N')
                n++;
        }
    
        // if any of them == 0, no bananas can be formed => return 0
        if(b == 0 || a == 0 || n == 0)
            return 0;
        
        // count amount of bananas, extracting amount of chars needed for each
        while(b > 0 && a > 0 && n > 0) {
            b -= 1;
            a -= 3;
            n -= 2;
            count++;
        }
    
        return count;
    }
}

// Task 2
/*
SELECT department.dept_id, count(emp_id), sum(salary)
FROM department JOIN employee 
            ON department.dept_id = employee.dept_id
GROUP BY department.dept_id
ORDER BY department.dept_id ASC;
*/