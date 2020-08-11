import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scan.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] input = command.split("\\s");

            switch (input[0]) {
                case "exchange":
                    int index = Integer.parseInt(input[1]);
                    if (index >= 0 && index < arr.length) {
                        arr = exchangeArrayPositions(arr, index);

                    } else
                        System.out.println("Invalid index");
                    break;

                case "max":
                    if (input[1].equals("even")) {
                        System.out.println(getIndexOfMaxEvenElement(arr));
                    } else if (input[1].equals("odd")) {
                        System.out.println(getIndexOfMaxOddElement(arr));
                    }
                    break;

                case "min":
                    if (input[1].equals("even")) {
                        System.out.println(getIndexOfMinEvenElement(arr));
                    } else if (input[1].equals("odd")) {
                        System.out.println(getIndexOfMinOddElement(arr));
                    }
                    break;

                case "first":
                    int count = Integer.parseInt(input[1]);
                    if (input[2].equals("even")) {
                        System.out.println(getFirstEvenNumbers(arr, count));
                    } else if (input[2].equals("odd")) {
                        System.out.println(getFirstOddNumbers(arr, count));
                    }
                    break;

                case "last":
                    int countLast = Integer.parseInt(input[1]);
                    if (input[2].equals("even")) {
                        System.out.println(getLastEvenNumbers(arr, countLast));
                    } else if (input[2].equals("odd")) {
                        System.out.println(getLastOddNumbers(arr, countLast));
                    }
                    break;
            }

            command = scan.nextLine();
        }
        System.out.println(Arrays.toString(arr));
    }

    static int[] exchangeArrayPositions(int[] arr, int index) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < index + 1; i++) {
            newArr[arr.length - index - 1 + i] = arr[i];
        }

        for (int i = 0; i < arr.length - index - 1; i++) {
            newArr[i] = arr[index + i + 1];
        }
        return newArr;
    }

    static String getIndexOfMaxEvenElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == -1) return "No matches";
        return index + "";
    }

    static String getIndexOfMaxOddElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] >= max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == -1) return "No matches";
        return index + "";
    }

    static String getIndexOfMinEvenElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }
        if (index == -1) return "No matches";
        return index + "";
    }

    static String getIndexOfMinOddElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }
        if (index == -1) return "No matches";
        return index + "";
    }

    static String getFirstEvenNumbers(int[] arr, int count) {
        if (count > arr.length || count < 0) return "Invalid count";
        int counter = 0;
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
                if (counter == 1)
                    result += arr[i];
                else if (counter > 1 && counter != count)
                    result += ", " + arr[i];
                else if (counter == count) {
                    result += ", " + arr[i];
                    break;
                }
            }
        }
        result += "]";
        return result;
    }

    static String getFirstOddNumbers(int[] arr, int count) {
        if (count > arr.length || count < 0) return "Invalid count";
        int counter = 0;
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                counter++;
                if (counter == 1)
                    result += arr[i];
                else if (counter > 1 && counter != count)
                    result += ", " + arr[i];
                else if (counter == count) {
                    result += ", " + arr[i];
                    break;
                }
            }
        }
        result += "]";
        return result;
    }

    static String getLastEvenNumbers(int[] arr, int count) {
        if (count > arr.length || count < 0) return "Invalid count";
        int counter = 0;
        String result = "]";
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                counter++;
                if (counter == 1)
                    result = arr[i] + result;
                else if (counter > 1 && counter != count)
                    result = arr[i] + ", " + result;
                else if (counter == count) {
                    result = arr[i] + ", " + result;
                    break;
                }
            }
        }
        result = "[" + result;
        return result;
    }

    static String getLastOddNumbers(int[] arr, int count) {
        if (count > arr.length || count < 0) return "Invalid count";
        int counter = 0;
        String result = "]";
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                counter++;
                if (counter == 1)
                    result = arr[i] + result;
                else if (counter > 1 && counter != count)
                    result = arr[i] + ", " + result;
                else if (counter == count) {
                    result = arr[i] + ", " + result;
                    break;
                }
            }
        }
        result = "[" + result;
        return result;
    }
}
