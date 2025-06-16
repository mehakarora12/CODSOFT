import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Taking input of marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validation for marks
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks! Please enter between 0 to 100: ");
                marks[i] = scanner.nextInt();
            }
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Calculate grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display Results
        System.out.println("\n----- Result Summary -----");
        System.out.println("Total Marks Obtained: " + totalMarks + "/" + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Final Grade: " + grade);
        System.out.println("-----------------------------");

        scanner.close();
    }
}