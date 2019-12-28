package com.back.repository;

import org.springframework.data.repository.CrudRepository;

import com.back.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	Usuario findById(long id);
}
