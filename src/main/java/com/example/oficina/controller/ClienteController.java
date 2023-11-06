package com.example.oficina.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.oficina.dto.ClienteDTO;
import com.example.oficina.dto.PedidoDTO;
import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;
import com.example.oficina.services.ClienteService;
import com.example.oficina.services.PedidoService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;



@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	PedidoService pedidoService;
	@GetMapping("inicio")
	public String inicio(Model model) {
		return "inicio";	
	}
	@GetMapping("menu")
	public String novoCliente(Model model) {
		List<Cliente> listaClientes = clienteService.findAll();
		model.addAttribute("listaClientes", listaClientes);
		return "principal";	
	}
	
	@GetMapping("novo")
	public String cadastro(ClienteDTO clienteDto) {
		return "cadastrocliente";	
	}
	
	@PostMapping("salvar")
	public String salvarCliente(@Valid ClienteDTO clienteDto,BindingResult result) {
		try{Cliente cliente = clienteDto.toCliente(clienteDto);
		clienteService.save(cliente);
		return "redirect:/cliente/menu";
	}catch(ConstraintViolationException e) {
		return "cadastrocliente";
	}
	}
	
	@GetMapping("excluircliente/{id}")
	public String excluirCliente(@PathVariable String id) {
		Long id2 = Long.parseLong(id);
		clienteService.deletebyId(id2);
		return "redirect:/cliente/menu";
		
	}
	
	@GetMapping("alterarcliente/{id}")
	public String alterarCliente(@PathVariable String id, Model model,ClienteDTO clienteDto) {
		Long id2 = Long.parseLong(id);
		Optional<Cliente> cliente = clienteService.findById(id2);
		Cliente cliente2 = cliente.get();
		model.addAttribute("clienteid",cliente2.getId());
		model.addAttribute("clientenome",cliente2.getNomeCliente());
		model.addAttribute("clientetelefone",cliente2.getTelefoneCliente());
		return "alterarcliente";
		
	}
	@PostMapping("salvaralteracaocliente/{id}")
	public String salvarAlteracaoCliente(ClienteDTO clienteDto, @PathVariable String id) {
		try {Long id2 = Long.parseLong(id);
		Cliente cliente = clienteDto.toCliente(clienteDto);
		clienteService.update(cliente, id2);
		return "redirect:/cliente/menu";
		}catch(ConstraintViolationException e) {
			return "cadastrocliente";
		}
		
		
	}
	
	@GetMapping("pedidos/{id}")
	public String pedidos(Model model,@PathVariable String id) {
		Long id2 = Long.parseLong(id);
		Optional<Cliente> cliente = clienteService.findById(id2);
		List<Pedido> pedidos = clienteService.findById(id2).get().getPedidos();
		model.addAttribute("clienteNome", cliente.get().getNomeCliente());
		model.addAttribute("clienteTelefone", cliente.get().getTelefoneCliente());
		model.addAttribute("listaPedidos", pedidos);
		model.addAttribute("clienteid", cliente.get().getId());
	
		return "pedidocliente";
		
	
	}
	
	@GetMapping("novopedido/{id}")
	public String cadastrarPedidos(@PathVariable String id,Model model) {
		Long id2 = Long.parseLong(id);
		Optional<Cliente> cliente = clienteService.findById(id2);
		model.addAttribute("clienteid", cliente.get().getId());
		return "cadastropedido";	
	}
	

	@PostMapping("salvarpedido/{id}")
	public String salvarPedido(PedidoDTO pedidoDto,@PathVariable String id) {
		Long id2 = Long.parseLong(id);
		Optional<Cliente> cliente = clienteService.findById(id2);
		Pedido pedido= pedidoDto.novoPedido(pedidoDto,cliente.get());
		pedidoService.save(pedido);
		return "redirect:/cliente/menu";
		
	}
	
	@GetMapping("alterarpedido/{id}/{clienteid}")
	public String alterarPedido(@PathVariable String id, @PathVariable String clienteid,Model model, PedidoDTO pedidoDto) {
		Long id2 = Long.parseLong(id);
		Long clienteid2 = Long.parseLong(clienteid);

		Optional<Pedido> pedido = pedidoService.findById(id2);
		Optional<Cliente> cliente = clienteService.findById(clienteid2);
		Pedido pedido2 = pedido.get();
		Cliente cliente2 = cliente.get();
		model.addAttribute("pedidoId",pedido2.getId());
		model.addAttribute("clienteId", cliente2.getId());
		model.addAttribute("pedidoNomeAparelho",pedido2.getNomeAparelho());
		model.addAttribute("pedidoNomeModelo", pedido2.getModeloAparelho());
		model.addAttribute("pedidoValorPeca", pedido2.getPecaValor());
		model.addAttribute("pedidoValorMao", pedido2.getMaoObra());
		model.addAttribute("pedidoDataEntrada", pedido2.getDataEntrada());
		model.addAttribute("observacao", pedido2.getObservacao());

		return "alterarpedido";
		
	}
	@PostMapping("salvaralteracaopedido/{id}/{clienteid}")
	public String salvarAlteracaoPedido(PedidoDTO pedidoDto, @PathVariable String id, @PathVariable String clienteid) {
		try {Long id2 = Long.parseLong(id);
			Long clienteid2 = Long.parseLong(clienteid);
			Optional<Cliente> cliente = clienteService.findById(clienteid2);
			Cliente cliente2 = cliente.get();
			Pedido pedido = pedidoDto.toPedido(pedidoDto,cliente2);
			pedidoService.update(pedido,id2);
		return "redirect:/cliente/menu";
		}catch(ConstraintViolationException e) {
			return "cadastrocliente";
		}	
	}
	
	@GetMapping("pesquisa")
	public String pesquisarCliente(@RequestParam("nome") String nome,Model model) {
		List<Cliente> clientes = clienteService.findByNome(nome);
		if(!clientes.isEmpty()) {
			model.addAttribute("listaClientes", clientes);
			return "principal";	
		}else {
			return "naoencontrado";
		}
		
	}
	
	@GetMapping("encerrar/{id}/{clienteid}")
	public String encerrarPedido(@PathVariable String id, @PathVariable String clienteid,Model model, PedidoDTO pedidoDto) {
		LocalDate now = LocalDate.now(); 
		Long id2 = Long.parseLong(id);
		Long clienteid2 = Long.parseLong(clienteid);

		Optional<Pedido> pedido = pedidoService.findById(id2);
		Optional<Cliente> cliente = clienteService.findById(clienteid2);
		Pedido pedido2 = pedido.get();
		Cliente cliente2 = cliente.get();
		pedido2.setDataSaida(now);
		pedidoService.save(pedido2);
		return "redirect:/cliente/pedidos/"+clienteid2;
		
	}
	@GetMapping("aprovado/{id}/{clienteid}")
	public String pedidoAprovado(@PathVariable String id, @PathVariable String clienteid,Model model, PedidoDTO pedidoDto) {
		LocalDate now = LocalDate.now(); 
		Long id2 = Long.parseLong(id);
		Long clienteid2 = Long.parseLong(clienteid);

		Optional<Pedido> pedido = pedidoService.findById(id2);
		Optional<Cliente> cliente = clienteService.findById(clienteid2);
		Pedido pedido2 = pedido.get();
		Cliente cliente2 = cliente.get();
		pedido2.setStatusPedido("Aprovado");
		pedidoService.save(pedido2);
		return "redirect:/cliente/pedidos/"+clienteid2;
		
	}
	@GetMapping("reprovado/{id}/{clienteid}")
	public String pedidoReprovado(@PathVariable String id, @PathVariable String clienteid,Model model, PedidoDTO pedidoDto) {
		LocalDate now = LocalDate.now(); 
		Long id2 = Long.parseLong(id);
		Long clienteid2 = Long.parseLong(clienteid);

		Optional<Pedido> pedido = pedidoService.findById(id2);
		Optional<Cliente> cliente = clienteService.findById(clienteid2);
		Pedido pedido2 = pedido.get();
		Cliente cliente2 = cliente.get();
		pedido2.setStatusPedido("Reprovado");
		pedidoService.save(pedido2);
		return "redirect:/cliente/pedidos/"+clienteid2;
		
	}
}