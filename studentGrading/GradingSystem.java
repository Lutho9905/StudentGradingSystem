import java.util.Scanner;


class student {
    private String name;
    private int mark;

    public student(String name, int mark){
        this.name = name;
        this.mark = mark;    }

        public String getName(){
            return name;
        }
        public int getMark(){
            return mark;
        }
}
// Base class for grading
class Grader {
    public String evaluate(int mark) throws IllegalArgumentException {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100.");
        }
        if (mark >= 75 && mark <=100) {
            return "Pass with distinction";
        } else if (mark >= 50 && mark <75) {
            return "Pass";
        } else if (mark >= 40 && mark < 50) {
            return "Qualify for re-exam";
        } else {
            return "Fail";
        }
    }
}


class AdvancedGrader extends Grader {
    @Override
    public String evaluate(int mark) throws IllegalArgumentException {
        //here I wanted to more grading e.g if a student gets >85 it returns A+, so on.
        return super.evaluate(mark);
    }
}

// Main class to handle user input and exceptions
public class GradingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        input.nextLine(); // Consume the newline character

        student[] students = new student[numberOfStudents];
        
 
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = input.nextLine();
            
            System.out.print("Enter mark for " + name + ": ");
            int mark = input.nextInt();
            input.nextLine(); // Consume the newline character
            
            students[i] = new student(name, mark);
        }

        Grader grader = new AdvancedGrader(); // Using polymorphism
        
   
        for (student student : students) {
            try {
                String result = grader.evaluate(student.getMark());
                System.out.print(student.getName() + ": " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error for " + student.getName() + ": " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred for " + student.getName() + ": " + e.getMessage());
            }
        }

        input.close(); // Ensure the scanner is closed
    }
}
