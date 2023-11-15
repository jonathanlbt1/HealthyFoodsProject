package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.services.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class ClientController {

    private final ClienteService clienteService;

    public ClientController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @RequestMapping("/cliente/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("cliente", clienteService.lerUnicoCliente(Integer.valueOf(id)));
        return "cliente/show";
    }

    @PostMapping("cliente")
    public String save(@ModelAttribute Cliente cliente){
        Cliente cliente1 = clienteService.novoCliente(cliente);

        return "redirect:/cliente/" + cliente1.getIdCliente() + "/show";
    }

    @PutMapping("cliente")
    public String update(@ModelAttribute Integer id){
        Cliente cliente1 = clienteService.atualizarCliente(id);

        return "redirect:/cliente/" + cliente1.getIdCliente() + "/show";
    }

    @GetMapping
    @RequestMapping("cliente/{id}/delete")
    public String deleteById(@PathVariable String id){

        log.debug("Deleting id: " + id);

        clienteService.deletarCliente(Integer.valueOf(id));
        return "redirect:/";
    }
}
