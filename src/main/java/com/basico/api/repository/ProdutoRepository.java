package com.basico.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.basico.api.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
