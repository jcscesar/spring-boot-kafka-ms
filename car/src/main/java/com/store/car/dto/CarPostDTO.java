package com.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {

    private String model;
    private String brand;
    private String prince;
    private String description;
    private String engiveVersion;
    private String city;
    private String createdDate;
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;

}
