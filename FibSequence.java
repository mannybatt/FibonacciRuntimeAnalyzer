import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class FibSequence {

	private static long startTime;

	public static void main(String args[]) {

		System.out.println("Fibonacci Runtime Analytics");
		System.out.println("(1) Batch read from a file\n(2) Single number calculator");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		if (choice == 1) {
			System.out.print("Type a filename: ");
			String filename = scan.next();
			File file = new File(filename);
			try {
				scan = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("No such file found!");
			}

			while (scan.hasNextDouble()) {
				double fib = scan.nextDouble();
				System.out.println("\n[" + String.format("%.0f", fib) + "]");

				if (fib < Integer.MAX_VALUE - 1) {
					startTime = System.nanoTime();
					fibIterative(fib);

					startTime = System.nanoTime();
					double x = fibRecursive(fib);
					String noDecimal = String.format("%.0f", x);
					System.out.println("Fibonacci Recursive: " + noDecimal + " = " + (System.nanoTime() - startTime)
							+ " nanoseconds");
				}
			}
		}

		else if (choice == 2) {
			System.out.print("Type a number: ");
			double fib = scan.nextDouble();

			if (fib < Integer.MAX_VALUE - 1) {
				startTime = System.nanoTime();
				fibIterative(fib);

				startTime = System.nanoTime();
				double x = fibRecursive(fib);
				String noDecimal = String.format("%.0f", x);
				System.out.println(
						"Fibonacci Recursive: " + noDecimal + " = " + (System.nanoTime() - startTime) + " nanoseconds");
			}
		}

		else {
			System.out.println("Invalid choice.");
		}

	}

	public static void fibIterative(double input) {

		System.out.print("Fibonacci Iterative: ");

		double[] nums = new double[(int) (input + 2)];
		

		if (input == 0) {
			System.out.println("0 = " + (System.nanoTime() - startTime) + " nanoseconds");
		}

		else if (input == 1) {
			System.out.println("1 = " + (System.nanoTime() - startTime) + " nanoseconds");
		}

		else {
			nums[0] = 0;
			nums[1] = 1;

			for (int i = 2; i < input + 1; i++) {
				nums[i] = nums[i - 1] + nums[i - 2];
			}

			String noDecimal = String.format("%.0f", nums[(int) (input)]);
			long elapsed = System.nanoTime() - startTime;
			System.out.println(noDecimal + " = " + elapsed + " nanoseconds");
		}
	}

	public static double fibRecursive(double input) {

		if (input <= 1) {
			return input;
		}
		return fibRecursive(input - 1) + fibRecursive(input - 2);
	}
}
