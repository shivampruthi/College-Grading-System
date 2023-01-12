/**
 * 
 */
/**
 * @author shivampruthi
 *
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollegeGradingSystem extends JFrame {
	public static void main(String[] args) {
		new CollegeGradingSystem();
	}

	public CollegeGradingSystem() {
		// Create window frame
		JFrame frame = new JFrame("College Grading System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Create panel
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Create labels
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(20, 20, 80, 25);
		panel.add(nameLabel);

		JLabel rollLabel = new JLabel("Roll:");
		rollLabel.setBounds(20, 50, 80, 25);
		panel.add(rollLabel);

		JLabel sub1Label = new JLabel("Subject 1:");
		sub1Label.setBounds(20, 80, 80, 25);
		panel.add(sub1Label);

		JLabel sub2Label = new JLabel("Subject 2:");
		sub2Label.setBounds(20, 110, 80, 25);
		panel.add(sub2Label);

		JLabel sub3Label = new JLabel("Subject 3:");
		sub3Label.setBounds(20, 140, 80, 25);
		panel.add(sub3Label);

		JLabel sub4Label = new JLabel("Subject 4:");
		sub4Label.setBounds(20, 170, 80, 25);
		panel.add(sub4Label);

		JLabel sub5Label = new JLabel("Subject 5:");
		sub5Label.setBounds(20, 200, 80, 25);
		panel.add(sub5Label);

		JLabel gradeLabel = new JLabel("Grade:");
		gradeLabel.setBounds(20, 230, 80, 25);
		panel.add(gradeLabel);

		// Create text fields
		JTextField nameField = new JTextField(20);
		nameField.setBounds(100, 20, 165, 25);
		panel.add(nameField);

		JTextField rollField = new JTextField(20);
		rollField.setBounds(100, 50, 165, 25);
		panel.add(rollField);

		JTextField sub1Field = new JTextField(20);
		sub1Field.setBounds(100, 80, 165, 25);
		panel.add(sub1Field);

		JTextField sub2Field = new JTextField(20);
		sub2Field.setBounds(100, 110, 165, 25);
		panel.add(sub2Field);

		JTextField sub3Field = new JTextField(20);
		sub3Field.setBounds(100, 140, 165, 25);
		panel.add(sub3Field);

		JTextField sub4Field = new JTextField(20);
		sub4Field.setBounds(100, 170, 165, 25);
		panel.add(sub4Field);

		JTextField sub5Field = new JTextField(20);
		sub5Field.setBounds(100, 200, 165, 25);
		panel.add(sub5Field);

		JTextField gradeField = new JTextField(20);
		gradeField.setBounds(100, 230, 165, 25);
		panel.add(gradeField);

		// Create button
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(100, 270, 80, 25);
		panel.add(submitButton);

		// Create action listner
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText().trim();
				String roll = rollField.getText().trim();
				int sub1 = Integer.parseInt(sub1Field.getText().trim());
				int sub2 = Integer.parseInt(sub2Field.getText().trim());
				int sub3 = Integer.parseInt(sub3Field.getText().trim());
				int sub4 = Integer.parseInt(sub4Field.getText().trim());
				int sub5 = Integer.parseInt(sub5Field.getText().trim());

				// Calculate the grade
				int avg = (sub1 + sub2 + sub3 + sub4 + sub5)/5;
				String grade;
				if (avg >= 90) {
					grade = "A+";
				} else if (avg >= 80) {
					grade = "A";
				} else if (avg >= 70) {
					grade = "B+";
				} else if (avg >= 60) {
					grade = "B";
				} else if (avg >= 50) {
					grade = "C";
				} else if (avg >= 40) {
					grade = "D";
				} else {
					grade = "F";
				}

				// Store the data in the database
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
					Statement statement = connection.createStatement();
					String query = "INSERT INTO student_grades (name, roll, sub1, sub2, sub3, sub4, sub5, grade) VALUES ('" + name + "', '" + roll + "', '" + sub1 + "', '" + sub2 + "', '" + sub3 + "', '" + sub4 + "', '" + sub5 + "', '" + grade + "')";
					statement.executeUpdate(query);
					statement.close();
					connection.close();
					gradeField.setText(grade);
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
