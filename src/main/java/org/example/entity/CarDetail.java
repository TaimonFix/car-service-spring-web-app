package org.example.entity;

public class CarDetail {

    private String detailID;
    private String title;

    public CarDetail(String detailID, String title) {
        this.detailID = detailID;
        this.title = title;
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
