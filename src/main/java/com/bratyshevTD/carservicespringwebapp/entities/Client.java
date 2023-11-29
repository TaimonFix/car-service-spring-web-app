package com.bratyshevTD.carservicespringwebapp.entities;

import jakarta.persistence.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Table(name="client")
public class Client {

    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;


    @Column(name="full_name")
    private String fullName;

    @Column(name="phone")
    private String phone;

    public Client() {
    }

    public Client(Long clientID, String fullName, String phone) {
        this.clientID = clientID;
        this.fullName = fullName;
        this.phone = phone;
    }

    private ArrayList<String> getList(File file) throws Exception {

        ArrayList<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()) {
            list.add(bufferedReader.readLine());
        }
        return list;
    }

    public void setRandomFullName(File surnameFile, File nameFile, File patronymicFile) throws Exception {
        Random r = new Random();
        ArrayList<String> surnameList = getList(surnameFile);
        ArrayList<String> nameList = getList(nameFile);
        ArrayList<String> patronymicList = getList(patronymicFile);

        this.fullName = surnameList.get(r.nextInt(surnameList.size())) +" "+
                        nameList.get(r.nextInt(nameList.size())) +" "+
                        patronymicList.get(r.nextInt(patronymicList.size()));
        }

    public void setRandomPhone() {
        Random r = new Random();
        String str1 = String.valueOf(r.nextInt(100));
        String str2 = String.valueOf(r.nextInt(1000));
        String str3 = String.valueOf(r.nextInt(100));
        String str4 = String.valueOf(r.nextInt(100));

        if (str1.length() == 1) {
            str1 = 0 + str1;
        } else if (str1.isEmpty()) {
            str1 = "00";
        }

        if (str2.length() == 1) {
            str2 = "00" + str2;
        } else if (str2.length() == 2) {
            str2 = 0 + str2;
        } else if (str2.isEmpty()) {
            str2 = "000";
        }

        if (str3.length() == 1) {
            str3 = 0 + str3;
        } else if (str3.isEmpty()) {
            str3 = "00";
        }

        if (str4.length() == 1) {
            str4 = 0 + str4;
        } else if (str4.isEmpty()) {
            str4 = "00";
        }
        this.phone = "+7" +"(9"+ str1 +')' +'-'+ str2 +'-' + str3 + '-' + str4;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
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
                "clientID='" + clientID + '\'' +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


