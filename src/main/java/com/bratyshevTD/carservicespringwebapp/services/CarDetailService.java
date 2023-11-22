package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.CarDetail;

import java.util.ArrayList;
import java.util.List;

public class CarDetailService {

    private List<CarDetail> carDetail;

    public List<CarDetail> getCarDetailList() {
        return carDetail;
    }

    public void init() {
        carDetail = new ArrayList<>();
        carDetail.add(new CarDetail("dms-290", "Запчасть"));
        carDetail.add(new CarDetail("dbh-305", "Деталь"));
    }
}
