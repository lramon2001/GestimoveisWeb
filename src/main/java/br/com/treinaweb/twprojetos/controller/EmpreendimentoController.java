package br.com.treinaweb.twprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.treinaweb.twprojetos.model.Empreendimento;
import br.com.treinaweb.twprojetos.model.UF;
import br.com.treinaweb.twprojetos.repositorios.ClienteRepositorio;
import br.com.treinaweb.twprojetos.repositorios.EmpreendimentoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/projetos")
public class EmpreendimentoController {

    @Autowired
    private EmpreendimentoRepositorio empreendimentoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("projeto/home");

        modelAndView.addObject("projetos", empreendimentoRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("projeto/detalhes");

        modelAndView.addObject("projeto", empreendimentoRepositorio.findById(id).get());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("projeto/formulario");

        modelAndView.addObject("projeto", new Empreendimento());
        modelAndView.addObject("clientes", clienteRepositorio.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("projeto/formulario");

        modelAndView.addObject("projeto", empreendimentoRepositorio.getOne(id));
        modelAndView.addObject("clientes", clienteRepositorio.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar","/{id}/editar"})
    public String salvar(Empreendimento empreendimento){
        empreendimentoRepositorio.save(empreendimento);

        return "redirect:/projetos";
    }
    
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        empreendimentoRepositorio.deleteById(id);

        return "redirect:/projetos";
    }

    
}
