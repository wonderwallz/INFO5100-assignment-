package assignment8;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class Students {
	public Collection<Student> students = new ArrayList<Student>();
	
	public void addStudent(Student stu) {
		students.add(stu);
	}
	
	public Collection<Student> getStudents(){
		return students;
	}
	public int countOfStudents() {
		return getStudents().size();
	}

	
}

class Student {
	private int Id;
	private String name;
	private String gender;
	
	public Student(int Id, String name, String gender) {
		this.Id = Id;
		this.name = name;
		this.gender = gender;
	}
	public int getId() {
		return this.Id;
	}
	public String getName() {
		return this.name;
	}
	public String getGender() {
		return this.gender;
	}
}

public class StudentsTable implements TableModel{
	Students students = new Students();
	
	public StudentsTable(Students students) {
		this.students = students;
	}
	public void addStudent(Student stu) {
		students.addStudent(stu);
	}

	@Override
	public int getRowCount() {
		return students.countOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex==0) {
			return "ID";
		}
		if(columnIndex==1) {
			return "Name";
		}
		if(columnIndex==2) {
			return "Gender";
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> stu = students.getStudents();
		int row = -1;
		for(Student student: stu) {
			row++;
			if(row == rowIndex) {
				if(columnIndex==0) {
					return student.getId();
				}
				if(columnIndex==1) {
					return student.getName();
				}
				if(columnIndex==2) {
					return student.getGender();
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
	}
	

}
