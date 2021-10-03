package br.com.gestimoveis.gprojetos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestimoveis.gprojetos.model.Empreendimento;

public interface EmpreendimentoRepositorio  extends JpaRepository<Empreendimento,Long>{
    
}
