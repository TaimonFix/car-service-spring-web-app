package org.example.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class CarDetail {

    private String detailID;
    private String title;

    Random r = new Random();
    public CarDetail(String detailID, String title) {
        this.detailID = detailID;
        this.title = title;
    }

    public void setRandomDetailID() {
        String detailID = "";

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
