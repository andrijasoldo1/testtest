package com.eregistracija.demo.repositories;

import com.eregistracija.demo.model.Vozac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VozacRepository extends JpaRepository<Vozac, Long> {

}