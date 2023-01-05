package com.andres.empleos.repository;

import com.andres.empleos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}