package Part2_ArrayHandling;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Array_Handling {
    public static void main(String[] args) {
        print("Creating a user defined array.");
        double[] UserArray = InputArray();
        print("Creating an array with random elements");
        double[] RandomValuedArray = CreateRandomArray(4);
        print("Printing out the user defined array");
        printArray(UserArray);
        print("Printing out the array with random elements");
        printArray(RandomValuedArray);
        print("Printing out the sum of an array");
        print("Here the sum of all elements in your Array: " + ArraySum(UserArray));
        print("Printing out the largest element of an array");
        print("Here is the largest of all elements in your Array: " + ArrayLargestValue(UserArray));
        print("Printing out an index of a value in array");
        print("Here the index of a value 3 in your Array: " + IndexOfAValue(UserArray, 3));

    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printArray(double[] Arr) {
        print("Here are all elements of an Array");
        System.out.println(Arrays.toString(Arr));
    }

    public static double ArraySum(double[] Arr) {
        double sum = 0;
        for (double element : Arr) {
            sum = sum + element;
        }
        return sum;
    }

    public static double ArrayLargestValue(double[] Arr) {
        double LargestValue = 0;
        for (double element : Arr) {
            LargestValue = Math.max(LargestValue, element);
        }
        return LargestValue;
    }

    public static double[] InputArray() {

        int arrayLength = GetUserInt("Please input array length");

        double[] ResultArray = new double[arrayLength];
        for (int i = 0; i < ResultArray.length; i++) {
            ResultArray[i] = GetUserInt("Please input " + i + " element of an array");
        }
        return ResultArray;
    }

    public static int GetUserInt(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        print(systemMessage);
        return userScanner.nextInt();
    }

    public static double[] CreateRandomArray(int arrayLength) {
        Random rng = new Random();
        double[] ResultArray = new double[arrayLength];
        for (int i = 0; i < ResultArray.length; i++) {

            ResultArray[i] = rng.nextInt(0, 10);
        }
        return ResultArray;
    }

    public static int IndexOfAValue(double[] Arr, double value) {
        int Result = -1;
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] == value) {
                Result = i;
                break;
            }
        }
        return Result;
    }
}