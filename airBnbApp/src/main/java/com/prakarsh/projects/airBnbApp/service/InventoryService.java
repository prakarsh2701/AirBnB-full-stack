package com.prakarsh.projects.airBnbApp.service;

import com.prakarsh.projects.airBnbApp.dto.HotelDto;
import com.prakarsh.projects.airBnbApp.dto.HotelSearchrequest;
import com.prakarsh.projects.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;


public interface InventoryService {
      void initializedRoomForAYear(Room room);

      void deleteFutureInventories(Room room);

      Page<HotelDto> searchHotels(HotelSearchrequest hotelSearchrequest);
}
