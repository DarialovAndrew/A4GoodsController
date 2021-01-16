package com.example.demo.service.repository;


import com.example.demo.service.model.Shower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowerRepository extends JpaRepository<Shower, UUID> {
}
