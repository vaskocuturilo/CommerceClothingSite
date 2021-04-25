package model;

public class Register {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String zipCode;
    private String state;
    private String phone;

    public Register(String firstName, String lastName, String password, String address, String city, String zipCode, String state, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }
}
