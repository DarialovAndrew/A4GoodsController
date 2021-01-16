package com.example.demo.service.repository;


import com.example.demo.service.model.Apparatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApparatusRepository extends JpaRepository<Apparatus, UUID> {
}
