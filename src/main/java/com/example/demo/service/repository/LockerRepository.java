package com.example.demo.service.repository;


import com.example.demo.service.model.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LockerRepository extends JpaRepository<Locker, UUID> {
}

