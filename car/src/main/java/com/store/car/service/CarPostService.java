package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void mewPostDetails(CarPostDTO carPostDTO);

    List<CarPostDTO> getCatSales();

    void changesCarSales(CarPostDTO carPostDTO, Long postId);

    void removeCarSales(Long postId);

}
