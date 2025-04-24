import java.util.Scanner;

class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

public class PracticeSetOnErrorsExceptions {

    public static void divide(int a, int b) throws ArithmeticException {
        System.out.println("Result: " + (a / b));
    }

    public static void checkAge(int age) throws MyCustomException {
        if (age < 18) {
            throw new MyCustomException("Age must be 18 or above.");
        } else {
            System.out.println("You're eligible!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Handling ArithmeticException
        try {
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();
            System.out.print("Enter denominator: ");
            int den = sc.nextInt();
            divide(num, den);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        // 2. Handling ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.print("Enter index to access (0-2): ");
            int index = sc.nextInt();
            System.out.println("Value at index: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range.");
        }

        // 3. Handling Custom Exception
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            checkAge(age);
        } catch (MyCustomException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }

        // 4. Finally Block
        finally {
            System.out.println("Execution completed. Thank you!");
        }

        sc.close();
    }
}
