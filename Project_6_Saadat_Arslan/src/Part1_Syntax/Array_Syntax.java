package Part1_Syntax;

import java.util.Scanner;
public class Array_Syntax {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        int[] DefinedArray = new int[5];
        System.out.println("Could you please input the size for a custom array?");
        int size = userScanner.nextInt();
        Double[] CustomSizedArray = new Double[size];
        int h = 0;
        while (h < size) {
            System.out.println("Please input a value into the array");
            CustomSizedArray[h] = userScanner.nextDouble();
            h++;
        }
        String[] CreatedArray = {"A", "R", "R", "A", "Y"};
        DefinedArray[0] = 4;
        DefinedArray[1] = 3;
        DefinedArray[2] = 5;
        DefinedArray[3] = 12;
        DefinedArray[4] = 64;
        System.out.println("Second integer in the first defined array = " + DefinedArray[1]);
        System.out.println("Traversing an array with a for loop");
        int i;
        for (i = 0; i < CreatedArray.length; i++) {
            System.out.println(CreatedArray[i]);
        }
        System.out.println("Traversing an array with an enhanced for loop");
        for (int n : DefinedArray) {
            System.out.println(n);

        }
        System.out.println("Traversing an array with a while loop.");
        int m = 0;
        while (m < CustomSizedArray.length) {
            System.out.println(CustomSizedArray[m]);
            m++;
        }
    }
}
/*
    Demonstrate array creation:
        With predefined size: new int[10]
        With size defined in a variable: int[size]
        Literal array creation: int[] arr = {1, 4, 2, ...}
        Use different types for array elements (int, double, String, char, boolean).
        Show use of array.length.
    Set and access array elements by index:
        Assign value to array element: a[4] = 45
        Print array element value: ...println("5th element value: " + a[4])
        Demonstrate error of accessing array element by non-existing index: a[1000]. Include screenshot of error.
    Iterate over array (array traversal):
        Use for loop to traverse an array.
        Use the enhanced for loop to traverse array: for (int value : values) { ... }
        Use while loop to traverse an array.
*/