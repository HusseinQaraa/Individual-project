package individualProject;

class Teacher extends Person {
    private String grade; // Grade field for teachers

    public Teacher(String name, String email, String emergencyContact, String grade) {
        super(name, email, emergencyContact);
        this.grade = grade; // Initialize grade
    }

    public String getGrade() {
        return grade; // Getter for grade
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String toFileString() {
        return super.toString() + "," + grade; // Include grade in file string
    }
}