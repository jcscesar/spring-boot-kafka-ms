package com.portalcurso.portalcurso.client;


import com.portalcurso.portalcurso.dto.CarPostDTO;
import com.portalcurso.portalcurso.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POST_STORE_SERVICE_URI = "http://localhost:8080/sales";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDTO> carForSalesClient() {
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostsClient(OwnerPostDTO newUser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void changesCarForSalesClient(CarPostDTO carPostDTO, String id) {
        restTemplate.put(POST_STORE_SERVICE_URI+"/car/"+id, carPostDTO, CarPostDTO.class);
    }
    public void deleteCarForSalesClient(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URI+"/car/"+id);
    }


}
