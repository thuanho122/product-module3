package vn.ht.bakery.shop.model;

import javax.servlet.http.Part;

public class Bakery {
    private int id;
    private String bakeryName;
    private Double price;
    private long quantity;
    private String description;
    private String logoPath;

    public Bakery() {
    }

    public Bakery(int id, String bakeryName, Double price, long quantity, String description, String logoPath) {
        this.id = id;
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.logoPath = logoPath;
    }

    public Bakery(int id, String bakeryName, Double price, long quantity, String description) {
        this.id = id;
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.logoPath = logoPath;
    }

    public Bakery(String bakeryName, Double price, long quantity, String description) {
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Bakery( String bakeryName, Double price, long quantity, String description, String logoPath) {
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.logoPath = logoPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBakeryName() {
        return bakeryName;
    }

    public void setBakeryName(String bakeryName) {
        this.bakeryName = bakeryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public String toString() {
        return "Bakery{" +
                "id=" + id +
                ", bakeryName='" + bakeryName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", logoPath='" + logoPath + '\'' +
                '}';
    }
}
