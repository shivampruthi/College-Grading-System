/**
 * 
 */
/**
 * @author shivampruthi
 *
 */
package Project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GradingSystem extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField txtMarks1, txtMarks2, txtMarks3, txtMarks4, txtMarks5;
    private JLabel lblSubject1, lblSubject2, lblSubject3, lblSubject4, lblSubject5, lblGrade;
    private JButton btnCalculate;

    public GradingSystem() {
        super("College Grading System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        lblSubject1 = new JLabel("Subject 1:");
        txtMarks1 = new JTextField(10);
        add(lblSubject1);
        add(txtMarks1);

        lblSubject2 = new JLabel("Subject 2:");
        txtMarks2 = new JTextField(10);
        add(lblSubject2);
        add(txtMarks2);

        lblSubject3 = new JLabel("Subject 3:");
        txtMarks3 = new JTextField(10);
        add(lblSubject3);
        add(txtMarks3);

        lblSubject4 = new JLabel("Subject 4:");
        txtMarks4 = new JTextField(10);
        add(lblSubject4);
        add(txtMarks4);

        lblSubject5 = new JLabel("Subject 5:");
        txtMarks5 = new JTextField(10);
        add(lblSubject5);
        add(txtMarks5);

        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        lblGrade = new JLabel("Grade: ");
        add(lblGrade);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            try {
                double marks1 = Double.parseDouble(txtMarks1.getText());
                double marks2 = Double.parseDouble(txtMarks2.getText());
                double marks3 = Double.parseDouble(txtMarks3.getText());
                double marks4 = Double.parseDouble(txtMarks4.getText());
                double marks5 = Double.parseDouble(txtMarks5.getText());
                double totalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
                double percentage = (totalMarks / 500) * 100;

                //Calculate Grade
                String grade;
                if (percentage >= 80)
                    grade = "A";
                else if (percentage >= 70 && percentage < 80)
                    grade = "B";
                else if (percentage >= 60 && percentage < 70)
                    grade = "C";
                else if (percentage >= 50 && percentage < 60)
                    grade = "D";
                else
                    grade = "F";

                lblGrade.setText("Grade: " + grade);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid marks", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
        GradingSystem gradingSystem = new GradingSystem();
    }

}