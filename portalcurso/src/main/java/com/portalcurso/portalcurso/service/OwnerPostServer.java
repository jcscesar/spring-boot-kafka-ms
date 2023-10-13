package com.portalcurso.portalcurso.service;

import com.portalcurso.portalcurso.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostServer {
    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
