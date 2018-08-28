package com.alexandre.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.api.domain.Categoria;
import com.alexandre.api.domain.Cliente;
import com.alexandre.api.repositories.ClienteRepository;
import com.alexandre.api.services.exeptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente Buscar(Integer id) {

		Optional<Cliente> obj = clienteRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + "Tipo" + " " + Categoria.class.getName()));

	}

}
