package com.prakarsh.projects.airBnbApp.service;

import com.prakarsh.projects.airBnbApp.dto.RoomDto;
import com.prakarsh.projects.airBnbApp.entity.Hotel;
import com.prakarsh.projects.airBnbApp.entity.Room;
import com.prakarsh.projects.airBnbApp.exception.ResourceNotFoundException;
import com.prakarsh.projects.airBnbApp.repository.HotelRepository;
import com.prakarsh.projects.airBnbApp.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;
    @Override
    public RoomDto createNewRoom(Long hotelId ,RoomDto roomDto) {
        log.info("creating a new room with id:{}",hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("hotel not found with  id:{}",+hotelId));
        Room room =modelMapper.map(roomDto, Room.class);
        log.info("Entity BasePrice: {}", room.getBasePrice());

        room.setHotel(hotel);
        room= roomRepository.save(room);

        if(hotel.getActive()){
            inventoryService.initializedRoomForAYear(room);
        }
        return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("getting all rooms in hotel with id:{}",hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("hotel not found with  id:{}",+hotelId));

        return hotel.getRooms().stream().map((element)-> modelMapper.map(element,RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("getting the room with id:{}",roomId);
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found with ID: ",+roomId));
        return modelMapper.map(room,RoomDto.class);
    }

    @Transactional
    @Override
    public void deleteRoomById(Long roomId) {
        log.info("Deleting the room with id:{}",roomId);
        Room room = roomRepository.findById(roomId)
                        .orElseThrow(()->new ResourceNotFoundException("Room not found with ID: ",+roomId));

        inventoryService.deleteFutureInventories(room);
        roomRepository.deleteById(roomId);
    }
}
