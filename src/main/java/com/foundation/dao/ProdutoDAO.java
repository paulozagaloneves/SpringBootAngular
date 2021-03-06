package com.foundation.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.foundation.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Long> {

	Page<Produto> findAll(Pageable pageable);
}
