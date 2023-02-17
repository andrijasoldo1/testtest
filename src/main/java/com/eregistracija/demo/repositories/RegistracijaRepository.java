package com.eregistracija.demo.repositories;

import com.eregistracija.demo.model.Registracija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistracijaRepository extends JpaRepository<Registracija, Long> {
}