import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice", 40, "Math");
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Siyahluma", 28, 1001, 0.0));
        students.add(new Student("Milani", 22, 1002, 0.0));
        students.add(new Student("Aphiwe", 23, 1003, 0.0));
        students.add(new Student("Sandile", 24, 1004, 0.0));
        students.add(new Student("Lihle", 19, 1005, 0.0));
        students.add(new Student("Ayongezwa", 20, 1006, 0.0));

        Scanner scanner = new Scanner(System.in);

        for (Student student : students) {
            System.out.print("Enter grade for student " + student.getName() + ": ");
            try {
                double grade = scanner.nextDouble();
                teacher.assignGrade(student, grade);
                System.out.println("Result: " + student.evaluateGrade());  // Display the evaluation result
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
                scanner.next();  // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Grade assignment process completed for " + student.getName());
            }
            student.displayInfo();
        }

        scanner.close();
    }
}
