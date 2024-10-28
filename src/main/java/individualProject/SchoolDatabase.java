package individualProject;

import java.io.*;
import java.util.ArrayList;


class SchoolDatabase {
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Teacher> teachers = new ArrayList<>();
    private final String studentFile = "students.txt";
    private final String teacherFile = "teachers.txt";

    public void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(studentFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) { // Updated to 4 for grade
                    students.add(new Student(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load students: " + e.getMessage());
        }
    }

    public void loadTeachers() {
        try (BufferedReader br = new BufferedReader(new FileReader(teacherFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    teachers.add(new Teacher(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load teachers: " + e.getMessage());
        }
    }

    public void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentFile))) {
            for (Student student : students) {
                bw.write(student.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save students: " + e.getMessage());
        }
    }

    public void saveTeachers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(teacherFile))) {
            for (Teacher teacher : teachers) {
                bw.write(teacher.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save teachers: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeStudent(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
    }

    public void removeTeacher(int index) {
        if (index >= 0 && index < teachers.size()) {
            teachers.remove(index);
        }
    }

    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ": " + students.get(i));
        }
    }

    public void listTeachers() {
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(i + ": " + teachers.get(i));
        }
    }

    public void generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            for (Teacher teacher : teachers) {
                String line = "Teacher: " + teacher.getName() + " (Grade: " + teacher.getGrade() + ")\n";
                reportBuilder.append(line);
                writer.write(line);

                reportBuilder.append("Students:\n");
                writer.write("Students:\n");
                for (Student student : students) {
                    if (student.getGrade().equals(teacher.getGrade())) {
                        String studentLine = "- " + student.getName() + " (Email: " + student.getEmail() + ")\n";
                        reportBuilder.append(studentLine);
                        writer.write(studentLine);
                    }
                }
                reportBuilder.append("\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Print the report to the console
        System.out.println(reportBuilder.toString());
    }

    public void editStudent(int index, Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        }
    }

    public void editTeacher(int index, Teacher teacher) {
        if (index >= 0 && index < teachers.size()) {
            teachers.set(index, teacher);
        }
    }
}