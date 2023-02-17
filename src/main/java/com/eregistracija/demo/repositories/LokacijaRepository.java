package com.eregistracija.demo.repositories;

import com.eregistracija.demo.model.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
}