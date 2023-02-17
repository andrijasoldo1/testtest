package com.eregistracija.demo.repositories;

import com.eregistracija.demo.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VoziloRepository extends JpaRepository<Vozilo, Long> {
}