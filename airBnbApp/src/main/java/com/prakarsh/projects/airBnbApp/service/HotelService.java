package com.prakarsh.projects.airBnbApp.service;

import com.prakarsh.projects.airBnbApp.dto.HotelDto;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id, HotelDto hotelDto);
    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);
}
