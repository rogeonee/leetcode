package test;
// Elena Savkina 
// 79790747
// COSC 111 L02 Assgnment 7
// then program sorts the inputed  numbers using buble sort method


import java.util.Scanner;

public class Assignment7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the # of numbers to be sorted: ");
        int length = in.nextInt();
        System.out.print("Enter 1 for ints or 2 for doubles: ");
        int type = in.nextInt();

        int[] arr = new int[length];
        double[] arr1 = new double[length];

        if(type == 1) {
            for(int i = 0; i < length; i++) {
                System.out.print("Enter number: ");
                arr[i] = in.nextInt();
            }
            System.out.print("Initial array: ");
            printArray(arr);
            bubbleSort(arr);
        } else {
            for(int i = 0; i < length; i++) {
                System.out.print("Enter number: ");
                arr1[i] = in.nextDouble();
            }
            System.out.print("Initial array: ");
            printArray(arr1);
            bubbleSort(arr1);
        }
        
    }

    public static void bubbleSort(int[] arr) {
        boolean sorted = false;
        while(!sorted) {
            // boolean to identify whether sorted or not - if swap occurred, then not
            boolean swapped = false;

            // arr.length-1 prevents array out of bounds
            for(int i = 0; i < arr.length - 1; i++) {
                
                // if not in order, swap and print
                if(arr[i] > arr[i + 1]) {
                    swapped = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    printArray(arr);
                }
            }

            // check for swaps
            if(!swapped)
                sorted = true;
        }
        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public static void bubbleSort(double[] arr) {
        boolean sorted = false;
        while(!sorted) {
            boolean swapped = false;
            for(int i = 0; i < arr.length - 1; i++) {
                
                if(arr[i] > arr[i + 1]) {
                    swapped = true;
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    printArray(arr);
                }
            }

            if(!swapped)
                sorted = true;
        }
        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // check for the last element for no comma
            if(i + 1 == arr.length)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(i + 1 == arr.length)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
