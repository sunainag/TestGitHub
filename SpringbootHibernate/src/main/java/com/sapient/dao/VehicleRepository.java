package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
