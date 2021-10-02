package br.com.treinaweb.twprojetos.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twprojetos.model.Corretor;
import br.com.treinaweb.twprojetos.model.UserDetailsImpl;
import br.com.treinaweb.twprojetos.repositorios.CorretorRepositorio;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private CorretorRepositorio corretorRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        

        Corretor corretor = corretorRepositorio.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));
        
        return new UserDetailsImpl(corretor);
            
        
    }


    
}
