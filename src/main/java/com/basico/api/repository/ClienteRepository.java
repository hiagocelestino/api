package com.basico.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.basico.api.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
