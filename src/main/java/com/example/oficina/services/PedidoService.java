package com.example.oficina.services;

import java.util.List;

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
}
