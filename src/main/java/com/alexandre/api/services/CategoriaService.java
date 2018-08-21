package com.alexandre.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.api.domain.Categoria;
import com.alexandre.api.repositories.CategoriaRepository;
import com.alexandre.api.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categotiriaRepository;

	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = categotiriaRepository.findById(id);

		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado Id: " + "Tipo" +" " 
		        + Categoria.class.getName()));
	}

}
