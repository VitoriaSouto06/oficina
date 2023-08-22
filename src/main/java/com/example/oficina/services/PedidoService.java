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
		pedido3.setNomeAparelho(pedido.getNomeAparelho());
		pedido3.setModeloAparelho(pedido.getModeloAparelho());
		pedido3.setPecaValor(pedido.getPecaValor());
		pedido3.setMaoObra(pedido.getMaoObra());
		pedido3.setDataEntrada(pedido.getDataEntrada());
		pedido3.setDataSaida(pedido.getDataSaida());
		pedidoRepository.save(pedido3);
	
		
	}

}
