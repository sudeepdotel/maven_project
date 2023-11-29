package model;

public class Employee {
    private int employeeId;
    private String name;
    private String address;
    private String email;
    private int experience;




    public Employee(int employeeId, String name, String address, String email, int experience) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.experience = experience;
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}

