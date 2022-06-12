package com.example.project.ui.gallery;

public class Order {
    private String id;
    private String dinner_id;
    private String order_Status;
    private String customer_id;
    private String order_date;
    private String price;
    private String dinner_name;

    public Order(String id, String dinner_id, String order_Status, String customer_id, String order_date, String price,
                 String Dinner_name) {
        this.id = id;
        this.dinner_id = dinner_id;
        this.order_Status = order_Status;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.price = price;
        this.dinner_name = Dinner_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDinner_id() {
        return dinner_id;
    }

    public void setDinner_id(String dinner_id) {
        this.dinner_id = dinner_id;
    }

    public String getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDinner_name() {
        return dinner_name;
    }

    public void setDinner_name(String dinner_name) {
        this.dinner_name = dinner_name;
    }
}
