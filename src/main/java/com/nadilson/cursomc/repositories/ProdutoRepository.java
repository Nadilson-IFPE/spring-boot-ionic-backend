package com.nadilson.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nadilson.cursomc.domain.Categoria;
import com.nadilson.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	// Se a Query não estiver comentada, o comando seguinte não é executado, pois o JPA dará prioridade à Query,
	// que vai sobrepor o método findDistinctByNomeContainingAndCategoriasIn a seguir.
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE "
			+ "obj.nome LIKE %:nome% AND cat IN :categorias")
    
	//	Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	
	// Padrão de nomes do Spring Data. Ele cria a consulta automaticamente.
	// Link útil (tabela 3): https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods 
	// Adicionar o nome do método a seguir no return do metodo search() da classe ProdutoService
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);	
}
