import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int StudentNum = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < StudentNum; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String StudentName = sc.nextLine();

            System.out.print("Enter the number of assignments for " + StudentName + ": ");
            int AssignmentNum = sc.nextInt();
            double totalScore = 0;

            for (int j = 0; j < AssignmentNum; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                double score = sc.nextDouble();
                totalScore += score;
            }

            double average = totalScore / AssignmentNum;
            char grade;

            if (average >= 90) {
                grade = 'A';
            } else if (average >= 80) {
                grade = 'B';
            } else if (average >= 70) {
                grade = 'C';
            } else if (average >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            sc.nextLine();
            System.out.println("\n" + StudentName + " - Average: " + average + " - Grade: " + grade);
        }

        sc.close();
    }
}
