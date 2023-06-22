package test;
import java.util.Scanner;
public class hueta {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("The new number is: " + multiply2000(num));
    }

    public static int multiply2000(int num) {
        if(num < 5 || num > 12)
            return -1;

        return num * 2000;
    }
}