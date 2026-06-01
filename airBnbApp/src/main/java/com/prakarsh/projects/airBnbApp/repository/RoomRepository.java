package com.prakarsh.projects.airBnbApp.repository;

import com.prakarsh.projects.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
