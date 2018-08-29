package com.alexandre.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.api.domain.Pedido;
import com.alexandre.api.repositories.PedidoRepository;
import com.alexandre.api.services.exeptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido buscar(Integer id) {

		Optional<Pedido> obj = pedidoRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + "Tipo" + " " + Pedido.class.getName()));

	}

}
