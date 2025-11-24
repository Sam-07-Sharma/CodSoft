import java.util.Scanner;

public class Grade_Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Student Grade Calculator");

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        double totalMarks = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            double marks = sc.nextDouble();
            totalMarks += marks;
        }

        double avg = totalMarks / n;

        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("-----------------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avg);
        System.out.println("Grade: " + grade);
    }
}