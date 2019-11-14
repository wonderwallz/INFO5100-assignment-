package assignment8;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator extends JFrame {

	private JTextField resultTextField;
	private JButton add, subtract, multiply, divide, compute;

	private JButton numbers[];
    int first = 0, second = 0;
    boolean flag = true;
    Operation o = Operation.ADD;

	class OperationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			flag = false;
			if (e.getSource() == add) {
				o = Operation.ADD;
			}
			if (e.getSource() == subtract) {
				o = Operation.SUBTRACT;
			}
			if (e.getSource() == multiply) {
				o = Operation.MULTIPLY;
			}
			if (e.getSource() == divide) {
				o = Operation.DIVIDE;
			}

		}

	}

	class ComputeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = 0;
			if (o == Operation.ADD) {
				result = first + second;
			}
			if (o == Operation.SUBTRACT) {
				result = first - second;
			}
			if (o == Operation.DIVIDE) {
				result = first / second;
			}
			if (o == Operation.MULTIPLY) {
				result = first * second;
			}

			resultTextField.setText(result + "");

		}

	}
	
	class NumberListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			int num = 0;
			for(int i = 0; i < 10; i++) {
				if(e.getSource() == numbers[i]) {
					num = i;
				}
			}
			if(flag) {
				first = first * 10 + num;
				resultTextField.setText(first + "");
			}
			else {
				second = second * 10 + num;
				resultTextField.setText(second + "");
			}
		}
	}

	public Calculator() {
		createComponents();
		setLayout();
		addComponents();
		addBehaviors();
		display();
	}

	private void addBehaviors() {
		ComputeListener cl = new ComputeListener();
		compute.addActionListener(cl);

		OperationListener ol = new OperationListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);
		NumberListener nl = new NumberListener();
		for(int i=0;i<10;i++) {
			numbers[i].addActionListener(nl);
		}

	}

	private void display() {
		setSize(400,400);
		setVisible(true);

	}

	private void addComponents() {
		Container c = getContentPane();
		c.add(resultTextField);

		JPanel panel = new JPanel();
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		c.add(panel);

		panel = new JPanel();
		panel.add(compute);
		c.add(panel);

		JPanel p = new JPanel();
		p.add(numbers[1]);
		p.add(numbers[2]);
		p.add(numbers[3]);
		p.add(numbers[4]);

		c.add(p);

		p = new JPanel();
		p.add(numbers[5]);
		p.add(numbers[6]);
		p.add(numbers[7]);
		p.add(numbers[8]);

		c.add(p);

		p = new JPanel();
		p.add(numbers[9]);
		p.add(numbers[0]);

		c.add(p);

	}

	private void setLayout() {
		GridLayout gl = new GridLayout(6, 1);
		Container c = this.getContentPane();
		c.setLayout(gl);

	}

	private void createComponents() {
		resultTextField = new JTextField(10);

		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("x");
		divide = new JButton("%");
		compute = new JButton("=");

		numbers = new JButton[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton(i + "");
		}

	}

	public static void main(String[] args) {
		Calculator c = new Calculator();

	}

}