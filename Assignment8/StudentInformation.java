package assignment8;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentInformation extends JFrame {
	private JFrame Jframe = new JFrame();
	private JLabel IdLabel, nameLabel, genderLabel;
	private JButton addButton;
	private JTextField IdTextField, nameTextField, genderTextField;
	private JTable studentsTable;
	private JScrollPane scrollPane;
	private StudentsTable model;
	
	public StudentInformation(StudentsTable model) {
		this.model = model;
		createComponents();
		addComponents();
		behaviors();
		setLayout();
		display();
	}
	
	public void createComponents() {
		IdLabel = new JLabel("ID");
		nameLabel = new JLabel("Name");
		genderLabel = new JLabel("Gender");
		IdTextField = new JTextField(5);
		nameTextField = new JTextField(5);
		genderTextField = new JTextField(5);
		addButton = new JButton("Add");
		studentsTable = new JTable(model);
		scrollPane = new JScrollPane(studentsTable);
		
	}
	public void addComponents() {
		Container con = getContentPane();
		JPanel p = new JPanel();
		p.add(IdLabel);
		p.add(nameLabel);
		p.add(genderLabel);
		p.add(IdTextField);
		p.add(nameTextField);
		p.add(genderTextField);
		p.add(addButton);
		con.add(p);
		con.add(scrollPane);
	}
	
	class add implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			int Id = Integer.parseInt(getId());
			String name = getName();
			String gender = getGender();
			Student student = new Student(Id, name, gender);
			model.addStudent(student);
			studentsTable.updateUI();
		}
	}
	private void behaviors() {
		add ad = new add();
		addButton.addActionListener(ad);
	}
	public void setLayout() {
		GridLayout gl = new GridLayout(5,1);
		Container con = this.getContentPane();
		con.setLayout(gl);
	}
	public void display() {
		setSize(600,600);
		setVisible(true);
	}
	
	public String getId() {
		return IdTextField.getText();
	}
	public String getName() {
		return nameTextField.getText();
	}
	public String getGender() {
		return genderTextField.getText();
	}
	
 
		
}
