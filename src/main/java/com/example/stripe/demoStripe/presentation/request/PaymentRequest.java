package com.example.stripe.demoStripe.presentation.request;

public class PaymentRequest {
    private String description;
    private double amount;
    private String token;
    // Añade más atributos según tus necesidades

    // Agrega getters y setters


    public PaymentRequest() {
    }

    public PaymentRequest(String description, double amount, String token) {
        this.description = description;
        this.amount = amount;
        this.token = token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
