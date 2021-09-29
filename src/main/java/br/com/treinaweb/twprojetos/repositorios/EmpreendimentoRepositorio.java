package br.com.treinaweb.twprojetos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twprojetos.model.Empreendimento;

public interface EmpreendimentoRepositorio  extends JpaRepository<Empreendimento,Long>{
    
}
