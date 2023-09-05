package com.example.oficina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;
import com.example.oficina.repositories.PedidoRepository;
@Service
public class PedidoService {

	@Autowired 
	PedidoRepository pedidoRepository;
	
	
	public void save(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> findById(Long id) {
		return pedidoRepository.findById(id);
	}
	public void update(Pedido pedido,Long idPedido) {
		Optional<Pedido> pedido1 = pedidoRepository.findById(idPedido);
		Pedido pedido3 = pedido1.get();
		if(!pedido.getNomeAparelho().isBlank() && !pedido.getNomeAparelho().isEmpty()) {
			pedido3.setNomeAparelho(pedido.getNomeAparelho());
		}
		if(!pedido.getModeloAparelho().isBlank() && !pedido.getModeloAparelho().isEmpty()) {
			pedido3.setModeloAparelho(pedido.getModeloAparelho());
		}
		if(pedido.getPecaValor()!=null) {
			if(!pedido.getPecaValor().toString().isBlank() && !pedido.getPecaValor().toString().isEmpty()) {
			pedido3.setPecaValor(pedido.getPecaValor());
			}
		 }
		if(pedido.getMaoObra()!=null) {
			if(!pedido.getMaoObra().toString().isBlank() && !pedido.getMaoObra().toString().isEmpty()) {
			pedido3.setMaoObra(pedido.getMaoObra());
			}
		}
		if(pedido.getDataEntrada()!=null) {
		 if(!pedido.getDataEntrada().toString().isBlank() &&!pedido.getDataEntrada().toString().isEmpty()) {
			pedido3.setDataEntrada(pedido.getDataEntrada());
			}
		}
		if(!pedido.getObservacao().isBlank() && !pedido.getObservacao().isEmpty()) {
			pedido3.setObservacao(pedido.getObservacao());
		}
		pedido3.atualizarTotalPedido();
		pedido3.atulizarLucro();
		pedidoRepository.save(pedido3);
	
		
	}

}