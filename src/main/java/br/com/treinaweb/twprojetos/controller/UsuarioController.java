package br.com.treinaweb.twprojetos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twprojetos.model.Corretor;
import br.com.treinaweb.twprojetos.repositorios.CorretorRepositorio;

@Controller

public class UsuarioController {
   
    @Autowired
    private CorretorRepositorio corretorRepositorio;
    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }

    @GetMapping("/perfil")
    public ModelAndView perfil(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("usuario/perfil");
        
        Corretor usuario = corretorRepositorio.findByEmail(principal.getName()).get();
        modelAndView.addObject("logado", usuario);

        return modelAndView;
    }



}
