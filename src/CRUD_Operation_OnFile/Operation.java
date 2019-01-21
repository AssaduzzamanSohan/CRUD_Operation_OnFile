package CRUD_Operation_OnFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operation {

	Scanner sc = new Scanner(System.in);
	Operation_In_File oif = new Operation_In_File();
	
	public void AddStudentDetail() throws IOException {
		
		String name,dept;
		int ID;
		System.out.println("");
		System.out.println("Please enter the Student name ----- dept ----- ID");
		name = sc.next();
		dept = sc.next();
		ID = sc.nextInt();

		
		Student st = new Student(ID, name, dept);
		oif.add(st);
		System.out.println(st);
		System.out.println("");
	}

	public void ViewAllStudentDetail() throws IOException {
		System.out.println("");
		System.out.println("The list of the Student are -----");
		System.out.println("");
		ArrayList<Student> studentList = new ArrayList<>();
		studentList = oif.read();

		for (Student item : studentList) {

			System.out.println("");
			System.out.println(
					"ID- " + item.getId() + " Name- " + item.getName() + " Dept- " + item.getDept());
			System.out.println("");
		}
		System.out.println("");
		
	}

	public void UpdateStudentDetail() throws IOException {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		
		int id;
		String name,dept;

		System.out.println("");
		System.out.println("What is the id of that Student which you want to edit -----");
		System.out.println("");
		id = sc.nextInt();

		if (oif.search(id)) {
			System.out.println("Student not found with this id--------");
			System.out.println("");
		} else {
			System.out.println("Edit the name of the Student--------");
			System.out.println("");
			name = sc1.nextLine();
			System.out.println("Edit the Dept of the Student--------");
			System.out.println("");
			dept = sc1.nextLine();

			Student st = new Student(id, name, dept);
			
			st.setId(id);
			st.setName(name);
			st.setDept(dept);
			
			oif.update(st);
		}	
	}

	public void DeleteStudentDetail() throws IOException {
		Scanner sc = new Scanner(System.in);
		int id;
		System.out.println("");
		System.out.println("Enter the id which Student you want to delete -----");
		System.out.println("");
		id = sc.nextInt();
		if (oif.search(id)) {
			System.out.println("Student not found with this id--------");
			System.out.println("");
		}
		
		else {
			oif.delete(id);
			System.out.println("Student whose id "+ id + " is deleted");
			
		}
	}
}
