package com.store.car.controller;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCatSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity changesCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") UUID id) {
        carPostService.changesCarSales(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCarSales(@PathVariable("id") UUID id) {
        carPostService.removeCarSales(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
