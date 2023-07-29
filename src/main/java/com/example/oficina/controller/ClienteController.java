package com.example.oficina.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.oficina.dto.ClienteDTO;
import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;
import com.example.oficina.services.ClienteService;
import com.example.oficina.services.PedidoService;



@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("menu")
	public String novoCliente(Model model) {
		List<Cliente> listaClientes = clienteService.findAll();
		model.addAttribute("listaClientes", listaClientes);
		return "principal";	
	}
	
	@GetMapping("novo")
	public String cadastro() {
		return "cadastrocliente";	
	}
	
	@PostMapping("salvar")
	public String salvarCliente(ClienteDTO clienteDto) {
		Cliente cliente = clienteDto.toCliente(clienteDto);
		clienteService.save(cliente);
		return "cadastrocliente";
		
	}
	
	
	@RequestMapping(value= "pedidos/{id}",method=RequestMethod.GET)
	public String pedidos(Model model,@PathVariable String id) {
		Long id2 = Long.parseLong(id);
		Optional<Cliente> cliente = clienteService.findById(id2);
		List<Pedido> pedidos = clienteService.findById(id2).get().getPedidos();
		model.addAttribute("clienteNome", cliente.get().getNomeCliente());
		model.addAttribute("clienteTelefone", cliente.get().getTelefoneCliente());
		model.addAttribute("listaPedidos", pedidos);
	
		return "pedidocliente";
		
	
	}
	
	@GetMapping("novospedidos")
	public String cadastrarPedidos() {
		return "cadastrocliente";	
	}
	
}
