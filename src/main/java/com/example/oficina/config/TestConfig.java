package com.example.oficina.config;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.oficina.model.Cliente;
import com.example.oficina.model.Pedido;
import com.example.oficina.repositories.ClienteRepository;
import com.example.oficina.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente(null,"Vitoria Teste Pedido","232332434");
		Pedido pedido = new Pedido(null, "Radio", "Sonny", new BigDecimal("44.00"), new BigDecimal("80.00"), LocalDate.now(), LocalDate.now(), cliente);
		clienteRepository.save(cliente);
		pedidoRepository.save(pedido);
		
		Cliente cliente2 = new Cliente(null,"Teste usuario","2322345678434");
		Pedido pedido2 = new Pedido(null, "Prancha", "Mondial", new BigDecimal("44.00"), new BigDecimal("80.00"), LocalDate.now(), LocalDate.now(), cliente2);
		clienteRepository.save(cliente2);
		pedidoRepository.save(pedido2);
	}
}

