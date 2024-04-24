import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    static final int ARRAY_SIZE = 100;

    public static int[] dump(int[] arr) {
        int max = 0;
        int maxIndex = 0;
        int min = 100;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        arr[maxIndex] -= 1;
        arr[minIndex] += 1;

        return arr;
    }

    public static int calculateDifference(int[] arr) {
        int max = 0;
        int min = 100;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return max - min;
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int dumpCount = sc.nextInt();
            int[] arr = new int[ARRAY_SIZE];

            for (int i = 0; i < ARRAY_SIZE; i++) {
                arr[i] = sc.nextInt();
            }

            int result = 0;
            for (int i = 0; i < dumpCount; i++) {
                int temp = calculateDifference(arr);
                if (temp == 1 || temp == 0) {
                    result = temp;
                    break;
                } else {
                    arr = dump(arr);
                }
                result = calculateDifference(arr);
            }
            System.out.println("#" + test_case + " " + result);

        }
    }

}