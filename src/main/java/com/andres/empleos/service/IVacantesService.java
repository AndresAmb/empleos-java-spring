package com.andres.empleos.service;

import com.andres.empleos.model.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);
    void guardar(Vacante vacante);
}
