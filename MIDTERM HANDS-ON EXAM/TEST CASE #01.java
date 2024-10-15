import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        
        double classTotal = 0; 
        double highestScore = 0;
        double lowestScore = 100; 

        for (int i = 1; i <= numStudents; i++) {
            input.nextLine(); 
            System.out.print("Enter the name of student " + i + ": ");
            String studentName = input.nextLine();
            
            System.out.print("Enter the number of assignments for " + studentName + ": ");
            int numAssignments = input.nextInt();
            
            double totalScore = 0;
            for (int j = 1; j <= numAssignments; j++) {
                System.out.print("Enter score for assignment " + j + ": ");
                double score = input.nextDouble();
                totalScore += score;
            }

            double averageScore = totalScore / numAssignments;
            classTotal += averageScore;

            if (averageScore > highestScore) {
                highestScore = averageScore;
            }
            if (averageScore < lowestScore) {
                lowestScore = averageScore;
            }

            char grade;
            if (averageScore >= 90) {
                grade = 'A';
            } else if (averageScore >= 80) {
                grade = 'B';
            } else if (averageScore >= 70) {
                grade = 'C';
            } else if (averageScore >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("\n--- Student Information ---");
            System.out.println("Name: " + studentName);
            System.out.println("Average Score: " + averageScore);
            System.out.println("Letter Grade: " + grade);
            System.out.println();
        }

        double classAverage = classTotal / numStudents;
        System.out.println("\n--- Class Summary ---");
        System.out.println("Class Average: " + classAverage);
        System.out.println("Highest Average Score: " + highestScore);
        System.out.println("Lowest Average Score: " + lowestScore);

        input.close();
    }
}
