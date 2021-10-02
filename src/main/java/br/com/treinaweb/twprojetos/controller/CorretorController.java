package br.com.treinaweb.twprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twprojetos.model.Corretor;
import br.com.treinaweb.twprojetos.repositorios.CorretorRepositorio;

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
        ModelAndView modelAndView = new ModelAndView("corretor/formulario");

        modelAndView.addObject("corretor", new Corretor());
      
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("corretor/formulario");

        modelAndView.addObject("corretor", corretorRepositorio.findById(id).get());


        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Corretor corretor) {
        corretorRepositorio.save(corretor);

        return "redirect:/corretores";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        corretorRepositorio.deleteById(id);

        return "redirect:/corretores";
    }

    
}
