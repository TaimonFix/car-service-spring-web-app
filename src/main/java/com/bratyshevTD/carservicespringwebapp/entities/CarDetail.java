package com.bratyshevTD.carservicespringwebapp.entities;

import jakarta.persistence.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Table(name= "car_detail")
public class CarDetail {

    @Id
    @Column(name = "detail_id")
    private String detailID;

    @Column(name = "title")
    private String title;

    public CarDetail() {
    }

    public CarDetail(String detailID, String title) {
        this.detailID = detailID;
        this.title = title;
    }

    public void setRandomDetailID() {
        String detailID = "";
        Random r = new Random();

        for (int i = 0; i < 3; i++) {
            char c = (char) (r.nextInt(26) + 'A');
            detailID += c;
        }
        detailID += '-';

        for (int i = 0; i < 3; i++) {
            int n = r.nextInt(9);
            detailID += n;
        }
        this.detailID = detailID;
    }

    public void setRandomTitle (File file) throws Exception{

        ArrayList<String> titleList = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Random r = new Random();

        while (bufferedReader.ready()) {
            titleList.add(bufferedReader.readLine());
        }

        this.title = titleList.get(r.nextInt(titleList.size()));
    }
    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CarDetail{" +
                "detailID='" + detailID + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
