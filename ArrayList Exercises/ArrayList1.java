/* Author: Hayley So
 * Description: Array Exercise for ICS4U1 class.
 * Purpose: To perform various operations on an array of integers.
 * Date: 10/21/2024
 * JDK version: 22.02
 */

import java.util.*;
import java.text.DecimalFormat;

public class ArrayList1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        initializeArrayList(list);
        enterFromKeyboard(list);

        while (true) {
            System.out.println();
            System.out.println("--------HAYLEY'S ARRAYLIST EXERCISES MAIN MENU--------");
            System.out.println("     Would you like to:\n" +
                    "          1. Count the # of whole numbers\n" +
                    "          2. Display in the order entered\n" +
                    "          3. Display in reverse\n" +
                    "          4. Find the sum\n" +
                    "          5. Find the average\n" +
                    "          6. Find the maximum number\n" +
                    "          7. Find the minimum number\n" +
                    "          8. Find the occurence and position of a number\n" +
                    "          9. Sort the ArrayList using improved bubble sort\n" +
                    "          10. Sort the ArrayList using insertion sort\n" +
                    "          11. Exit the program");
            System.out.print("Enter # of desired action: ");
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    countWhole(list);
                    break;
                case "2":
                    display(list);
                    break;
                case "3":
                    displayReverse(list);
                    break;
                case "4":
                    sum(list);
                    break;
                case "5":
                    average(list);
                    break;
                case "6":
                    findMax(list);
                    break;
                case "7":
                    findMin(list);
                    break;
                case "8":
                    search(list);
                    break;
                case "9":
                    improvedBubbleSort(list);
                    break;
                case "10":
                    insertionSort(list);
                    break;
                case "11":
                    System.out.println("Thank you.");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    public static void initializeArrayList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, -1);
        }
    }

    public static void enterFromKeyboard(ArrayList<Integer> list) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Please enter an integer: ");
            list.add(i, sc.nextInt());
        }
    }

    public static void countWhole(ArrayList<Integer> list) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                counter++;
            }
        }
        System.out.println("The number of positive integers is " + counter);
    }

    public static void display(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void displayReverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static double sum(ArrayList<Integer> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("The sum of the elements is " + sum);
        return sum;

    }

    public static void average(ArrayList<Integer> list) {
        DecimalFormat format = new DecimalFormat("0.00"); 
        double sum = sum(list);
        System.out.println("The average of the elements is " + format.format(sum / list.size()));
    }

    public static void findMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("The max element is " + max);
    }

    public static void findMin(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        System.out.println("The min element is " + min);
    }

    public static void search(ArrayList<Integer> list) {
        System.out.print("Please enter a search item: ");
        int search = sc.nextInt();
        boolean isFound = false;
        System.out.print("The number " + search + " is found in the following position(s): ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == search) {
                if (isFound) {
                    System.out.print(", "); 
                }
                System.out.print(i); 
                isFound = true; 
            }
        }
        if (!isFound) {
            System.out.println("The number " + search + " was not found in the array.");
        } else {
            System.out.println(); 
        }

    }

    public static void improvedBubbleSort(ArrayList<Integer> list) {
        boolean swapped;
        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int currValue = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > currValue) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, currValue);
        }
    }

}