package com.store.car.controller;

import com.store.car.dto.CarPostDTO;
import com.store.car.message.KafkaCosumerMessage;
import com.store.car.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    private final Logger LOG = LoggerFactory.getLogger(KafkaCosumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCatSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<CarPostDTO> changesCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id) {
        carPostService.changesCarSales(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<CarPostDTO> deleteCarSales(@PathVariable("id") Long id) {
        carPostService.removeCarSales(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
