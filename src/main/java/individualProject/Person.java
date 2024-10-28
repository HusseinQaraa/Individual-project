package individualProject;


class Person {
    protected String name;
    protected String email;
    protected String emergencyContact;

    public Person(String name, String email, String emergencyContact) {
        this.name = name;
        this.email = email;
        this.emergencyContact = emergencyContact;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    @Override
    public String toString() {
        return name + "," + email + "," + emergencyContact;
    }
}