package com.portalcurso.portalcurso.service;

import com.portalcurso.portalcurso.client.CarPostStoreClient;
import com.portalcurso.portalcurso.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarForSales() {
        return carPostStoreClient.carForSalesClient();
    }

    @Override
    public void changeCarForSales(CarPostDTO carPostDto, String id) {
        carPostStoreClient.changesCarForSalesClient(carPostDto, id);
    }

    @Override
    public void removeCarSales(String id) {
        carPostStoreClient.deleteCarForSalesClient(id);
    }
}
