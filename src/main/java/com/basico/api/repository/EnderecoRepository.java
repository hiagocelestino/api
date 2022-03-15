package com.basico.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.basico.api.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	
	@Query(value = "Select * from api.enderecos where cliente_id = ?", nativeQuery = true)
	public Iterable<Endereco> findByIdCliente(@Param("cliente_id") Long cliente_id);

}
