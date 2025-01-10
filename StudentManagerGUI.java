import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagerGUI {
    private StudentManagerImpl manager;
    private JTextArea textArea;
    private JTextField nameField, ageField, gradeField, studentIDField;

    public StudentManagerGUI() {
        manager = new StudentManagerImpl();

        // UI Setup
        JFrame frame = new JFrame("Student Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);  // Zwiększenie rozmiaru okna

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nameField = new JTextField(20);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        ageField = new JTextField(20);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        gradeField = new JTextField(20);
        panel.add(new JLabel("Grade:"));
        panel.add(gradeField);

        studentIDField = new JTextField(20);
        panel.add(new JLabel("Student ID:"));
        panel.add(studentIDField);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Adding student...");
                String name = nameField.getText();
                try {
                    int age = Integer.parseInt(ageField.getText());
                    double grade = Double.parseDouble(gradeField.getText());
                    String studentID = studentIDField.getText();
                    if (!name.isEmpty() && age > 0 && grade >= 0 && grade <= 100) {
                        manager.addStudent(new Student(name, age, grade, studentID));
                        updateStudentList();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter valid values.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for age and grade.");
                }
            }
        });
        panel.add(addButton);

        JButton removeButton = new JButton("Remove Student");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentIDField.getText();
                if (!studentID.isEmpty()) {
                    manager.removeStudent(studentID);
                    updateStudentList();
                }
            }
        });
        panel.add(removeButton);

        JButton updateButton = new JButton("Update Student");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentIDField.getText();
                String name = nameField.getText();
                try {
                    int age = Integer.parseInt(ageField.getText());
                    double grade = Double.parseDouble(gradeField.getText());
                    if (!studentID.isEmpty()) {
                        manager.updateStudent(studentID, new Student(name, age, grade, studentID));
                        updateStudentList();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for age and grade.");
                }
            }
        });
        panel.add(updateButton);

        JButton displayButton = new JButton("Display All Students");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentList();
            }
        });
        panel.add(displayButton);

        JButton calculateButton = new JButton("Calculate Average");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double average = manager.calculateAverageGrade();
                textArea.setText("Average grade: " + average);
            }
        });
        panel.add(calculateButton);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void updateStudentList() {
        textArea.setText(""); // Clear the text area
        ArrayList<Student> students = manager.displayAllStudents();
        for (Student student : students) {
            textArea.append(student.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        new StudentManagerGUI();
    }
}