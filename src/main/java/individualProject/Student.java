package individualProject;

class Student extends Person {
    private String grade; // Grade field for students

    public Student(String name, String email, String emergencyContact, String grade) {
        super(name, email, emergencyContact);
        this.grade = grade; // Initialize grade
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String toFileString() {
        return super.toString() + "," + grade; // Updated to include only grade
    }
}