package br.com.treinaweb.twprojetos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.treinaweb.twprojetos.model.Cliente;
import br.com.treinaweb.twprojetos.model.StatusCliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {

    @Query("select c from Cliente c where c.status = :arguardando_contato or c.status = :sem_simulacao or c.status = :negado")
    List<Cliente> buscarinativos(StatusCliente arguardando_contato, StatusCliente sem_simulacao,StatusCliente negado);
    
}
