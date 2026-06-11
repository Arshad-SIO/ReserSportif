package com.example.resersportif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resersportif.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}