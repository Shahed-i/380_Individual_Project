package edu.ucalgary.oop;

public class Inquirer extends Person{
    private String info;
    private String servicesPhoneNum;

    // Constructor
    public Inquirer(String firstName, String lastName, String servicesPhoneNum, String info) {
        super(firstName, lastName);
        this.servicesPhoneNum = servicesPhoneNum;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getServicesPhoneNum() {
        return servicesPhoneNum;
    }

}
