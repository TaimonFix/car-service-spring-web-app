package org.example.entity;

public class Client {

    private int clientID;
    private String fullName;
    private String phone;

    public Client(int clientID, String fullName, String phone) {
        this.clientID = clientID;
        this.fullName = fullName;
        this.phone = phone;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


