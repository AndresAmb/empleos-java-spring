package com.andres.empleos.service;

import com.andres.empleos.model.Categoria;

import java.util.List;


public interface ICategoriasService {
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);
	
	// Ejercicio: Implementar método
	void eliminar(Integer idCategoria);
}
