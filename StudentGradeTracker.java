import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static class Student {
        int id;
        String name;
        double marks;
        String grade;

        Student(int id, String name, double marks) {

            this.id = id;
            this.name = name;
            this.marks = marks;
            this.calculateGrade();
        }
        public void calculateGrade() {

            if (marks >= 90) {
                grade = "A+";
            } else if (marks >= 80) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "B";
            } else if (marks >= 60) {
                grade = "C";
            } else if (marks >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }
        }
    }
    static class GradeManager {

        ArrayList<Student> students = new ArrayList<>();

        public void addStudent(Student student) {

            students.add(student);

            System.out.println("Student Added");
        }

        public void displayStudents() {

            if (students.isEmpty()) {

                System.out.println("\nNo Students Found");
                return;
            }

            System.out.println("\nSTUDENT REPORT");

            System.out.printf("%-10s %-20s %-10s %-10s\n",
                    "ID", "NAME", "MARKS", "GRADE");

            for (Student s : students) {

                System.out.printf("%-10d %-20s %-10.2f %-10s\n",
                        s.id, s.name, s.marks, s.grade);
            }
        }

        public double getAverageMarks() {

            if (students.isEmpty()) {
                return 0;
            }

            double total = 0;

            for (Student s : students) {
                total += s.marks;
            }

            return total / students.size();
        }

        public double getHighestMarks() {

            if (students.isEmpty()) {
                return 0;
            }

            double highest = students.get(0).marks;

            for (Student s : students) {

                if (s.marks > highest) {
                    highest = s.marks;
                }
            }
            return highest;
        }

        public double getLowestMarks() {

            if (students.isEmpty()) {
                return 0;
            }

            double lowest = students.get(0).marks;

            for (Student s : students) {

                if (s.marks < lowest) {
                    lowest = s.marks;
                }
            }

            return lowest;
        }

        public void showStats() {

            System.out.println("\nSTATISTICS");

            System.out.println("Average Marks : " + getAverageMarks());

            System.out.println("Highest Marks : " + getHighestMarks());

            System.out.println("Lowest Marks  : " + getLowestMarks());
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        GradeManager manager = new GradeManager();

        int choice;

        do {

            System.out.println("\nSTUDENT GRADE TRACKER");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Statistics");
            System.out.println("4. Exit");

            System.out.print("\nEnter Your Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("\nEnter Student ID: ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Student Marks: ");
                    double marks = input.nextDouble();

                    if (marks < 0 || marks > 100) {

                        System.out.println("\nInvalid Marks!");
                        break;
                    }

                    Student student = new Student(id, name, marks);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.displayStudents();

                    break;

                case 3:

                    manager.showStats();

                    break;

                case 4:

                    System.out.println("\nExiting Program...");
                    break;

                default:

                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 4);

        input.close();
    }
}