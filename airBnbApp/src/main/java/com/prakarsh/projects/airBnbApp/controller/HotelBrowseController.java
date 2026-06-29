package com.prakarsh.projects.airBnbApp.controller;

import com.prakarsh.projects.airBnbApp.dto.HotelDto;
import com.prakarsh.projects.airBnbApp.dto.HotelSearchrequest;
import com.prakarsh.projects.airBnbApp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {
    private final InventoryService inventoryService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchrequest hotelSearchrequest){
        Page<HotelDto> page = inventoryService.searchHotels(hotelSearchrequest);
        return ResponseEntity.ok(page);
    }
}
