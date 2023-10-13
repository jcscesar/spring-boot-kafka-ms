package com.portalcurso.portalcurso.service;

import com.portalcurso.portalcurso.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCarForSales(CarPostDTO carPost, String id);

    void removeCarSales(String id);



}
