package com.prakarsh.projects.airBnbApp.dto;


import com.prakarsh.projects.airBnbApp.entity.HotelContactInfo;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HotelDto {

    private Long id;
    private String name;
    private String city;
    private HotelContactInfo contactInfo;
    private String[] photos;
    private String[] amenities;
    private LocalDateTime createdAt;
    private  Boolean active;

}
