import java.sql.*;
import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {
    private Connection conn;

    // Konstruktor, nawiązywanie połączenia z bazą danych
    public StudentManagerImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (name TEXT, age INTEGER, grade REAL, studentID TEXT PRIMARY KEY)");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Metoda do dodawania studenta
    @Override
    public void addStudent(Student student) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (name, age, grade, studentID) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setDouble(3, student.getGrade());
            pstmt.setString(4, student.getStudentID());

            pstmt.executeUpdate();
            System.out.println("Student added: " + student);
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Student ID already exists: " + student.getStudentID());
            } else {
                System.out.println("Error adding student: " + e.getMessage());
            }
        }
    }

    // Metoda do usuwania studenta
    @Override
    public void removeStudent(String studentID) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE studentID = ?");
            pstmt.setString(1, studentID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student with ID " + studentID + " removed.");
            } else {
                System.out.println("No student found with ID: " + studentID);
            }
        } catch (SQLException e) {
            System.out.println("Error removing student: " + e.getMessage());
        }
    }

    // Metoda do aktualizacji studenta
    @Override
    public void updateStudent(String studentID, Student student) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE students SET name = ?, age = ?, grade = ? WHERE studentID = ?");
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setDouble(3, student.getGrade());
            pstmt.setString(4, student.getStudentID());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student with ID " + studentID + " updated.");
            } else {
                System.out.println("No student found with ID: " + studentID);
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Metoda do wyświetlania wszystkich studentów
    @Override
    public ArrayList<Student> displayAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                students.add(new Student(rs.getString("name"), rs.getInt("age"), rs.getDouble("grade"), rs.getString("studentID")));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
        return students;
    }

    // Metoda do obliczania średniej ocen
    @Override
    public double calculateAverageGrade() {
        double sum = 0;
        int count = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT grade FROM students");
            while (rs.next()) {
                sum += rs.getDouble("grade");
                count++;
            }
        } catch (SQLException e) {
            System.out.println("Error calculating average grade: " + e.getMessage());
        }
        return count == 0 ? 0.0 : sum / count;
    }

    // Zamknięcie połączenia z bazą
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
