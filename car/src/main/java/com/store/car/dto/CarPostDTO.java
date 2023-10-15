package com.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {
    private String model;
    private String brand;
    private Double prince;
    private String description;
    private String engiveVersion;
    private String city;
    private String createdDate;
    private UUID ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;


}
