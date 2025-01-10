public class Student {
    private String name;
    private int age;
    private double grade;
    private String studentID;

    // Konstruktor
    public Student(String name, int age, double grade, String studentID) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentID = studentID;
    }

    // Gettery i settery
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be a positive number.");
        }
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0.0 && grade <= 100.0) {
            this.grade = grade;
        } else {
            System.out.println("Grade must be between 0.0 and 100.0.");
        }
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Nadpisana metoda toString()
    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}
