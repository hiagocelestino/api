package com.basico.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.basico.api.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	public Optional<Iterable<Pedido>> findAllByClienteId(Long clienteId);

}
