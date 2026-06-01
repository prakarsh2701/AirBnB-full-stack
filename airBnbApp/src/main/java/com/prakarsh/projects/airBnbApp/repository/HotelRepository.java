package com.prakarsh.projects.airBnbApp.repository;

import com.prakarsh.projects.airBnbApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
