package br.com.treinaweb.twprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twprojetos.model.Cliente;
import br.com.treinaweb.twprojetos.model.EstadoCivil;
import br.com.treinaweb.twprojetos.model.Genero;
import br.com.treinaweb.twprojetos.model.StatusCliente;
import br.com.treinaweb.twprojetos.model.UF;
import br.com.treinaweb.twprojetos.repositorios.ClienteRepositorio;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

@Autowired
private ClienteRepositorio clienteRepositorio;

@GetMapping
public ModelAndView home(){
    ModelAndView modelAndView = new ModelAndView("cliente/home");

    modelAndView.addObject("clientes", clienteRepositorio.findAll());

    return modelAndView;

}
@GetMapping("/{id}")
public ModelAndView detalhes(@PathVariable Long id){
    ModelAndView modelAndView = new ModelAndView("cliente/detalhes");

    modelAndView.addObject("cliente", clienteRepositorio.findById(id).get());

    return modelAndView;
}
@GetMapping("/cadastrar")
public ModelAndView cadastrar(){
    ModelAndView modelAndView= new ModelAndView ("cliente/formulario");
    

    modelAndView.addObject("cliente", new Cliente());
    modelAndView.addObject("ufs", UF.values());
    modelAndView.addObject("statuses", StatusCliente.values());
    modelAndView.addObject("generos", Genero.values());
    modelAndView.addObject("estadosCivis", EstadoCivil.values());

    return modelAndView;
}

@GetMapping("/{id}/editar")
public ModelAndView editar(@PathVariable Long id){
    ModelAndView modelAndView= new ModelAndView("cliente/formulario");

    modelAndView.addObject("cliente", clienteRepositorio.findById(id).get());
    modelAndView.addObject("ufs", UF.values());
    modelAndView.addObject("status", StatusCliente.values());
    return modelAndView;

}
@PostMapping({"/cadastrar","/{id}/editar"})
public String salvar(Cliente cliente){
    clienteRepositorio.save(cliente);

    return "redirect:/clientes";
}



@GetMapping("/{id}/excluir")
public String excluir (@PathVariable Long id){
    clienteRepositorio.deleteById(id);

    return "redirect:/clientes";
}
}
