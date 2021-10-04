package br.com.gestimoveis.gprojetos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gestimoveis.gprojetos.model.Corretor;
import br.com.gestimoveis.gprojetos.repositorios.CorretorRepositorio;
import br.com.gestimoveis.gprojetos.utils.SenhaUtils;

@Controller
@RequestMapping("/corretores")
public class CorretorController {
    @Autowired
    private CorretorRepositorio corretorRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("corretor/home");

        modelAndView.addObject("corretores", corretorRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        List<String> usuarios = new ArrayList<String>();
        usuarios.add("Administrador");
        usuarios.add("Usuário padrão");
        ModelAndView modelAndView = new ModelAndView("corretor/formulario");
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.addObject("corretor", new Corretor());
        
      
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        List<String> usuarios = new ArrayList<String>();
        usuarios.add("Administrador");
        usuarios.add("Usuário padrão");
        
        ModelAndView modelAndView = new ModelAndView("corretor/formulario");
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.addObject("corretor", corretorRepositorio.findById(id).get());
      


        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Corretor corretor) {

        String senhaCriptografada = SenhaUtils.encode(corretor.getSenha()); 

        corretor.setSenha(senhaCriptografada);
        corretorRepositorio.save(corretor);

        return "redirect:/corretores";
    }

    @PostMapping("/{id}/editar")
    public String editar(Corretor corretor, @PathVariable Long id){
        String senhaAtual = corretorRepositorio.findById(id).get().getSenha();
        corretor.setSenha(senhaAtual);

        corretorRepositorio.save(corretor);

        return "redirect:/corretores";

    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        corretorRepositorio.deleteById(id);

        return "redirect:/corretores";
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes (@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("corretor/detalhes");

        modelAndView.addObject("corretor", corretorRepositorio.findById(id).get());

        return modelAndView;
    }

    
}
