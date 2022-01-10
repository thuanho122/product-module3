package vn.ht.bakery.shop.model;

import javax.management.relation.Role;

public class User {
    private long id;
    private String fullName;
    private String email;
    private String phone;
    private int age;
    private String address;
    private String status;
    private String password;
    private String role;

    public User() {
    }


    public User(long id, String fullName, String email, String phone, int age, String address, String status, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
        this.password = password;
        this.role = role;
    }

    public User(long id, String fullName, String email, String phone, int age, String address, String status,String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    public User(String fullName, String email, String phone, int age, String address, String status, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
        this.password = password;
        this.role = role;
    }


    public User(long id, String fullName, String email, String phone, int age, String address, String status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
    }

    public User(long id, String fullName, String email, String phone, int age, String address) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;

    }


//    public User(long id, String fullName, String email, String phone, int age, String address, String status, String password) {
//        this.id = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.phone = phone;
//        this.age = age;
//        this.address = address;
//        this.status = status;
//        this.password = password;
//    }

    public User(String fullName, String email, String phone, int age, String address, String status, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
        this.password = password;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
