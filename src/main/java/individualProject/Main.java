package individualProject;

import java.util.Scanner;



public class Main {
    private static SchoolDatabase schoolDatabase = new SchoolDatabase();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        schoolDatabase.loadStudents();
        schoolDatabase.loadTeachers();

        while (true) {
            System.out.println("School Database Menu:");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Generate Student Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageTeachers();
                    break;
                case 3:
                    schoolDatabase.generateReport();
                    System.out.println("Report generated: report.txt");
                    break;
                case 4:
                    schoolDatabase.saveStudents();
                    schoolDatabase.saveTeachers();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void manageStudents() {
        while (true) {
            System.out.println("Manage Students Menu:");
            schoolDatabase.listStudents();
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void manageTeachers() {
        while (true) {
            System.out.println("Manage Teachers Menu:");
            schoolDatabase.listTeachers();
            System.out.println("1. Add Teacher");
            System.out.println("2. Edit Teacher");
            System.out.println("3. Remove Teacher");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    editTeacher();
                    break;
                case 3:
                    removeTeacher();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter emergency contact number : ");
        String emergencyContact = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, email, emergencyContact, grade);
        schoolDatabase.addStudent(student);
    }

    private static void editStudent() {
        System.out.print("Enter index of student to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < schoolDatabase.students.size()) {
            addStudent(); // Reuse addStudent for editing
            System.out.println("Student updated.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter index of student to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        schoolDatabase.removeStudent(index);
        System.out.println("Student removed.");
    }

    private static void addTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter teacher email: ");
        String email = scanner.nextLine();
        System.out.print("Enter emergency contact number: ");
        String emergencyContact = scanner.nextLine();
        System.out.print("Enter teacher grade: ");
        String grade = scanner.nextLine();

        Teacher teacher = new Teacher(name, email, emergencyContact, grade);
        schoolDatabase.addTeacher(teacher);
    }

    private static void editTeacher() {
        System.out.print("Enter index of teacher to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < schoolDatabase.teachers.size()) {
            addTeacher();
            System.out.println("Teacher updated.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void removeTeacher() {
        System.out.print("Enter index of teacher to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        schoolDatabase.removeTeacher(index);
        System.out.println("Teacher removed.");
    }
}