package com.bratyshevTD.carservicespringwebapp.services;

import com.bratyshevTD.carservicespringwebapp.entities.CarOrder;
import com.bratyshevTD.carservicespringwebapp.repositories.CarOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarOrderService {

    private CarOrderRepository carOrderRepository;

    @Autowired
    public void setCarOrderRepository(CarOrderRepository carOrderRepository) {
        this.carOrderRepository = carOrderRepository;
    }

    public List<CarOrder> getAllCarOrders() { return carOrderRepository.findAll(); }

    public CarOrder getById(Long id) { return carOrderRepository.getReferenceById(id); }

    public void addCarOrder(CarOrder carOrder) {carOrderRepository.save(carOrder); }

    public void removeCarOrderById(Long id) { carOrderRepository.deleteById(id); }

    public List<CarOrder> filterWithoutRelationToOtherTables() {
        return carOrderRepository.filterWithoutRelationToOtherTables();
    }
}
