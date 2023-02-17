package com.eregistracija.demo.repositories;

import com.eregistracija.demo.model.Osiguranje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OsiguranjeRepository extends JpaRepository<Osiguranje, Long> {
}