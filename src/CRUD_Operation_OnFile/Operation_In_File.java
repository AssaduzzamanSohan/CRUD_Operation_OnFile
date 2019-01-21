package CRUD_Operation_OnFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Operation_In_File {

	String fileLocation = "C:\\Users\\assaduzzaman.sohan\\Desktop\\New folder\\Test.csv";
	
	
	String row = "";
	String line = "";

	public void add(Student st) throws IOException {

		int index = 0;
		File file = new File(fileLocation);

		if (!file.exists()) {
			file.createNewFile();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(fileLocation));

		if (file.length() == 0) {
			index = 0;
		}
		else {
			while ((line = br.readLine()) != null) {
				// index++;
				String[] list = line.split(",");
				index = Integer.valueOf(list[0]);
			}
		}
		br.close();

		FileWriter pw = new FileWriter(fileLocation, true);
		StringBuilder sb = new StringBuilder();
		st.setId(st.getId());
		sb.append(st.getId());
		sb.append(',');
		sb.append(st.getName());
		sb.append(',');
		sb.append(st.getDept());
		sb.append('\n');
		pw.write(sb.toString());
		pw.close();
	}

	public ArrayList<Student> read() throws IOException {
		ArrayList<Student> studentList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(fileLocation));
		while ((row = br.readLine()) != null) {

			// use comma as separator
			String[] list = row.split(",");
			int x = Integer.valueOf(list[0]);
			
			int n = Integer.valueOf(list[0]);
			
			Student st = new Student(x, list[1], list[2]);
//			st.setId(Integer.valueOf(list[0]));
//			st.setName(list[1]);
//			st.setDept(list[2]);
			studentList.add(st);
		}
		br.close();
		return studentList;

	}

	public boolean search(int id) throws IOException {
		Operation_In_File oif = new Operation_In_File();
		ArrayList<Student> StudentList = new ArrayList<>();
		StudentList = oif.read();
		// Doctor doctor = new Doctor();
		for (Student item : StudentList) {

			if (item.getId() == id) {
				return false;
			}
		}
		return true;
	}

	public void update(Student student) throws IOException {
		ArrayList<Student> StudentList = new ArrayList<>();
		Operation_In_File oif = new Operation_In_File();
		StudentList = oif.read();
		for (Student item : StudentList) {
			if (item.getId() == student.getId()) {
				item.setName(student.getName());
				item.setDept(student.getDept());
				break;
			}
		}
		File file = new File(fileLocation);
		file.delete();
		listToFile(StudentList);
	}

	public void delete(int id) throws IOException {
		ArrayList<Student> StudentList = new ArrayList<>();
		Operation_In_File oif = new Operation_In_File();
		StudentList = oif.read();

		for (Student item : StudentList) {
			if (item.getId() == id) {
				StudentList.remove(item);
				break;
			}
		}
		File file = new File(fileLocation);
		file.delete();
		listToFile(StudentList);

	}

	public void listToFile(ArrayList<Student> StudentList) throws IOException {

		for (Student doctor : StudentList) {
			FileWriter pw = new FileWriter(fileLocation, true);
			StringBuilder sb = new StringBuilder();
			sb.append(doctor.getId());
			sb.append(',');
			sb.append(doctor.getName());
			sb.append(',');
			sb.append(doctor.getDept());
			sb.append('\n');
			pw.write(sb.toString());
			pw.close();
		}
	}
}
