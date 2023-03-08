package com.example.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Product implements Serializable, Comparable<Product> {
    private static int nextId = 1;

    private final int id;
    private String name;
    private String manufacturer;
    private double price;
    private Date storageTime;
    private int amount;
    private String universalProductCode;

    public Product() {
        this.id = nextId++;
        this.name = "";
        this.manufacturer = "";
        this.price = 0;
        this.storageTime = DateUtils.asDate(LocalDate.now());
        this.amount = 0;
        this.universalProductCode = "";
    }

    public Product(String name, String manufacturer, double price, Date storageTime, int amount, String universalProductCode) {
        this.id = nextId++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.storageTime = storageTime;
        this.amount = amount;
        this.universalProductCode = universalProductCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUniversalProductCode() {
        return universalProductCode;
    }

    public void setUniversalProductCode(String universalProductCode) {
        this.universalProductCode = universalProductCode;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String formattedStorageTime = dateFormat.format(this.storageTime);

        return "Product{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", manufacturer=" + this.manufacturer + '\'' +
                ", price=" + this.price + '\'' +
                ", storageTime=" + formattedStorageTime + '\'' +
                ", amount=" + this.amount + '\'' +
                ", UPC=" + this.universalProductCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Product product)) {
            return false;
        }

        return Objects.equals(getName(), product.getName()) &&
                Objects.equals(getManufacturer(), product.getManufacturer()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getStorageTime(), product.getStorageTime()) &&
                Objects.equals(getAmount(), product.getAmount()) &&
                Objects.equals(getUniversalProductCode(), product.getUniversalProductCode());
    }

    @Override
    public int compareTo(Product other) {
        double totalPrice1 = getTotalPrice();
        double totalPrice2 = other.getTotalPrice();

        return Double.compare(totalPrice1, totalPrice2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getName(),
                getManufacturer(),
                getPrice(),
                getStorageTime(),
                getAmount(),
                getUniversalProductCode());
    }

    private double getTotalPrice() {
        return this.price * this.amount;
    }
}
