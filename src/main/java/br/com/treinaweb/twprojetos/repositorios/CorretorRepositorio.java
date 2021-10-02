package br.com.treinaweb.twprojetos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twprojetos.model.Corretor;

public interface CorretorRepositorio extends JpaRepository<Corretor,Long>{
    
    
}
