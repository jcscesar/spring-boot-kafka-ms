package com.portalcurso.portalcurso.service;

import com.portalcurso.portalcurso.client.CarPostStoreClient;
import com.portalcurso.portalcurso.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServerImpl implements OwnerPostServer {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
