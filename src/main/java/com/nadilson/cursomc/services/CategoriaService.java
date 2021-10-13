package com.nadilson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nadilson.cursomc.domain.Categoria;
import com.nadilson.cursomc.repositories.CategoriaRepository;
import com.nadilson.cursomc.services.exceptions.DataIntegrityException;
import com.nadilson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
	//	Categoria obj = repo.findOne(id);
	//	return obj;
		
		//Optional<Categoria> obj = repo.findById(id); 
		Optional<Categoria> obj = repo.findById(id); 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
		//return obj.orElse(null); 
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
		  	throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
		}
	}
}
