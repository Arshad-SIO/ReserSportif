package com.example.resersportif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resersportif.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}