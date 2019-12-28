package com.back.controller;


import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.back.model.Usuario;
import com.back.repository.UsuarioRepository;

@RestController
@RequestMapping(path="/back")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@PostMapping(path="/salvar")
	public @ResponseBody Usuario salvar(@Valid @RequestBody Usuario usuario) {
		ur.save(usuario);
		return usuario;
	}
	
	@GetMapping(path="/listar")
	public Iterable<Usuario> listar(){
		return ur.findAll();
	}
	
	@GetMapping(path="/listar/{id}")
	public Usuario buscarPeloId(@PathVariable("id") long id){
		System.out.println(id);
		Usuario usuario = ur.findById(id);
		return usuario;
	}
	
	@DeleteMapping(path="/excluir/{id}")
	public @ResponseBody Usuario excluir(@PathVariable long id) {
		Usuario usuario = ur.findById(id);
		ur.delete(usuario);
		return usuario;
	}
	
	@PutMapping(path="/atualizar/{id}")
	public @ResponseBody Usuario atualizar(@PathVariable long id, @Valid @RequestBody Usuario novo) {
		Usuario usuario = ur.findById(id);
		BeanUtils.copyProperties(novo, usuario, "id");
		ur.save(usuario);
		return usuario;
	}
}
