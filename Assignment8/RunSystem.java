package assignment8;

public class RunSystem {

	public static void main(String[] args) {
		Student s1 = new Student(001, "Eddie", "male");
		Student s2 = new Student(002, "Bella", "female");
		Student s3 = new Student(003, "Beth", "female");
		Students st = new Students();
		st.addStudent(s2);
		StudentsTable model = new StudentsTable(st);
		model.addStudent(s1);
		StudentInformation info = new StudentInformation(model);

	}

}
