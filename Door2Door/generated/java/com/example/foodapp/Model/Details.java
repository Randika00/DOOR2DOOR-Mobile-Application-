package com.example.foodapp.Model;

public class Details {
    private String account, bankName, type;

    public Details() {

    }
    public Details(String account, String bankName, String type) {
        this.account = account;
        this.bankName = bankName;
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}