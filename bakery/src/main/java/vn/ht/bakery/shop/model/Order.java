package vn.ht.bakery.shop.model;

import java.util.Date;

public class Order {
    private long id;
    private String nameCustomer;
    private String phone;
    private String address;
    private String bakeryName;
    private int quantity;
    private double price;
    private Date date;
    private double total;

    public Order() {
    }

    public Order(long id, String nameCustomer, String phone, String address, String bakeryName, int quantity, double price, Date date, double total) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.phone = phone;
        this.address = address;
        this.bakeryName = bakeryName;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBakeryName() {
        return bakeryName;
    }

    public void setBakeryName(String bakeryName) {
        this.bakeryName = bakeryName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", bakeryName='" + bakeryName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}
