package com.api.rest.repository;

import com.api.rest.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long>{

    List<Nota> findAll();
}
