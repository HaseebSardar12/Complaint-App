package com.example.complaintapp;

public class Customer {
    private String cName;
    private String Problem;
    private String companyName;
    private String imgUrl;
    private double expectedPrice;
    private String contact;
    private int date, month, year;

    public Customer() {
    }

    public Customer(String cName, String problem, String companyName, String imgUrl, double expectedPrice, String contact, int date, int month, int year) {
        this.cName = cName;
        Problem = problem;
        this.companyName = companyName;
        this.imgUrl = imgUrl;
        this.expectedPrice = expectedPrice;
        this.contact = contact;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
