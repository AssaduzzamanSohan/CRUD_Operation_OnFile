package CRUD_Operation_OnFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int number;
		Operation op = new Operation();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Select the option which service you want to get");
			System.out.println("");

			System.out.println("Press 1 to add a Student Detail");
			System.out.println("Press 2 to see all Student Detail");
			System.out.println("Press 3 to update a Student Detail");
			System.out.println("Press 4 to delete a Student Detail");

			number = sc.nextInt();

			if (number == 1) {
				op.AddStudentDetail();
			} else if (number == 2) {
				op.ViewAllStudentDetail();
			} else if (number == 3) {
				op.UpdateStudentDetail();
			} else if (number == 4) {
				op.DeleteStudentDetail();
			} else {
				System.out.println("Wrong entered");
			}
		} while (number != 100);
	}
}
