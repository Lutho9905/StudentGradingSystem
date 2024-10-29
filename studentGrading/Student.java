public class Student extends Person {
    private int studentId;
    double grade;

    public Student(String name, int age, int studentId, double grade) {
        super(name, age);
        this.studentId = studentId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId + ", Grade: " + grade);
    }

    // New method to evaluate the grade and return a status message
    public String evaluateGrade() {
        if (grade < 40) {
            return "Fail";
        } else if (grade >= 40 && grade < 50) {
            return "Qualifies for Re-exam";
        } else if (grade >= 50 && grade < 75) {
            return "Pass";
        } else {
            return "Pass with Distinction";
        }
    }
}
