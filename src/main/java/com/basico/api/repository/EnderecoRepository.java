package com.basico.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.basico.api.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	
	@Query(value = "Select * from api.enderecos where id_cliente = ?", nativeQuery = true)
	public Iterable<Endereco> findByIdCliente(@Param("id_cliente") Long id_cliente);

}
